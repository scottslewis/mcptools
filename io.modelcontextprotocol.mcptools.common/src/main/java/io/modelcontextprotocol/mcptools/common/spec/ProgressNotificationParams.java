package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Progress notification parameters
 */
public class ProgressNotificationParams extends NotificationParams {
    private ProgressToken progressToken;
    private double progress;
    private Double total;
    private String message;

    public ProgressToken getProgressToken() {
        return progressToken;
    }

    public void setProgressToken(ProgressToken progressToken) {
        this.progressToken = progressToken;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
