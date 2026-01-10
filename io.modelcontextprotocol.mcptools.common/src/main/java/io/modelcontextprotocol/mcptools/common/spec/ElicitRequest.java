package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Elicit request
 */
public class ElicitRequest extends JSONRPCRequest {
    private Object params; // Can be ElicitRequestFormParams or ElicitRequestURLParams

    public ElicitRequest() {
        setMethod("elicitation/create");
    }

    public Object getTypedParams() {
        return params;
    }

    public void setTypedParams(Object params) {
        this.params = params;
    }

    public ElicitRequestFormParams getParamsAsForm() {
        if (params instanceof ElicitRequestFormParams) {
            return (ElicitRequestFormParams) params;
        }
        return null;
    }

    public ElicitRequestURLParams getParamsAsURL() {
        if (params instanceof ElicitRequestURLParams) {
            return (ElicitRequestURLParams) params;
        }
        return null;
    }
}
