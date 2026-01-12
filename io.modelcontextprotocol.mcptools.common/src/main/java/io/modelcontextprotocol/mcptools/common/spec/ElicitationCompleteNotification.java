package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Elicitation complete notification
 */
public class ElicitationCompleteNotification extends JSONRPCNotification {
	private ElicitationCompleteParams params;

	public ElicitationCompleteNotification() {
		setMethod("notifications/elicitation/complete");
	}

	public ElicitationCompleteParams getTypedParams() {
		return params;
	}

	public void setTypedParams(ElicitationCompleteParams params) {
		this.params = params;
	}

	public static class ElicitationCompleteParams extends NotificationParams {
		private String elicitationId;

		public String getElicitationId() {
			return elicitationId;
		}

		public void setElicitationId(String elicitationId) {
			this.elicitationId = elicitationId;
		}
	}
}
