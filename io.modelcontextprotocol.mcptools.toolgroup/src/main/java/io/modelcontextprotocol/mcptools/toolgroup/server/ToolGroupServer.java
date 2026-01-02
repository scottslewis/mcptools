package io.modelcontextprotocol.mcptools.toolgroup.server;

import java.io.Closeable;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import io.modelcontextprotocol.mcptools.common.ToolNode;

public interface ToolGroupServer<ServerType, ToolSpecType, ToolType, ExchangeType, CallRequestType, CallResultType>
		extends Closeable {

	void addTool(ToolSpecType toolSpec);

	void removeTool(String toolName);

	default void addTools(List<ToolSpecType> toolSpecs) {
		toolSpecs.forEach(s -> addTool(s));
	}

	default void removeTools(List<String> toolNames) {
		toolNames.forEach(tn -> removeTool(tn));
	}

	ServerType getServer();

	List<ToolSpecType> getToolSpecs();

	default void addToolNodes(
			Map<ToolNode, BiFunction<ExchangeType, CallRequestType, CallResultType>> toolNodeToHandlerMapper) {
		toolNodeToHandlerMapper.forEach((tn, callHandler) -> {
			addToolNode(tn, callHandler);
		});
	}

	void addToolNode(ToolNode toolNode, BiFunction<ExchangeType, CallRequestType, CallResultType> callHandler);

	default void removeToolNodes(List<ToolNode> toolNodes) {
		toolNodes.forEach(tn -> {
			removeToolNode(tn);
		});
	}

	void removeToolNode(ToolNode toolNode);
	
	void addToolGroup(Object instance, Class<?>...classes);

}
