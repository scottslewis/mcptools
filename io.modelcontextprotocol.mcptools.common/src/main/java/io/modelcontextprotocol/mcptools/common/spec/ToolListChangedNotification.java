package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Tool list changed notification
 */
public class ToolListChangedNotification extends JSONRPCNotification {
    private NotificationParams params;

    public ToolListChangedNotification() {
        setMethod("notifications/tools/list_changed");
    }

    public NotificationParams getTypedParams() {
        return params;
    }

    public void setTypedParams(NotificationParams params) {
        this.params = params;
    }
}
