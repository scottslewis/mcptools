package io.modelcontextprotocol.mcptools.common.spec;

/**
 * List resources request
 */
public class ListResourcesRequest extends PaginatedRequest {
	public ListResourcesRequest() {
		setMethod("resources/list");
	}
}
