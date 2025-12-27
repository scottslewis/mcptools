package io.modelcontextprotocol.mcptools.common;

public class PromptArgumentNode extends BaseNode {

	protected boolean required;

	public PromptArgumentNode(String name) {
		super(name);
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public boolean isRequired() {
		return this.required;
	}

	@Override
	public String toString() {
		return "PromptArgumentNode [required=" + required + ", name=" + name + ", title=" + title + ", description="
				+ description + ", meta=" + meta + "]";
	}

}
