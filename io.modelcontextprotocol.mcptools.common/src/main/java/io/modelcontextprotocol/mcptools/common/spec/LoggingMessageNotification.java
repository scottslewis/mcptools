package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Logging message notification
 */
public class LoggingMessageNotification extends JSONRPCNotification {
	private LoggingMessageNotificationParams params;

	public LoggingMessageNotification() {
		setMethod("notifications/message");
	}

	public LoggingMessageNotificationParams getTypedParams() {
		return params;
	}

	public void setTypedParams(LoggingMessageNotificationParams params) {
		this.params = params;
	}
}
