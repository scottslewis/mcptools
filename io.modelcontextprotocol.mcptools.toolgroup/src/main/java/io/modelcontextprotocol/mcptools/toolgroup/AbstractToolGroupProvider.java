package io.modelcontextprotocol.mcptools.toolgroup;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import io.modelcontextprotocol.mcptools.annotation.McpTool;
import io.modelcontextprotocol.mcptools.annotation.McpToolGroup;
import io.modelcontextprotocol.mcptools.annotation.util.StringUtils;
import io.modelcontextprotocol.mcptools.common.GroupNode;
import io.modelcontextprotocol.mcptools.common.ToolNode;
import io.modelcontextprotocol.mcptools.json.JsonObjectMapper;

public abstract class AbstractToolGroupProvider<SpecificationType, ToolType, GroupType, ExchangeType, CallRequestType, CallResultType>
		implements ToolGroupProvider<SpecificationType> {

	public static final String SEPARATOR = ".";

	protected JsonObjectMapper jsonMapper;
	protected AbstractToolNodeProvider<GroupType> toolNodeProvider;
	protected AbstractCallHandlerProvider<ExchangeType, CallRequestType, CallResultType> callHandlerProvider;

	protected AbstractToolGroupProvider() {
	}

	protected void setToolNodeProvider(AbstractToolNodeProvider<GroupType> toolNodeProvider) {
		this.toolNodeProvider = toolNodeProvider;
	}

	protected void setCallHandlerProvider(
			AbstractCallHandlerProvider<ExchangeType, CallRequestType, CallResultType> callHandlerProvider) {
		this.callHandlerProvider = callHandlerProvider;
	}

	protected void setJsonObjectMapper(JsonObjectMapper jsonMapper) {
		this.jsonMapper = jsonMapper;
	}

	protected GroupNode createGroupNode(String name, String title, String description, GroupNode parent,
			Map<String, Object> meta) {
		GroupNode groupNode = new GroupNode(name);
		groupNode.setTitle(StringUtils.cleanAnnotationString(title));
		groupNode.setDescription(StringUtils.cleanAnnotationString(description));
		if (parent != null) {
			groupNode.setParent(parent);
		}
		return groupNode;
	}

	protected GroupNode getToolGroupNode(McpToolGroup annotation, Class<?> clazz) {
		// First look for McpToolGroup annotations on package hierarchy
		GroupNode parentGroupNode = getToolGroupNodeFromPackage(clazz.getPackage(), clazz.getClassLoader());

		String parentGroupName = annotation.name();
		if (!StringUtils.hasText(parentGroupName)) {
			if (parentGroupNode != null) {
				parentGroupName = clazz.getSimpleName();
			} else {
				parentGroupName = clazz.getName();
			}
		}
		return createGroupNode(parentGroupName, annotation.title(), annotation.description(), parentGroupNode, null);
	}

	protected Package getParentPackage(String packageName, ClassLoader classLoader) {
		String packageInfoClassname = packageName + ".package-info";
		try {
			return classLoader.loadClass(packageInfoClassname).getPackage();
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	protected GroupNode getToolGroupNodeFromPackage(Package p, ClassLoader classloader) {
		McpToolGroup packageAnnotation = p.getAnnotation(McpToolGroup.class);
		// Get parent package
		if (packageAnnotation != null) {
			GroupNode parentGroup = null;
			String currentPackageName = p.getName();
			String parentPackageName = null;
			String childPackageName = null;
			int lastDotIndex = currentPackageName.lastIndexOf(SEPARATOR);
			if (lastDotIndex > 0 && lastDotIndex < currentPackageName.length()) {
				parentPackageName = currentPackageName.substring(0, lastDotIndex);
				childPackageName = currentPackageName.substring(lastDotIndex + 1);
			}

			if (parentPackageName != null) {
				Package parentPackage = getParentPackage(parentPackageName, classloader);
				if (parentPackage != null) {
					parentGroup = getToolGroupNodeFromPackage(parentPackage, classloader);
				}
			}

			String packageGroupName = packageAnnotation.name();
			// if no annotation name specified
			if (!StringUtils.hasText(packageGroupName)) {
				packageGroupName = (parentGroup != null) ? childPackageName : currentPackageName;
			}
			return createGroupNode(packageGroupName, packageAnnotation.title(), packageAnnotation.description(),
					parentGroup, null);
		}
		return null;
	}

	protected Method[] getMethodsForClass(Class<?> toolClass) {
		// For interfaces, getMethods() gets super interface methods
		if (toolClass.isInterface()) {
			return toolClass.getMethods();
		} else {
			// Get only the declared methods
			return toolClass.getDeclaredMethods();
		}
	}

	protected GroupNode getToolGroup(Class<?> clazz) {
		McpToolGroup tgAnnotation = clazz.getAnnotation(McpToolGroup.class);
		return tgAnnotation != null ? getToolGroupNode(tgAnnotation, clazz) : null;
	}

	protected Class<?>[] getClassesForObject(Object toolObject, Class<?>[] classes) {
		return (classes.length == 0) ? new Class[] { toolObject.getClass() } : classes;
	}

	protected abstract SpecificationType buildSpecification(ToolNode toolNode,
			BiFunction<ExchangeType, CallRequestType, CallResultType> callHandler);

	protected SpecificationType getToolGroupSpecification(Object toolObject, Method mcpToolMethod,
			GroupNode toolGroup) {
		// Get annotation
		McpTool toolJavaAnnotation = mcpToolMethod.getAnnotation(McpTool.class);
		// Get ToolNode for annotation, method, and toolGroup
		Objects.requireNonNull(toolJavaAnnotation,
				"No java annotation found for annotated method=" + mcpToolMethod.getName());
		ToolNode toolNode = this.toolNodeProvider.getToolNode(toolJavaAnnotation, mcpToolMethod, toolGroup);
		// set the call handler provider to use structured output if the outputSchema
		// has been created
		this.callHandlerProvider.setUseStructuredOutput(toolNode.getOutputSchema() != null);
		// Get callhandler from callHandlerProvider
		BiFunction<ExchangeType, CallRequestType, CallResultType> callHandler = this.callHandlerProvider
				.getCallHandler(mcpToolMethod, toolObject);
		// Build specification with Tool and callHandler
		return buildSpecification(toolNode, callHandler);
	}

	protected abstract Stream<Method> filterMethodStream(Stream<Method> inputStream);

	public List<SpecificationType> getToolGroupSpecifications(Object toolObject, Class<?> toolClass,
			GroupNode toolGroup) {
		return filterMethodStream(Stream.of(getMethodsForClass(toolClass))
				// first filter for the McpTool annotation
				.filter(method -> method.isAnnotationPresent(McpTool.class)))
				// After the the sub-class specific impl of filterMethodStream returns
				// then sort call getToolGroupSpecification for given object, mcpToolMethod and
				.sorted((m1, m2) -> m1.getName().compareTo(m2.getName())).map(mcpToolMethod -> {
					return (SpecificationType) getToolGroupSpecification(toolObject, mcpToolMethod, toolGroup);
				}).toList();
	}

	public List<SpecificationType> getToolGroupSpecifications(List<Object> toolObjects, Class<?>... classes) {
		return toolObjects.stream().map(toolObject -> {
			return Stream.of(getClassesForObject(toolObject, classes)).map(toolClass -> {
				GroupNode toolGroup = getToolGroup(toolClass);
				return (List<SpecificationType>) getToolGroupSpecifications(toolObject, toolClass, toolGroup);
			}).flatMap(List::stream).toList();
		}).flatMap(List::stream).toList();
	}

}
