package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Complete request
 */
public class CompleteRequest extends JSONRPCRequest {
	private CompleteRequestParams params;

	public CompleteRequest() {
		setMethod("completion/complete");
	}

	public CompleteRequestParams getTypedParams() {
		return params;
	}

	public void setTypedParams(CompleteRequestParams params) {
		this.params = params;
	}
}
