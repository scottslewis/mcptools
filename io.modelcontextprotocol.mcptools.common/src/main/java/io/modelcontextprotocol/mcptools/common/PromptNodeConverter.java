package io.modelcontextprotocol.mcptools.common;

import java.util.List;
import java.util.Objects;

public interface PromptNodeConverter<PromptType> {
	
	default List<PromptType> convertFromPromptNodes(List<PromptNode> promptNodes) {
		return promptNodes.stream().map(pn -> {
			return convertFromPromptNode(pn);
		}).filter(Objects::nonNull).toList();
	}

	PromptType convertFromPromptNode(PromptNode promptNode);
	
	default List<PromptNode> convertToPromptNodes(List<PromptType> prompts) {
		return prompts.stream().map(p -> {
			return convertToPromptNode(p);
		}).filter(Objects::nonNull).toList();
	}

	PromptNode convertToPromptNode(PromptType prompt);

}
