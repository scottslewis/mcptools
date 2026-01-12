package io.modelcontextprotocol.mcptools.common.spec;

/**
 * List tools request
 */
public class ListToolsRequest extends PaginatedRequest {
	public ListToolsRequest() {
		setMethod("tools/list");
	}
}
