package org.springaicommunity.mcp.provider;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import io.modelcontextprotocol.mcptools.common.RoleNode;
import io.modelcontextprotocol.mcptools.common.ToolAnnotationsNode;
import io.modelcontextprotocol.mcptools.common.ToolNode;
import io.modelcontextprotocol.mcptools.common.ToolNodeConverter;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpSchema.Annotations;
import io.modelcontextprotocol.spec.McpSchema.Group;
import io.modelcontextprotocol.spec.McpSchema.JsonSchema;
import io.modelcontextprotocol.spec.McpSchema.Prompt;
import io.modelcontextprotocol.spec.McpSchema.PromptArgument;
import io.modelcontextprotocol.spec.McpSchema.Resource;
import io.modelcontextprotocol.spec.McpSchema.Role;
import io.modelcontextprotocol.spec.McpSchema.Tool;
import io.modelcontextprotocol.spec.McpSchema.ToolAnnotations;

public class SpringNodeConverter implements ToolNodeConverter<Tool>, GroupNodeConverter<Group>,
		ResourceNodeConverter<Resource>, PromptNodeConverter<Prompt> {

	protected GroupNodeConverter<Group> groupNodeConverter = new SpringGroupNodeConverter();
	protected SpringPromptArgumentNodeConverter promptArgumentNodeConverter = new SpringPromptArgumentNodeConverter();
	protected SpringPromptNodeConverter promptNodeConverter = new SpringPromptNodeConverter();
	protected SpringAnnotationsNodeConverter annotationsNodeConverter = new SpringAnnotationsNodeConverter();
	protected SpringResourceNodeConverter resourceNodeConverter = new SpringResourceNodeConverter();
	protected ToolAnnotationsNodeConverter toolAnnotationsNodeConverter = new ToolAnnotationsNodeConverter();
	protected ToolNodeConverter<Tool> toolNodeConverter = new SpringToolNodeConverter();

	McpJsonMapper jsonMapper = McpJsonDefaults.getDefaultMcpJsonMapper();

	public class SpringGroupNodeConverter implements GroupNodeConverter<Group> {

		@Override
		public Group convertFromGroupNode(GroupNode gn) {
			McpSchema.Group.Builder builder = new McpSchema.Group.Builder();
			builder.name(gn.getName());
			builder.title(gn.getTitle());
			builder.description(gn.getDescription());
			builder.meta(gn.getMeta());
			GroupNode parent = gn.getParent();
			if (parent != null) {
				builder.parent(convertFromGroupNode(parent));
			}
			return builder.build();
		}

		@Override
		public GroupNode convertToGroupNode(Group group) {
			String groupName = group.name();
			GroupNode gtn = groupNodeCache.get(groupName);
			if (gtn == null) {
				gtn = new GroupNode(groupName);
				groupNodeCache.put(groupName, gtn);
			}
			gtn.setTitle(group.title());
			gtn.setDescription(group.description());
			gtn.setMeta(group.meta());
			McpSchema.Group parent = group.parent();
			if (parent != null) {
				gtn.setParent(convertToGroupNode(parent));
			}
			return gtn;	
		}
		
	}

	public class SpringPromptArgumentNodeConverter {
		public PromptArgument convertFromPromptArgumentNode(PromptArgumentNode pan) {
			return new PromptArgument(pan.getName(), pan.getTitle(), pan.getDescription(), pan.isRequired());
		}
		
		public PromptArgumentNode convertToPromptArgumentNode(PromptArgument pa) {
			PromptArgumentNode pan = new PromptArgumentNode(pa.name());
			pan.setTitle(pa.title());
			pan.setDescription(pa.description());
			pan.setRequired(pa.required());
			return pan;
		}

	}

	public class SpringPromptNodeConverter implements PromptNodeConverter<Prompt> {

		@Override
		public Prompt convertFromPromptNode(PromptNode pn) {
			List<PromptArgumentNode> promptArgumentNodes = pn.getPromptArguments();
			List<PromptArgument> promptArguments = null;
			if (promptArgumentNodes != null) {
				promptArguments = promptArgumentNodes.stream().map(pan -> {
					return promptArgumentNodeConverter.convertFromPromptArgumentNode(pan);
				}).collect(Collectors.toList());
			}
			List<GroupNode> groups = pn.getParentGroups();
			List<McpSchema.Group> grps = null;
			if (groups != null) {
				grps = groups.stream().map(grp -> {
					return groupNodeConverter.convertFromGroupNode(grp);
				}).collect(Collectors.toList());
			}
			return new McpSchema.Prompt(pn.getName(), grps, pn.getTitle(), pn.getDescription(), promptArguments,
					pn.getMeta());
		}

		@Override
		public PromptNode convertToPromptNode(Prompt prompt) {
			PromptNode promptNode = new PromptNode(prompt.name());
			promptNode.setDescription(prompt.description());
			promptNode.setTitle(prompt.title());
			promptNode.setMeta(prompt.meta());
			return promptNode;
		}

	}

	public class SpringAnnotationsNodeConverter {

		public Annotations convertFromAnnotationsNode(AnnotationsNode an) {
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
		
		public AnnotationsNode convertToAnnotationsNode(Annotations a) {
			List<RoleNode> audience = a.audience().stream().map(r -> {
				RoleNode result = null;
				switch (r) {
				case USER:
					result = RoleNode.USER;
					break;
				case ASSISTANT:
					result = RoleNode.ASSISTANT;
					break;
				}
				return result;
			}).toList();
			return new AnnotationsNode(audience, a.priority(), a.lastModified());
		}

	}

	public class SpringResourceNodeConverter {

		public Resource convertFromResourceNode(ResourceNode rn) {
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
				resourceBuilder.annotations(annotationsNodeConverter.convertFromAnnotationsNode(an));
			}
			return resourceBuilder.build();
		}
		
		public ResourceNode convertToResourceNode(Resource r) {
			ResourceNode rn = new ResourceNode(r.name());
			Annotations a = r.annotations();
			if (a != null) {
				rn.setAnnotations(annotationsNodeConverter.convertToAnnotationsNode(a));
			}
			rn.setDescription(r.description());
			rn.setUri(r.uri());
			rn.setTitle(r.title());
			rn.setMimeType(r.mimeType());
			rn.setMeta(r.meta());
			return rn;
		}

	}

	public class ToolAnnotationsNodeConverter {

		public ToolAnnotations convertFromToolAnnotationsNode(ToolAnnotationsNode tan) {
			return new ToolAnnotations(tan.getTitle(), tan.getReadOnlyHint(), tan.getDestructiveHint(),
					tan.getIdempotentHint(), tan.getOpenWorldHint(), tan.getReturnDirect());
		}
		
		public ToolAnnotationsNode convertToToolAnnotationsNode(ToolAnnotations t) {
			ToolAnnotationsNode tan = new ToolAnnotationsNode();
			tan.setTitle(t.title());
			tan.setDestructiveHint(t.destructiveHint());
			tan.setIdempotentHint(t.idempotentHint());
			tan.setOpenWorldHint(t.openWorldHint());
			tan.setReadOnlyHint(t.readOnlyHint());
			tan.setReturnDirect(t.returnDirect());
			return tan;
		}
		

	}

	protected String generateInputSchema(JsonSchema inputSchema) {
		if (inputSchema == null) return null;
		try {
			return jsonMapper.writeValueAsString(inputSchema);
		} catch (IOException e) {
			throw new IllegalArgumentException("Invalid input schema: " + inputSchema, e);		
		}
	}
	
	protected String generateOutputSchema(Map<String, Object> outputSchema) {
		if (outputSchema == null) return null;
		try {
			return jsonMapper.writeValueAsString(outputSchema);
		} catch (IOException e) {
			throw new IllegalArgumentException("Invalid output schema: " + outputSchema, e);		
		}
	}

	public class SpringToolNodeConverter implements ToolNodeConverter<Tool> {

		@Override
		public Tool convertFromToolNode(ToolNode tn) {
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
			builder.annotations((tan != null) ? toolAnnotationsNodeConverter.convertFromToolAnnotationsNode(tan) : null);
			List<GroupNode> parentGroupNodes = tn.getParentGroups();
			if (parentGroupNodes != null) {
				List<McpSchema.Group> parentGroups = parentGroupNodes.stream().map(pgn -> {
					return groupNodeConverter.convertFromGroupNode(pgn);
				}).collect(Collectors.toList());
				if (parentGroups.size() > 0) {
					builder.groups(parentGroups);
				}
			}
			return builder.build();
		}

		@Override
		public ToolNode convertToToolNode(Tool tool) {
			ToolNode tn = new ToolNode(tool.name());
			tn.setTitle(tool.title());
			tn.setDescription(tool.description());
			tn.setMeta(tool.meta());
			tn.setInputSchema(generateInputSchema(tool.inputSchema()));
			tn.setOutputSchema(generateOutputSchema(tool.outputSchema()));
			McpSchema.ToolAnnotations a = tool.annotations();
			if (a != null) {
				tn.setToolAnnotations(toolAnnotationsNodeConverter.convertToToolAnnotationsNode(a));
			}
			List<McpSchema.Group> parentGroups = tool.groups();
			if (parentGroups != null) {
				parentGroups.forEach(pg -> {
					groupNodeConverter.convertToGroupNode(pg).addChildTool(tn);
				});
			}
			return tn;
		}
	}

	@Override
	public Tool convertFromToolNode(ToolNode toolNode) {
		return toolNodeConverter.convertFromToolNode(toolNode);
	}

	@Override
	public Prompt convertFromPromptNode(PromptNode tn) {
		return promptNodeConverter.convertFromPromptNode(tn);
	}

	@Override
	public Resource convertFromResourceNode(ResourceNode resourceNode) {
		return resourceNodeConverter.convertFromResourceNode(resourceNode);
	}

	@Override
	public Group convertFromGroupNode(GroupNode groupNode) {
		return groupNodeConverter.convertFromGroupNode(groupNode);
	}

	@Override
	public PromptNode convertToPromptNode(Prompt prompt) {
		return promptNodeConverter.convertToPromptNode(prompt);
	}

	@Override
	public ResourceNode convertToResourceNode(Resource resource) {
		return resourceNodeConverter.convertToResourceNode(resource);
	}

	private static final Map<String, GroupNode> groupNodeCache = new HashMap<String, GroupNode>();

	@Override
	public GroupNode convertToGroupNode(Group group) {
		return groupNodeConverter.convertToGroupNode(group);
	}

	@Override
	public ToolNode convertToToolNode(Tool tool) {
		return toolNodeConverter.convertToToolNode(tool);
	}

}
