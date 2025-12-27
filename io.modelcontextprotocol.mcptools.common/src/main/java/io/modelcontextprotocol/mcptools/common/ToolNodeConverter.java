package io.modelcontextprotocol.mcptools.common;

import java.util.List;
import java.util.Objects;

public interface ToolNodeConverter<R> {
	
	default List<R> convertToolNodes(List<ToolNode> toolNodes) {
		return toolNodes.stream().map(tn -> {
			return convertToolNode(tn);
		}).filter(Objects::nonNull).toList();
	}

	R convertToolNode(ToolNode tn);
}
