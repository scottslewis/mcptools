package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Read resource request
 */
public class ReadResourceRequest extends JSONRPCRequest {
	private ReadResourceRequestParams params;

	public ReadResourceRequest() {
		setMethod("resources/read");
	}

	public ReadResourceRequestParams getTypedParams() {
		return params;
	}

	public void setTypedParams(ReadResourceRequestParams params) {
		this.params = params;
	}
}
