package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Prompt list changed notification
 */
public class PromptListChangedNotification extends JSONRPCNotification {
	private NotificationParams params;

	public PromptListChangedNotification() {
		setMethod("notifications/prompts/list_changed");
	}

	public NotificationParams getTypedParams() {
		return params;
	}

	public void setTypedParams(NotificationParams params) {
		this.params = params;
	}
}
