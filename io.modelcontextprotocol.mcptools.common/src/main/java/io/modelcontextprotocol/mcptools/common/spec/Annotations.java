package io.modelcontextprotocol.mcptools.common.spec;

import java.util.List;

/**
 * Annotations for content blocks and resources
 */
public class Annotations {
    private List<Role> audience;
    private Double priority;
    private String lastModified;

    public List<Role> getAudience() {
        return audience;
    }

    public void setAudience(List<Role> audience) {
        this.audience = audience;
    }

    public Double getPriority() {
        return priority;
    }

    public void setPriority(Double priority) {
        this.priority = priority;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }
}
