package io.modelcontextprotocol.mcptools.common.spec;

/**
 * JSON-RPC result response
 */
public class JSONRPCResultResponse implements JSONRPCResponse {
	private String jsonrpc = JSONRPCConstants.JSONRPC_VERSION;
	private RequestId id;
	private Result result;

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

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}
}
