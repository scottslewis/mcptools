package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Subscribe request
 */
public class SubscribeRequest extends JSONRPCRequest {
    private SubscribeRequestParams params;

    public SubscribeRequest() {
        setMethod("resources/subscribe");
    }

    public SubscribeRequestParams getTypedParams() {
        return params;
    }

    public void setTypedParams(SubscribeRequestParams params) {
        this.params = params;
    }
}
