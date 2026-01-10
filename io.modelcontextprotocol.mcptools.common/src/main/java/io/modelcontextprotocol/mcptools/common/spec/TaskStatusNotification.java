package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Task status notification
 */
public class TaskStatusNotification extends JSONRPCNotification {
    private TaskStatusNotificationParams params;

    public TaskStatusNotification() {
        setMethod("notifications/tasks/status");
    }

    public TaskStatusNotificationParams getTypedParams() {
        return params;
    }

    public void setTypedParams(TaskStatusNotificationParams params) {
        this.params = params;
    }
}
