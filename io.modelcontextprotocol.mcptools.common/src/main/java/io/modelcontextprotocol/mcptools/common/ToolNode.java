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

	@Override
	public String toString() {
		return "ToolNode [name=" + name + ", title=" + title + ", description=" + description + ", meta=" + meta
				+ ", inputSchema=" + inputSchema + ", outputSchema=" + outputSchema + ", toolAnnotation="
				+ toolAnnotations + "]";
	}

}
