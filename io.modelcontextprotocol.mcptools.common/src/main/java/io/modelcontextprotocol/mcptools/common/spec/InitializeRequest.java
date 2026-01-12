package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Initialize request
 */
public class InitializeRequest extends JSONRPCRequest {
	private InitializeRequestParams params;

	public InitializeRequest() {
		setMethod("initialize");
	}

	public InitializeRequestParams getTypedParams() {
		return params;
	}

	public void setTypedParams(InitializeRequestParams params) {
		this.params = params;
	}
}
