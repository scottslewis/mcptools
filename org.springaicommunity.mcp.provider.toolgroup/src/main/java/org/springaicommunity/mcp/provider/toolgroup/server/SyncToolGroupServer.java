package org.springaicommunity.mcp.provider.toolgroup.server;

import java.util.function.BiFunction;

import org.springaicommunity.mcp.provider.SpringNodeConverter;

import io.modelcontextprotocol.mcptools.common.ToolNode;
import io.modelcontextprotocol.server.McpAsyncServer;
import io.modelcontextprotocol.server.McpAsyncServerExchange;
import io.modelcontextprotocol.server.McpServerFeatures.AsyncToolSpecification;
import io.modelcontextprotocol.spec.McpSchema.CallToolRequest;
import io.modelcontextprotocol.spec.McpSchema.CallToolResult;
import reactor.core.publisher.Mono;

public class SyncToolGroupServer extends
		AbstractSpringToolGroupServer<McpAsyncServer, AsyncToolSpecification, McpAsyncServerExchange, Mono<CallToolResult>> {

	public SyncToolGroupServer() {
		this(null);
	}

	public SyncToolGroupServer(McpAsyncServer server) {
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
	protected void addTool(McpAsyncServer server, AsyncToolSpecification toolSpec) {
		server.addTool(toolSpec);
	}

	@Override
	protected void removeTool(McpAsyncServer server, String toolName) {
		server.removeTool(toolName);
	}

	@Override
	protected AsyncToolSpecification buildSpecification(ToolNode toolNode,
			BiFunction<McpAsyncServerExchange, CallToolRequest, Mono<CallToolResult>> callHandler) {
		return AsyncToolSpecification.builder().tool(convertToolNode(toolNode)).callHandler(callHandler).build();
	}

	@Override
	public void addToolNode(ToolNode toolNode,
			BiFunction<McpAsyncServerExchange, CallToolRequest, Mono<CallToolResult>> callHandler) {
		AsyncToolSpecification specification = buildSpecification(toolNode, callHandler);
		this.server.addTool(specification);
	}

	@Override
	public void removeToolNode(ToolNode toolNode) {
		this.server.removeTool(toolNode.getName());
	}

}
