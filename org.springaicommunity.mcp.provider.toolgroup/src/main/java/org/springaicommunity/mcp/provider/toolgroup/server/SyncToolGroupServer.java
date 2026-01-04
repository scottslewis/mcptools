package org.springaicommunity.mcp.provider.toolgroup.server;

import java.util.List;
import java.util.function.BiFunction;

import org.springaicommunity.mcp.provider.toolgroup.SyncToolGroupProvider;

import io.modelcontextprotocol.mcptools.common.ToolNode;
import io.modelcontextprotocol.mcptools.toolgroup.ToolNodeSpecification;
import io.modelcontextprotocol.server.McpServerFeatures.SyncToolSpecification;
import io.modelcontextprotocol.server.McpSyncServer;
import io.modelcontextprotocol.server.McpSyncServerExchange;
import io.modelcontextprotocol.spec.McpSchema.CallToolRequest;
import io.modelcontextprotocol.spec.McpSchema.CallToolResult;

public class SyncToolGroupServer extends
		AbstractSpringToolGroupServer<McpSyncServer, SyncToolSpecification, McpSyncServerExchange, CallToolResult> {

	public SyncToolGroupServer() {
		this(null);
	}

	public SyncToolGroupServer(McpSyncServer server) {
		super(server);
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
	public List<ToolNode> addToolGroup(Object instance, Class<?>... classes) {
		List<ToolNodeSpecification<SyncToolSpecification>> specs = this.toolGroupProvider.getToolGroupSpecifications(instance, classes);
		specs.forEach(s -> {
			addTool(this.server, s.getSpecification());
		});
		return specs.stream().map(sp -> {
			return sp.getToolNode();
		}).toList();
	}

	@Override
	protected ToolNodeSpecification<SyncToolSpecification> getToolNodeSpecification(ToolNode toolNode,
			BiFunction<McpSyncServerExchange, CallToolRequest, CallToolResult> callHandler) {
		SyncToolSpecification.Builder specBuilder = SyncToolSpecification.builder().tool(convertToolNode(toolNode))
				.callHandler(callHandler);
		return new ToolNodeSpecification<SyncToolSpecification>(toolNode, specBuilder.build());
	}

}
