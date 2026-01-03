package io.modelcontextprotocol.mcptools.toolgroup;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import io.modelcontextprotocol.mcptools.common.util.StringUtils;
import io.modelcontextprotocol.mcptools.annotation.McpTool;
import io.modelcontextprotocol.mcptools.annotation.McpToolGroup;
import io.modelcontextprotocol.mcptools.common.GroupNode;
import io.modelcontextprotocol.mcptools.common.ToolNode;
import io.modelcontextprotocol.mcptools.json.JsonObjectMapper;

public abstract class AbstractToolGroupProvider<SpecificationType, ToolType, GroupType, ExchangeType, CallRequestType, CallResultType>
		implements ToolGroupProvider<SpecificationType> {

	public static final String SEPARATOR = ".";

	protected boolean generateOutputSchema = true;
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
		GroupNode parentGroupNode = getToolGroupNodeFromPackage(clazz.getPackage(), clazz.getClassLoader(), "");

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

	protected String[] splitPackageName(String packageName) {
		String parentPackageName = null;
		String childPackageName = null;
		int lastDotIndex = packageName.lastIndexOf(SEPARATOR);
		if (lastDotIndex > 0 && lastDotIndex < packageName.length()) {
			parentPackageName = packageName.substring(0, lastDotIndex);
			childPackageName = packageName.substring(lastDotIndex + 1);
		}
		return new String[] { parentPackageName, childPackageName };
	}
	
	protected GroupNode getToolGroupNodeFromPackage(Package p, ClassLoader classloader, String nameSuffix) {
		GroupNode parentGroup = null;
		String[] splitPackageName = splitPackageName(p.getName());
		if (StringUtils.hasText(splitPackageName[0])) {
			Package parentPackage = getParentPackage(splitPackageName[0], classloader);
			if (StringUtils.hasText(splitPackageName[1])) {
				nameSuffix = splitPackageName[1] + (StringUtils.hasText(nameSuffix) ? SEPARATOR + nameSuffix : "");
			}
			if (parentPackage != null) {
				parentGroup = getToolGroupNodeFromPackage(parentPackage, classloader, nameSuffix);
			}
		}
		String packageGroupName = (parentGroup == null) ? p.getName() : nameSuffix;
		
		McpToolGroup packageAnnotation = p.getAnnotation(McpToolGroup.class);
		if (packageAnnotation != null) {
			// Has annotation, get metadata from annotation
			String annotationName = packageAnnotation.name();
			packageGroupName = StringUtils.hasText(annotationName) ? annotationName : packageGroupName;
			return createGroupNode(packageGroupName, packageAnnotation.title(), packageAnnotation.description(),
					parentGroup, null);
		} else if (parentGroup != null) {
			// Doesn't have annotation, but has a parent, so create a GroupNode
			return createGroupNode(packageGroupName, null, null, parentGroup, null);
		}
		// No group node found
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

	protected McpTool getToolJavaAnnotation(Method mcpToolMethod) {
		return mcpToolMethod.getAnnotation(McpTool.class);
	}
	
	protected ToolNode getToolNode(McpTool toolJavaAnnotation, Method mcpToolMethod, GroupNode toolGroup) {
		return this.toolNodeProvider.getToolNode(toolJavaAnnotation, mcpToolMethod, toolGroup, this.generateOutputSchema);
	}
	
	protected BiFunction<ExchangeType, CallRequestType, CallResultType> getCallHandler(Method mcpToolMethod, Object toolObject, boolean outputSchema) {
		// set the call handler provider to use structured output if the outputSchema
		// has been created
		this.callHandlerProvider.setUseStructuredOutput(outputSchema);
		return this.callHandlerProvider.getCallHandler(mcpToolMethod, toolObject);
	}
	
	protected SpecificationType getToolGroupSpecification(Object toolObject, Method mcpToolMethod,
			GroupNode toolGroup) {
		// Get annotation
		McpTool toolJavaAnnotation = getToolJavaAnnotation(mcpToolMethod);
		// Get ToolNode for annotation, method, and toolGroup
		Objects.requireNonNull(toolJavaAnnotation,
				"No java annotation found for annotated method=" + mcpToolMethod.getName());
		ToolNode toolNode = getToolNode(toolJavaAnnotation, mcpToolMethod, toolGroup);
		// Get callhandler from callHandlerProvider
		BiFunction<ExchangeType, CallRequestType, CallResultType> callHandler = getCallHandler(mcpToolMethod, toolObject, toolNode.getOutputSchema() != null);
		// Build specification with Tool and callHandler
		return buildSpecification(toolNode, callHandler);
	}

	protected abstract Stream<Method> filterMethodStream(Stream<Method> inputStream);

	protected List<SpecificationType> getToolGroupSpecifications(Object toolObject, Class<?> toolClass,
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
