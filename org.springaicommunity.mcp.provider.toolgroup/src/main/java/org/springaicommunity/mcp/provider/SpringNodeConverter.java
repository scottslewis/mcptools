package org.springaicommunity.mcp.provider;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import io.modelcontextprotocol.json.McpJsonDefaults;
import io.modelcontextprotocol.json.McpJsonMapper;
import io.modelcontextprotocol.mcptools.common.AnnotationsNode;
import io.modelcontextprotocol.mcptools.common.GroupNode;
import io.modelcontextprotocol.mcptools.common.GroupNodeConverter;
import io.modelcontextprotocol.mcptools.common.PromptArgumentNode;
import io.modelcontextprotocol.mcptools.common.PromptNode;
import io.modelcontextprotocol.mcptools.common.PromptNodeConverter;
import io.modelcontextprotocol.mcptools.common.ResourceNode;
import io.modelcontextprotocol.mcptools.common.ResourceNodeConverter;
import io.modelcontextprotocol.mcptools.common.ToolAnnotationsNode;
import io.modelcontextprotocol.mcptools.common.ToolNode;
import io.modelcontextprotocol.mcptools.common.ToolNodeConverter;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpSchema.Annotations;
import io.modelcontextprotocol.spec.McpSchema.Group;
import io.modelcontextprotocol.spec.McpSchema.Prompt;
import io.modelcontextprotocol.spec.McpSchema.PromptArgument;
import io.modelcontextprotocol.spec.McpSchema.Resource;
import io.modelcontextprotocol.spec.McpSchema.Role;
import io.modelcontextprotocol.spec.McpSchema.Tool;
import io.modelcontextprotocol.spec.McpSchema.ToolAnnotations;

public class SpringNodeConverter implements ToolNodeConverter<Tool>, GroupNodeConverter<Group>,
		ResourceNodeConverter<Resource>, PromptNodeConverter<Prompt> {

	protected GroupNodeConverter groupNodeConverter = new GroupNodeConverter();
	protected PromptArgumentNodeConverter promptArgumentNodeConverter = new PromptArgumentNodeConverter();
	protected PromptNodeConverter promptNodeConverter = new PromptNodeConverter();
	protected AnnotationsNodeConverter annotationsNodeConverter = new AnnotationsNodeConverter();
	protected ResourceNodeConverter resourceNodeConverter = new ResourceNodeConverter();
	protected ToolAnnotationsNodeConverter toolAnnotationsNodeConverter = new ToolAnnotationsNodeConverter();
	protected ToolNodeConverter toolNodeConverter = new ToolNodeConverter();

	McpJsonMapper jsonMapper = McpJsonDefaults.getDefaultMcpJsonMapper();

	public class GroupNodeConverter implements Function<GroupNode, Group> {

		@Override
		public Group apply(GroupNode gn) {
			McpSchema.Group.Builder builder = new McpSchema.Group.Builder();
			builder.name(gn.getName());
			builder.title(gn.getTitle());
			builder.description(gn.getDescription());
			builder.meta(gn.getMeta());
			GroupNode parent = gn.getParent();
			if (parent != null) {
				builder.parent(apply(parent));
			}
			return builder.build();
		}
	}

	public class PromptArgumentNodeConverter implements Function<PromptArgumentNode, PromptArgument> {
		@Override
		public PromptArgument apply(PromptArgumentNode pan) {
			return new PromptArgument(pan.getName(), pan.getTitle(), pan.getDescription(), pan.isRequired());
		}
	}

	public class PromptNodeConverter implements Function<PromptNode, Prompt> {

		@Override
		public Prompt apply(PromptNode pn) {
			List<PromptArgumentNode> promptArgumentNodes = pn.getPromptArguments();
			List<PromptArgument> promptArguments = null;
			if (promptArgumentNodes != null) {
				promptArguments = promptArgumentNodes.stream().map(pan -> {
					return (PromptArgument) promptArgumentNodeConverter.apply(pan);
				}).collect(Collectors.toList());
			}
			List<GroupNode> groups = pn.getParentGroups();
			List<McpSchema.Group> grps = null;
			if (groups != null) {
				grps = groups.stream().map(grp -> {
					return groupNodeConverter.apply(grp);
				}).collect(Collectors.toList());
			}
			return new McpSchema.Prompt(pn.getName(), grps, pn.getTitle(), pn.getDescription(), promptArguments,
					pn.getMeta());
		}

	}

	public class AnnotationsNodeConverter implements Function<AnnotationsNode, Annotations> {

		@Override
		public Annotations apply(AnnotationsNode an) {
			List<Role> audience = an.getAudience().stream().map(rn -> {
				Role result = null;
				switch (rn) {
				case USER:
					result = Role.USER;
					break;
				case ASSISTANT:
					result = Role.ASSISTANT;
					break;
				}
				return result;
			}).toList();
			return new Annotations(audience, an.getPriority(), an.getLastModified());
		}
	}

	public class ResourceNodeConverter implements Function<ResourceNode, Resource> {

		@Override
		public Resource apply(ResourceNode rn) {
			McpSchema.Resource.Builder resourceBuilder = new McpSchema.Resource.Builder();
			resourceBuilder.name(rn.getName());
			resourceBuilder.title(rn.getTitle());
			resourceBuilder.description(rn.getDescription());
			resourceBuilder.uri(rn.getUri());
			resourceBuilder.size(rn.getSize());
			resourceBuilder.mimeType(rn.getMimeType());
			resourceBuilder.meta(rn.getMeta());
			AnnotationsNode an = rn.getAnnotations();
			if (an != null) {
				resourceBuilder.annotations(annotationsNodeConverter.apply(an));
			}
			return resourceBuilder.build();
		}

	}

	public class ToolAnnotationsNodeConverter implements Function<ToolAnnotationsNode, ToolAnnotations> {

		@Override
		public ToolAnnotations apply(ToolAnnotationsNode tan) {
			return new ToolAnnotations(tan.getTitle(), tan.getReadOnlyHint(), tan.getDestructiveHint(),
					tan.getIdempotentHint(), tan.getOpenWorldHint(), tan.getReturnDirect());
		}

	}

	public class ToolNodeConverter implements Function<ToolNode, Tool> {

		@Override
		public Tool apply(ToolNode tn) {
			McpSchema.Tool.Builder builder = new McpSchema.Tool.Builder();
			builder.name(tn.getName());
			builder.title(tn.getTitle());
			builder.description(tn.getDescription());
			String inputSchema = tn.getInputSchema();
			if (inputSchema != null) {
				builder.inputSchema(jsonMapper, inputSchema);
			}
			String outputSchema = tn.getOutputSchema();
			if (outputSchema != null) {
				builder.outputSchema(jsonMapper, outputSchema);
			}
			builder.meta(tn.getMeta());
			ToolAnnotationsNode tan = tn.getToolAnnotations();
			builder.annotations((tan != null) ? toolAnnotationsNodeConverter.apply(tan) : null);
			List<GroupNode> parentGroupNodes = tn.getParentGroups();
			if (parentGroupNodes != null) {
				List<McpSchema.Group> parentGroups = parentGroupNodes.stream().map(pgn -> {
					return groupNodeConverter.apply(pgn);
				}).collect(Collectors.toList());
				if (parentGroups.size() > 0) {
					builder.groups(parentGroups);
				}
			}
			return builder.build();
		}
	}

	@Override
	public Tool convertToolNode(ToolNode toolNode) {
		return toolNodeConverter.apply(toolNode);
	}

	@Override
	public Prompt convertPromptNode(PromptNode tn) {
		return promptNodeConverter.apply(tn);
	}

	@Override
	public Resource convertResourceNode(ResourceNode resourceNode) {
		return resourceNodeConverter.apply(resourceNode);
	}

	@Override
	public Group convertGroupNode(GroupNode groupNode) {
		return groupNodeConverter.apply(groupNode);
	}

}
