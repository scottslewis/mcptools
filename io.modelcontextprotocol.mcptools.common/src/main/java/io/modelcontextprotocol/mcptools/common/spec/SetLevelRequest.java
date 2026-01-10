package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Set level request
 */
public class SetLevelRequest extends JSONRPCRequest {
    private SetLevelRequestParams params;

    public SetLevelRequest() {
        setMethod("logging/setLevel");
    }

    public SetLevelRequestParams getTypedParams() {
        return params;
    }

    public void setTypedParams(SetLevelRequestParams params) {
        this.params = params;
    }
}
