package io.modelcontextprotocol.mcptools.common.spec;

import java.util.Map;

/**
 * JSON-RPC request
 */
public class JSONRPCRequest implements Request, JSONRPCMessage {
	private String jsonrpc = JSONRPCConstants.JSONRPC_VERSION;
	private RequestId id;
	private String method;
	private Map<String, Object> params;

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

	@Override
	public String getMethod() {
		return method;
	}

	@Override
	public void setMethod(String method) {
		this.method = method;
	}

	@Override
	public Map<String, Object> getParams() {
		return params;
	}

	@Override
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
}
