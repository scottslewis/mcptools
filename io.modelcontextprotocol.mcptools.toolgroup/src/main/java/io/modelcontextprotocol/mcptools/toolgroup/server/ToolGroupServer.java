package io.modelcontextprotocol.mcptools.toolgroup.server;

import java.io.Closeable;
import java.util.List;

import io.modelcontextprotocol.mcptools.common.ToolNode;

public interface ToolGroupServer extends Closeable {

	default void removeToolNodes(List<ToolNode> toolNodes) {
		toolNodes.forEach(tn -> {
			removeToolNode(tn);
		});
	}

	void removeToolNode(ToolNode toolNode);

	List<ToolNode> addToolGroup(Object instance, Class<?>... classes);

}
