package io.modelcontextprotocol.mcptools.common.spec;

/**
 * JSON-RPC error response
 */
public class JSONRPCErrorResponse implements JSONRPCResponse {
	private String jsonrpc = JSONRPCConstants.JSONRPC_VERSION;
	private RequestId id;
	private Error error;

	public String getJsonrpc() {
		return jsonrpc;
	}

	public void setJsonrpc(String jsonrpc) {
		this.jsonrpc = jsonrpc;
	}

	public RequestId getId() {
		return id;
	}

	public void setId(RequestId id) {
		this.id = id;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}
}
