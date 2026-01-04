package io.modelcontextprotocol.mcptools.toolgroup.server;

import java.io.Closeable;
import java.lang.reflect.Method;
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

	boolean isAsync();
	
	boolean isStateless();
	
	void addToolNode(ToolNode toolNode, Method toolMethod, Object instance);
}
