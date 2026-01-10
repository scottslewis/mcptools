package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Logging message notification parameters
 */
public class LoggingMessageNotificationParams extends NotificationParams {
    private LoggingLevel level;
    private String logger;
    private Object data;

    public LoggingLevel getLevel() {
        return level;
    }

    public void setLevel(LoggingLevel level) {
        this.level = level;
    }

    public String getLogger() {
        return logger;
    }

    public void setLogger(String logger) {
        this.logger = logger;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
