package io.modelcontextprotocol.mcptools.common;

import java.util.List;
import java.util.Objects;

public interface GroupNodeConverter<R> {
	
	default List<R> convertGroupNodes(List<GroupNode> groupNodes) {
		return groupNodes.stream().map(gn -> {
			return convertGroupNode(gn);
		}).filter(Objects::nonNull).toList();
	}

	R convertGroupNode(GroupNode groupNode);
}
