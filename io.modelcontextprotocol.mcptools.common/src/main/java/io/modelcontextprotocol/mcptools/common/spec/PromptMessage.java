package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Prompt message
 */
public class PromptMessage {
	private Role role;
	private ContentBlock content;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public ContentBlock getContent() {
		return content;
	}

	public void setContent(ContentBlock content) {
		this.content = content;
	}
}
