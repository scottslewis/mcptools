package io.modelcontextprotocol.mcptools.toolgroup;

import java.lang.reflect.Method;

import io.modelcontextprotocol.mcptools.annotation.McpTool;
import io.modelcontextprotocol.mcptools.annotation.McpTool.McpAnnotations;
import io.modelcontextprotocol.mcptools.annotation.McpToolGroup;
import io.modelcontextprotocol.mcptools.common.GroupNode;
import io.modelcontextprotocol.mcptools.common.ToolAnnotationsNode;
import io.modelcontextprotocol.mcptools.common.ToolNode;
import io.modelcontextprotocol.mcptools.common.util.StringUtils;

public abstract class AbstractToolNodeProvider<GroupType> implements ToolNodeProvider {

	protected InputSchemaGenerator inputSchemaGenerator;
	protected OutputSchemaGenerator outputSchemaGenerator;

	public AbstractToolNodeProvider() {
	}

	public AbstractToolNodeProvider(InputSchemaGenerator inputSchemaGenerator) {
		this.inputSchemaGenerator = inputSchemaGenerator;
	}

	protected void setOutputSchemaGenerator(OutputSchemaGenerator outputSchemaGenerator) {
		this.outputSchemaGenerator = outputSchemaGenerator;
	}

	protected void setInputSchemaGenerator(InputSchemaGenerator inputSchemaGenerator) {
		this.inputSchemaGenerator = inputSchemaGenerator;
	}

	protected abstract GroupType createGroup(String name, String title, String description, GroupType parent);

	protected Package getParentPackage(String packageName, ClassLoader classLoader) {
		String packageInfoClassname = packageName + ".package-info";
		try {
			return classLoader.loadClass(packageInfoClassname).getPackage();
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	protected GroupType doGetToolGroup(McpToolGroup annotation, Class<?> clazz) {
		// First look for McpToolGroup annotations on package hierarchy
		GroupType parentGroup = getGroupFromPackage(clazz.getPackage(), clazz.getClassLoader());

		String parentGroupName = annotation.name();
		if (!StringUtils.hasText(parentGroupName)) {
			if (parentGroup != null) {
				parentGroupName = getFullyQualifiedGroupName(parentGroup) + SEPARATOR + clazz.getSimpleName();
			} else {
				parentGroupName = clazz.getName();
			}
		}
		return createGroup(parentGroupName, annotation.title(), annotation.description(), parentGroup);
	}

	protected GroupType getGroupFromPackage(Package p, ClassLoader classloader) {
		McpToolGroup packageAnnotation = getGroupAnnotation(p);
		// Get parent package
		if (packageAnnotation != null) {
			GroupType parentGroup = null;
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
					parentGroup = getGroupFromPackage(parentPackage, classloader);
				}
			}

			String packageGroupName = packageAnnotation.name();
			if (!StringUtils.hasText(packageGroupName)) {
				if (parentGroup != null) {
					packageGroupName = getFullyQualifiedGroupName(parentGroup) + SEPARATOR + childPackageName;
				} else {
					packageGroupName = currentPackageName;
				}
			}
			return createGroup(packageGroupName, packageAnnotation.title(), packageAnnotation.description(),
					parentGroup);
		}
		return null;
	}

	protected abstract String getFullyQualifiedGroupName(GroupType parentGroup);

	protected McpToolGroup getGroupAnnotation(Package p) {
		return p.getAnnotation(McpToolGroup.class);
	}

	protected McpToolGroup getGroupAnnotation(Class<?> toolObjectClass) {
		return toolObjectClass.getAnnotation(McpToolGroup.class);
	}

	protected String qualifyToolName(String toolName, GroupNode group) {
		return (group == null) ? toolName : group.getFullyQualifiedName(SEPARATOR) + SEPARATOR + toolName;
	}

	protected ToolAnnotationsNode getToolAnnotationsNode(McpAnnotations mcpToolAnnotations, ToolNode toolNode) {
		if (mcpToolAnnotations != null) {
			ToolAnnotationsNode toolAnnotationsNode = new ToolAnnotationsNode();
			toolAnnotationsNode.setTitle(StringUtils.cleanAnnotationString(mcpToolAnnotations.title()));
			toolAnnotationsNode.setDestructiveHint(mcpToolAnnotations.destructiveHint());
			toolAnnotationsNode.setIdempotentHint(mcpToolAnnotations.idempotentHint());
			toolAnnotationsNode.setOpenWorldHint(mcpToolAnnotations.openWorldHint());
			toolAnnotationsNode.setReadOnlyHint(mcpToolAnnotations.readOnlyHint());
			// if no title already set, set it to toolAnnotatoinsNode title
			if (toolNode.getTitle() == null) {
				toolNode.setTitle(toolAnnotationsNode.getTitle());
			}
			return toolAnnotationsNode;
		}
		return null;
	}

	@Override
	public ToolNode getToolNode(McpTool mcpToolAnnotation, Method mcpToolMethod, GroupNode group,
			boolean generateOutputSchema) {
		String name = StringUtils.cleanAnnotationString(mcpToolAnnotation.name());
		if (name == null) {
			name = mcpToolMethod.getName();
		}
		String fqName = qualifyToolName(name, group);

		ToolNode result = new ToolNode(fqName);
		if (group != null) {
			result.addParentGroup(group);
		}
		result.setDescription(StringUtils.cleanAnnotationString(mcpToolAnnotation.description()));
		result.setTitle(StringUtils.cleanAnnotationString(mcpToolAnnotation.title()));
		result.setToolAnnotations(getToolAnnotationsNode(mcpToolAnnotation.annotations(), result));
		result.setInputSchema(this.inputSchemaGenerator.generateInputSchema(mcpToolMethod));
		if (generateOutputSchema && this.outputSchemaGenerator != null) {
			result.setOutputSchema(this.outputSchemaGenerator.generateOutputSchema(mcpToolMethod));
		}
		return result;
	}

}
