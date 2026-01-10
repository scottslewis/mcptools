package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Unsubscribe request
 */
public class UnsubscribeRequest extends JSONRPCRequest {
    private UnsubscribeRequestParams params;

    public UnsubscribeRequest() {
        setMethod("resources/unsubscribe");
    }

    public UnsubscribeRequestParams getTypedParams() {
        return params;
    }

    public void setTypedParams(UnsubscribeRequestParams params) {
        this.params = params;
    }
}
