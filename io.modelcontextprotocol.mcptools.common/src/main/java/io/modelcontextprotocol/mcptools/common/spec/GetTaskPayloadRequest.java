package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Get task payload request
 */
public class GetTaskPayloadRequest extends JSONRPCRequest {
	private GetTaskPayloadRequestParams params;

	public GetTaskPayloadRequest() {
		setMethod("tasks/result");
	}

	public GetTaskPayloadRequestParams getTypedParams() {
		return params;
	}

	public void setTypedParams(GetTaskPayloadRequestParams params) {
		this.params = params;
	}

	public static class GetTaskPayloadRequestParams extends RequestParams {
		private String taskId;

		public String getTaskId() {
			return taskId;
		}

		public void setTaskId(String taskId) {
			this.taskId = taskId;
		}
	}
}
