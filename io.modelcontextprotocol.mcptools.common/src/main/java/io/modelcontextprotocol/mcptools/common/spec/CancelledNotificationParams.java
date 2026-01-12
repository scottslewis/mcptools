package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Cancelled notification parameters
 */
public class CancelledNotificationParams extends NotificationParams {
	private RequestId requestId;
	private String reason;

	public RequestId getRequestId() {
		return requestId;
	}

	public void setRequestId(RequestId requestId) {
		this.requestId = requestId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
