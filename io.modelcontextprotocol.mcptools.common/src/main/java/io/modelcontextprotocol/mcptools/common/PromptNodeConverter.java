package io.modelcontextprotocol.mcptools.common;

import java.util.List;
import java.util.Objects;

public interface PromptNodeConverter<R> {
	
	default List<R> convertPromptNodes(List<PromptNode> promptNodes) {
		return promptNodes.stream().map(pn -> {
			return convertPromptNode(pn);
		}).filter(Objects::nonNull).toList();
	}

	R convertPromptNode(PromptNode promptNode);
}
