package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Cancel task request
 */
public class CancelTaskRequest extends JSONRPCRequest {
	private CancelTaskRequestParams params;

	public CancelTaskRequest() {
		setMethod("tasks/cancel");
	}

	public CancelTaskRequestParams getTypedParams() {
		return params;
	}

	public void setTypedParams(CancelTaskRequestParams params) {
		this.params = params;
	}

	public static class CancelTaskRequestParams extends RequestParams {
		private String taskId;

		public String getTaskId() {
			return taskId;
		}

		public void setTaskId(String taskId) {
			this.taskId = taskId;
		}
	}
}
