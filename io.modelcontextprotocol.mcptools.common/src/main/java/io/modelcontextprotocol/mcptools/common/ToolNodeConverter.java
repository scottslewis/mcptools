package io.modelcontextprotocol.mcptools.common;

import java.util.List;
import java.util.Objects;

public interface ToolNodeConverter<ToolType> {
	
	default List<ToolType> convertFromToolNodes(List<ToolNode> toolNodes) {
		return toolNodes.stream().map(tn -> {
			return convertFromToolNode(tn);
		}).filter(Objects::nonNull).toList();
	}

	ToolType convertFromToolNode(ToolNode toolNode);
	
	default List<ToolNode> convertToToolNodes(List<ToolType> tools) {
		return tools.stream().map(t -> {
			return convertToToolNode(t);
		}).filter(Objects::nonNull).toList();
	}

	ToolNode convertToToolNode(ToolType tool);

}
