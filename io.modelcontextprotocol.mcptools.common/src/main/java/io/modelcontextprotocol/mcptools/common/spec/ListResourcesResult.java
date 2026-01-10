package io.modelcontextprotocol.mcptools.common.spec;

import java.util.List;

/**
 * List resources result
 */
public class ListResourcesResult extends PaginatedResult {
    private List<Resource> resources;

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}
