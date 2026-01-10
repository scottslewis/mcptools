package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Create message request
 */
public class CreateMessageRequest extends JSONRPCRequest {
    private CreateMessageRequestParams params;

    public CreateMessageRequest() {
        setMethod("sampling/createMessage");
    }

    public CreateMessageRequestParams getTypedParams() {
        return params;
    }

    public void setTypedParams(CreateMessageRequestParams params) {
        this.params = params;
    }
}
