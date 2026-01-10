package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Initialized notification
 */
public class InitializedNotification extends JSONRPCNotification {
    private NotificationParams params;

    public InitializedNotification() {
        setMethod("notifications/initialized");
    }

    public NotificationParams getTypedParams() {
        return params;
    }

    public void setTypedParams(NotificationParams params) {
        this.params = params;
    }
}

