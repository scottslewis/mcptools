package org.springaicommunity.mcp.provider.toolgroup.server;

import java.util.Map;
import java.util.function.BiFunction;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.springaicommunity.mcp.provider.toolgroup.SyncToolGroupProvider;

import io.modelcontextprotocol.mcptools.common.ToolNode;
import io.modelcontextprotocol.mcptools.toolgroup.ToolNodeSpecification;
import io.modelcontextprotocol.mcptools.toolgroup.server.SyncToolGroupServer;
import io.modelcontextprotocol.server.McpServer;
import io.modelcontextprotocol.server.McpServerFeatures.SyncToolSpecification;
import io.modelcontextprotocol.server.McpSyncServer;
import io.modelcontextprotocol.server.McpSyncServerExchange;
import io.modelcontextprotocol.spec.McpSchema.CallToolRequest;
import io.modelcontextprotocol.spec.McpSchema.CallToolResult;
import io.modelcontextprotocol.spec.McpSchema.ServerCapabilities;
import io.modelcontextprotocol.spec.McpServerTransportProvider;

@Component(factory = "SpringSyncToolGroupServer", service = SyncToolGroupServer.class)
public class SpringSyncToolGroupServer extends
		AbstractSpringToolGroupServer<McpSyncServer, SyncToolSpecification, McpSyncServerExchange, CallToolResult>
		implements SyncToolGroupServer {

	public SpringSyncToolGroupServer() {
		setToolGroupProvider(new SyncToolGroupProvider());
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
	public void removeToolNode(ToolNode toolNode) {
		this.server.removeTool(toolNode.getName());
	}

	@Override
	protected ToolNodeSpecification<SyncToolSpecification> getToolNodeSpecification(ToolNode toolNode,
			BiFunction<McpSyncServerExchange, CallToolRequest, CallToolResult> callHandler) {
		SyncToolSpecification.Builder specBuilder = SyncToolSpecification.builder().tool(convertToolNode(toolNode))
				.callHandler(callHandler);
		return new ToolNodeSpecification<SyncToolSpecification>(toolNode, specBuilder.build());
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
	protected McpSyncServer buildServer(String serverName, String serverVersion, ServerCapabilities serverCapabilities,
			McpServerTransportProvider transport) {
		return McpServer.sync(transport).serverInfo(serverName, serverVersion).capabilities(serverCapabilities).build();
	}

}
