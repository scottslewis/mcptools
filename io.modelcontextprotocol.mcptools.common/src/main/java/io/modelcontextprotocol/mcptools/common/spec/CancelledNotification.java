package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Cancelled notification
 */
public class CancelledNotification extends JSONRPCNotification {
	private CancelledNotificationParams params;

	public CancelledNotification() {
		setMethod("notifications/cancelled");
	}

	public CancelledNotificationParams getTypedParams() {
		return params;
	}

	public void setTypedParams(CancelledNotificationParams params) {
		this.params = params;
	}
}
