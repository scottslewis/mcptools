package io.modelcontextprotocol.mcptools.common.spec;

/**
 * List roots request
 */
public class ListRootsRequest extends JSONRPCRequest {
    private RequestParams params;

    public ListRootsRequest() {
        setMethod("roots/list");
    }

    public RequestParams getTypedParams() {
        return params;
    }

    public void setTypedParams(RequestParams params) {
        this.params = params;
    }
}
