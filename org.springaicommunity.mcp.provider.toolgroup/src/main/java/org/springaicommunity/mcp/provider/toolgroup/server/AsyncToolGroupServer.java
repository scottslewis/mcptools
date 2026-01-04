package org.springaicommunity.mcp.provider.toolgroup.server;

import java.util.List;
import java.util.function.BiFunction;

import org.springaicommunity.mcp.provider.toolgroup.AsyncToolGroupProvider;

import io.modelcontextprotocol.mcptools.common.ToolNode;
import io.modelcontextprotocol.mcptools.toolgroup.ToolNodeSpecification;
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

	protected ToolNodeSpecification<AsyncToolSpecification> getToolNodeSpecification(ToolNode toolNode,
			BiFunction<McpAsyncServerExchange, CallToolRequest, Mono<CallToolResult>> callHandler) {
		AsyncToolSpecification.Builder specBuilder = AsyncToolSpecification.builder().tool(convertToolNode(toolNode))
				.callHandler(callHandler);
		return new ToolNodeSpecification<AsyncToolSpecification>(toolNode, specBuilder.build());
	}

	@Override
	public void removeToolNode(ToolNode toolNode) {
		this.server.removeTool(toolNode.getName()).block();
	}

	@Override
	public List<ToolNodeSpecification<AsyncToolSpecification>> addToolGroup(Object instance, Class<?>... classes) {
		List<ToolNodeSpecification<AsyncToolSpecification>> specs = this.toolGroupProvider.getToolGroupSpecifications(instance, classes);
		specs.forEach(s -> {
			addTool(this.server, s.getSpecification());
		});
		return specs;
	}

}
