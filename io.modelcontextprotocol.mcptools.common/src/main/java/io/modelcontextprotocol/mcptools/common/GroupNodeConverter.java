package io.modelcontextprotocol.mcptools.common;

import java.util.List;
import java.util.Objects;

public interface GroupNodeConverter<GroupType> {
	
	default List<GroupType> convertFromGroupNodes(List<GroupNode> groupNodes) {
		return groupNodes.stream().map(gn -> {
			return convertFromGroupNode(gn);
		}).filter(Objects::nonNull).toList();
	}

	GroupType convertFromGroupNode(GroupNode groupNode);
	
	default List<GroupNode> convertToGroupNodes(List<GroupType> groups) {
		return groups.stream().map(g -> {
			return convertToGroupNode(g);
		}).filter(Objects::nonNull).toList();
	}

	GroupNode convertToGroupNode(GroupType group);
	
}
