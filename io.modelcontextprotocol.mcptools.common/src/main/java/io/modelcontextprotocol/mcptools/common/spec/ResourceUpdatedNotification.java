package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Resource updated notification
 */
public class ResourceUpdatedNotification extends JSONRPCNotification {
    private ResourceUpdatedNotificationParams params;

    public ResourceUpdatedNotification() {
        setMethod("notifications/resources/updated");
    }

    public ResourceUpdatedNotificationParams getTypedParams() {
        return params;
    }

    public void setTypedParams(ResourceUpdatedNotificationParams params) {
        this.params = params;
    }
}
