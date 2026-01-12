package io.modelcontextprotocol.mcptools.common.spec;

import java.util.List;

/**
 * List resource templates result
 */
public class ListResourceTemplatesResult extends PaginatedResult {
	private List<ResourceTemplate> resourceTemplates;

	public List<ResourceTemplate> getResourceTemplates() {
		return resourceTemplates;
	}

	public void setResourceTemplates(List<ResourceTemplate> resourceTemplates) {
		this.resourceTemplates = resourceTemplates;
	}
}
