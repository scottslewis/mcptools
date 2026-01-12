package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Call tool request
 */
public class CallToolRequest extends JSONRPCRequest {
	private CallToolRequestParams params;

	public CallToolRequest() {
		setMethod("tools/call");
	}

	public CallToolRequestParams getTypedParams() {
		return params;
	}

	public void setTypedParams(CallToolRequestParams params) {
		this.params = params;
	}
}
