package io.modelcontextprotocol.mcptools.common.spec;

/**
 * List prompts request
 */
public class ListPromptsRequest extends PaginatedRequest {
	public ListPromptsRequest() {
		setMethod("prompts/list");
	}
}
