package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Roots list changed notification
 */
public class RootsListChangedNotification extends JSONRPCNotification {
    private NotificationParams params;

    public RootsListChangedNotification() {
        setMethod("notifications/roots/list_changed");
    }

    public NotificationParams getTypedParams() {
        return params;
    }

    public void setTypedParams(NotificationParams params) {
        this.params = params;
    }
}
