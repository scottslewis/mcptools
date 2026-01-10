package io.modelcontextprotocol.mcptools.common.spec;

import java.util.List;

/**
 * List tools result
 */
public class ListToolsResult extends PaginatedResult {
    private List<Tool> tools;

    public List<Tool> getTools() {
        return tools;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }
}
