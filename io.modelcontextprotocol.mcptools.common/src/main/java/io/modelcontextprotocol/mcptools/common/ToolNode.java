package io.modelcontextprotocol.mcptools.common;

public class ToolNode extends BaseLeafNode {

	protected String inputSchema;

	protected String outputSchema;

	protected ToolAnnotationsNode toolAnnotations;

	public ToolNode(String name) {
		super(name);
	}

	public String getInputSchema() {
		return inputSchema;
	}

	public void setInputSchema(String inputSchema) {
		this.inputSchema = inputSchema;
	}

	public String getOutputSchema() {
		return outputSchema;
	}

	public void setOutputSchema(String outputSchema) {
		this.outputSchema = outputSchema;
	}

	public ToolAnnotationsNode getToolAnnotations() {
		return toolAnnotations;
	}

	public void setToolAnnotations(ToolAnnotationsNode toolAnnotations) {
		this.toolAnnotations = toolAnnotations;
	}

//	public McpSchema.Tool.Builder convert() {
//		return convert(McpJsonDefaults.getDefaultMcpJsonMapper());
//	}
//
//	public McpSchema.Tool.Builder convert(McpJsonMapper jsonMapper) {
//		McpSchema.Tool.Builder builder = new McpSchema.Tool.Builder();
//		builder.name(getName());
//		builder.title(getTitle());
//		builder.description(getDescription());
//		String inputSchema = getInputSchema();
//		if (inputSchema != null) {
//			builder.inputSchema(jsonMapper, inputSchema);
//		}
//		String outputSchema = getOutputSchema();
//		if (outputSchema != null) {
//			builder.outputSchema(jsonMapper, outputSchema);
//		}
//		builder.meta(getMeta());
//		ToolAnnotationsNode an = getToolAnnotations();
//		builder.annotations((an != null) ? an.convert() : null);
//		LinkedHashSet<GroupNode> parentGroupNodes = getParentGroups();
//		if (parentGroupNodes != null) {
//			List<McpSchema.Group> parentGroups = parentGroupNodes.stream().map(pgn -> {
//				return pgn.convert().build();
//			}).collect(Collectors.toList());
//			if (parentGroups.size() > 0) {
//				builder.groups(parentGroups);
//			}
//		}
//		return builder;
//	}

	@Override
	public String toString() {
		return "ToolNode [name=" + name + ", title=" + title + ", description=" + description + ", meta=" + meta
				+ ", inputSchema=" + inputSchema + ", outputSchema=" + outputSchema + ", toolAnnotation="
				+ toolAnnotations + "]";
	}

}
