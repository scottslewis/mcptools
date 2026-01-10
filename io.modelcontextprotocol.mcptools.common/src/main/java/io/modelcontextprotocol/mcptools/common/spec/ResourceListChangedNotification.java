package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Resource list changed notification
 */
public class ResourceListChangedNotification extends JSONRPCNotification {
    private NotificationParams params;

    public ResourceListChangedNotification() {
        setMethod("notifications/resources/list_changed");
    }

    public NotificationParams getTypedParams() {
        return params;
    }

    public void setTypedParams(NotificationParams params) {
        this.params = params;
    }
}
