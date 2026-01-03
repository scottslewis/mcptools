package org.springaicommunity.mcp.provider;

import io.modelcontextprotocol.mcptools.common.util.StringUtils;
import io.modelcontextprotocol.mcptools.toolgroup.AbstractToolNodeProvider;
import io.modelcontextprotocol.spec.McpSchema.Group;

public class SpringToolNodeProvider extends AbstractToolNodeProvider<Group> {

	public SpringToolNodeProvider() {
		super();
		setInputSchemaGenerator(new SpringInputSchemaGenerator());
	}

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

	public static class Async extends SpringToolNodeProvider {

		public Async() {
			super();
			setOutputSchemaGenerator(new SpringOutputSchemaGenerator.Async());
		}

	}

	public static class Sync extends SpringToolNodeProvider {

		public Sync() {
			super();
			setOutputSchemaGenerator(new SpringOutputSchemaGenerator.Sync());
		}

	}

}
