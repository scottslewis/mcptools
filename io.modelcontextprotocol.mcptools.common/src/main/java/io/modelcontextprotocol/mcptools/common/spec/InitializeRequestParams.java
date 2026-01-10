package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Initialize request parameters
 */
public class InitializeRequestParams extends RequestParams {
    private String protocolVersion;
    private ClientCapabilities capabilities;
    private Implementation clientInfo;

    public String getProtocolVersion() {
        return protocolVersion;
    }

    public void setProtocolVersion(String protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public ClientCapabilities getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(ClientCapabilities capabilities) {
        this.capabilities = capabilities;
    }

    public Implementation getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(Implementation clientInfo) {
        this.clientInfo = clientInfo;
    }
}
