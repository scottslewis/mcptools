package io.modelcontextprotocol.mcptools.toolgroup.server;

import java.io.Closeable;
import java.util.List;

import io.modelcontextprotocol.mcptools.common.ToolNode;
import io.modelcontextprotocol.mcptools.toolgroup.ToolNodeSpecification;

public interface ToolGroupServer<SpecificationType> extends Closeable {

	default void removeToolNodes(List<ToolNode> toolNodes) {
		toolNodes.forEach(tn -> {
			removeToolNode(tn);
		});
	}

	void removeToolNode(ToolNode toolNode);

	List<ToolNodeSpecification<SpecificationType>> addToolGroup(Object instance, Class<?>... classes);

}
