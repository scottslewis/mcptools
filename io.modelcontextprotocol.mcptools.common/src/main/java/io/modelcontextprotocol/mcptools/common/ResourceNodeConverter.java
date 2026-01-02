package io.modelcontextprotocol.mcptools.common;

import java.util.List;
import java.util.Objects;

public interface ResourceNodeConverter<ResourceType> {
	
	default List<ResourceType> convertFromResourceNodes(List<ResourceNode> resourceNodes) {
		return resourceNodes.stream().map(rn -> {
			return convertFromResourceNode(rn);
		}).filter(Objects::nonNull).toList();
	}

	ResourceType convertFromResourceNode(ResourceNode resourceNode);
	
	default List<ResourceNode> convertToResourceNodes(List<ResourceType> resources) {
		return resources.stream().map(rn -> {
			return convertToResourceNode(rn);
		}).filter(Objects::nonNull).toList();
	}

	ResourceNode convertToResourceNode(ResourceType resource);

}
