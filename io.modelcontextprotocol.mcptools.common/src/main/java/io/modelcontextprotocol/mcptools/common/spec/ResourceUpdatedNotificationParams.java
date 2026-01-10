package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Resource updated notification parameters
 */
public class ResourceUpdatedNotificationParams extends NotificationParams {
    private String uri;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
