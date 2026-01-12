package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Get task request
 */
public class GetTaskRequest extends JSONRPCRequest {
	private GetTaskRequestParams params;

	public GetTaskRequest() {
		setMethod("tasks/get");
	}

	public GetTaskRequestParams getTypedParams() {
		return params;
	}

	public void setTypedParams(GetTaskRequestParams params) {
		this.params = params;
	}

	public static class GetTaskRequestParams extends RequestParams {
		private String taskId;

		public String getTaskId() {
			return taskId;
		}

		public void setTaskId(String taskId) {
			this.taskId = taskId;
		}
	}
}
