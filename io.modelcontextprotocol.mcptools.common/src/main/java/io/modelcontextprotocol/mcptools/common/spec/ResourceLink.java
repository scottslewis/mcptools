package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Resource link content block
 */
public class ResourceLink extends Resource implements ContentBlock {
    private String type = "resource_link";

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
