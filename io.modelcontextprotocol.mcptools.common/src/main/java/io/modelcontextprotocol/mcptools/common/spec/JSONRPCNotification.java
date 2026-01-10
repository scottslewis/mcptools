package io.modelcontextprotocol.mcptools.common.spec;

import java.util.Map;

/**
 * JSON-RPC notification
 */
public class JSONRPCNotification implements Notification, JSONRPCMessage {
    private String jsonrpc = JSONRPCConstants.JSONRPC_VERSION;
    private String method;
    private Map<String, Object> params;

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
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
