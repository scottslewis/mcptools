package org.springaicommunity.mcp.provider.toolgroup.server;

import java.util.function.BiFunction;

import org.springaicommunity.mcp.provider.SpringNodeConverter;

import io.modelcontextprotocol.mcptools.common.ToolNode;
import io.modelcontextprotocol.server.McpServerFeatures.SyncToolSpecification;
import io.modelcontextprotocol.server.McpSyncServer;
import io.modelcontextprotocol.server.McpSyncServerExchange;
import io.modelcontextprotocol.spec.McpSchema.CallToolRequest;
import io.modelcontextprotocol.spec.McpSchema.CallToolResult;

public class AsyncToolGroupServer extends
		AbstractSpringToolGroupServer<McpSyncServer, SyncToolSpecification, McpSyncServerExchange, CallToolResult> {

	public AsyncToolGroupServer() {
		this(null);
	}

	public AsyncToolGroupServer(McpSyncServer server) {
		super(server);
		setToolNodeConverter(new SpringNodeConverter());
	}

	@Override
	protected void closeServer() {
		if (this.server != null) {
			this.server.closeGracefully();
			this.server = null;
		}
	}

	@Override
	protected void addTool(McpSyncServer server, SyncToolSpecification toolSpec) {
		server.addTool(toolSpec);
	}

	@Override
	protected void removeTool(McpSyncServer server, String toolName) {
		server.removeTool(toolName);
	}

	@Override
	protected SyncToolSpecification buildSpecification(ToolNode toolNode,
			BiFunction<McpSyncServerExchange, CallToolRequest, CallToolResult> callHandler) {
		return SyncToolSpecification.builder().tool(convertToolNode(toolNode)).callHandler(callHandler).build();
	}

	@Override
	public void addToolNode(ToolNode toolNode,
			BiFunction<McpSyncServerExchange, CallToolRequest, CallToolResult> callHandler) {
		SyncToolSpecification specification = buildSpecification(toolNode, callHandler);
		this.server.addTool(specification);
	}

	@Override
	public void removeToolNode(ToolNode toolNode) {
		this.server.removeTool(toolNode.getName());
	}

}
