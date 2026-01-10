package io.modelcontextprotocol.mcptools.common.spec;

/**
 * List tasks request
 */
public class ListTasksRequest extends PaginatedRequest {
    public ListTasksRequest() {
        setMethod("tasks/list");
    }
}

