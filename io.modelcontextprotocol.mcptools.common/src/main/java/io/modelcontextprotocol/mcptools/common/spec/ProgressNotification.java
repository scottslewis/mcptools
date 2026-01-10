package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Progress notification
 */
public class ProgressNotification extends JSONRPCNotification {
    private ProgressNotificationParams params;

    public ProgressNotification() {
        setMethod("notifications/progress");
    }

    public ProgressNotificationParams getTypedParams() {
        return params;
    }

    public void setTypedParams(ProgressNotificationParams params) {
        this.params = params;
    }
}
