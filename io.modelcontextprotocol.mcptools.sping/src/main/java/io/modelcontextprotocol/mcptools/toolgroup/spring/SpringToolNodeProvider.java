package io.modelcontextprotocol.mcptools.toolgroup.spring;

import io.modelcontextprotocol.mcptools.annotation.util.StringUtils;
import io.modelcontextprotocol.mcptools.toolgroup.AbstractToolNodeProvider;
import io.modelcontextprotocol.spec.McpSchema.Group;

public class SpringToolNodeProvider extends AbstractToolNodeProvider<Group> {

	@Override
	protected Group createGroup(String name, String title, String description, Group parent) {
		return Group.builder().name(StringUtils.cleanAnnotationString(name))
				.title(StringUtils.cleanAnnotationString(title))
				.description(StringUtils.cleanAnnotationString(description)).parent(parent).build();
	}

	@Override
	protected String getFullyQualifiedGroupName(Group parentGroup) {
		return parentGroup.getFullyQualifiedName(SEPARATOR);
	}

}
