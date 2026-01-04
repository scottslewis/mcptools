package org.springaicommunity.mcp.provider.toolgroup.server;

import java.util.Map;
import java.util.function.BiFunction;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.springaicommunity.mcp.provider.toolgroup.AsyncToolGroupProvider;

import io.modelcontextprotocol.mcptools.common.ToolNode;
import io.modelcontextprotocol.mcptools.toolgroup.ToolNodeSpecification;
import io.modelcontextprotocol.mcptools.toolgroup.server.AsyncToolGroupServer;
import io.modelcontextprotocol.server.McpAsyncServer;
import io.modelcontextprotocol.server.McpAsyncServerExchange;
import io.modelcontextprotocol.server.McpServer;
import io.modelcontextprotocol.server.McpServerFeatures.AsyncToolSpecification;
import io.modelcontextprotocol.spec.McpSchema.CallToolRequest;
import io.modelcontextprotocol.spec.McpSchema.CallToolResult;
import io.modelcontextprotocol.spec.McpSchema.ServerCapabilities;
import io.modelcontextprotocol.spec.McpServerTransportProvider;
import reactor.core.publisher.Mono;

@Component(factory = "SpringAsyncToolGroupServer", service = AsyncToolGroupServer.class)
public class SpringAsyncToolGroupServer extends
		AbstractSpringToolGroupServer<McpAsyncServer, AsyncToolSpecification, McpAsyncServerExchange, Mono<CallToolResult>>
		implements AsyncToolGroupServer {

	public SpringAsyncToolGroupServer() {
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

	@Activate
	protected void activate(Map<String, Object> properties) {
		this.server = buildServerFromProperties(properties);
	}

	@Deactivate
	protected void deactivate() {
		if (this.server != null) {
			this.server.close();
		}
	}

	@Override
	public void removeToolNode(ToolNode toolNode) {
		this.server.removeTool(toolNode.getName()).block();
	}

	@Override
	protected McpAsyncServer buildServer(String serverName, String serverVersion, ServerCapabilities serverCapabilities,
			McpServerTransportProvider transport) {
		return McpServer.async(transport).serverInfo(serverName, serverVersion).capabilities(serverCapabilities)
				.build();
	}

}
