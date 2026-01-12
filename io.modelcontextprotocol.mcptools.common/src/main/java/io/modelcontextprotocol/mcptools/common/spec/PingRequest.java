package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Ping request
 */
public class PingRequest extends JSONRPCRequest {
	private RequestParams params;

	public PingRequest() {
		setMethod("ping");
	}

	public RequestParams getTypedParams() {
		return params;
	}

	public void setTypedParams(RequestParams params) {
		this.params = params;
	}
}
