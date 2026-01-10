package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Tool annotations
 */
public class ToolAnnotations {
    private String title;
    private Boolean readOnlyHint;
    private Boolean destructiveHint;
    private Boolean idempotentHint;
    private Boolean openWorldHint;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getReadOnlyHint() {
        return readOnlyHint;
    }

    public void setReadOnlyHint(Boolean readOnlyHint) {
        this.readOnlyHint = readOnlyHint;
    }

    public Boolean getDestructiveHint() {
        return destructiveHint;
    }

    public void setDestructiveHint(Boolean destructiveHint) {
        this.destructiveHint = destructiveHint;
    }

    public Boolean getIdempotentHint() {
        return idempotentHint;
    }

    public void setIdempotentHint(Boolean idempotentHint) {
        this.idempotentHint = idempotentHint;
    }

    public Boolean getOpenWorldHint() {
        return openWorldHint;
    }

    public void setOpenWorldHint(Boolean openWorldHint) {
        this.openWorldHint = openWorldHint;
    }
}
