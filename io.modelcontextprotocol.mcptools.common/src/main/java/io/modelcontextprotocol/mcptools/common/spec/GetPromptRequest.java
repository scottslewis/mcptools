package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Get prompt request
 */
public class GetPromptRequest extends JSONRPCRequest {
	private GetPromptRequestParams params;

	public GetPromptRequest() {
		setMethod("prompts/get");
	}

	public GetPromptRequestParams getTypedParams() {
		return params;
	}

	public void setTypedParams(GetPromptRequestParams params) {
		this.params = params;
	}
}
