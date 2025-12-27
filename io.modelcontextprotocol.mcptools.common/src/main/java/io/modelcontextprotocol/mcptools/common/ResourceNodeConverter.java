package io.modelcontextprotocol.mcptools.common;

import java.util.List;
import java.util.Objects;

public interface ResourceNodeConverter<R> {
	
	default List<R> convertResourceNodes(List<ResourceNode> resourceNodes) {
		return resourceNodes.stream().map(rn -> {
			return convertResourceNode(rn);
		}).filter(Objects::nonNull).toList();
	}

	R convertResourceNode(ResourceNode resourceNode);
}
