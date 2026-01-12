package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Prompt reference
 */
public class PromptReference implements BaseMetadata {
	private String type = "ref/prompt";
	private String name;
	private String title;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}
}
