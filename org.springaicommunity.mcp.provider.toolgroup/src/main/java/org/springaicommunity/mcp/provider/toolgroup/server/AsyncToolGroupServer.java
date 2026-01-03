package org.springaicommunity.mcp.provider.toolgroup.server;

import java.util.function.BiFunction;

import org.springaicommunity.mcp.provider.toolgroup.AsyncToolGroupProvider;

import io.modelcontextprotocol.mcptools.common.ToolNode;
import io.modelcontextprotocol.server.McpAsyncServer;
import io.modelcontextprotocol.server.McpAsyncServerExchange;
import io.modelcontextprotocol.server.McpServerFeatures.AsyncToolSpecification;
import io.modelcontextprotocol.spec.McpSchema.CallToolRequest;
import io.modelcontextprotocol.spec.McpSchema.CallToolResult;
import reactor.core.publisher.Mono;

public class AsyncToolGroupServer extends
		AbstractSpringToolGroupServer<McpAsyncServer, AsyncToolSpecification, McpAsyncServerExchange, Mono<CallToolResult>> {

	public AsyncToolGroupServer() {
		this(null);
	}

	public AsyncToolGroupServer(McpAsyncServer server) {
		super(server);
		setToolGroupProvider(new AsyncToolGroupProvider());
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
		server.addTool(toolSpec).block();
	}

	@Override
	protected void removeTool(McpAsyncServer server, String toolName) {
		server.removeTool(toolName).block();
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
		this.server.addTool(specification).block();
	}

	@Override
	public void removeToolNode(ToolNode toolNode) {
		this.server.removeTool(toolNode.getName()).block();
	}

}
