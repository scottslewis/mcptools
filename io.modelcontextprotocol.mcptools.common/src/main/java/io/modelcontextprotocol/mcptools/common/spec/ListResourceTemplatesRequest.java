package io.modelcontextprotocol.mcptools.common.spec;

/**
 * List resource templates request
 */
public class ListResourceTemplatesRequest extends PaginatedRequest {
    public ListResourceTemplatesRequest() {
        setMethod("resources/templates/list");
    }
}
