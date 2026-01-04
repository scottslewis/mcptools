package org.springaicommunity.mcp.provider.toolgroup.server;

import org.springaicommunity.mcp.provider.SpringNodeConverter;

import io.modelcontextprotocol.mcptools.common.ToolNode;
import io.modelcontextprotocol.mcptools.common.ToolNodeConverter;
import io.modelcontextprotocol.mcptools.toolgroup.ToolGroupProvider;
import io.modelcontextprotocol.mcptools.toolgroup.server.AbstractToolGroupServer;
import io.modelcontextprotocol.spec.McpSchema.CallToolRequest;
import io.modelcontextprotocol.spec.McpSchema.Tool;

public abstract class AbstractSpringToolGroupServer<ServerType, SpecificationType, ExchangeType, CallToolResultType>
		extends
		AbstractToolGroupServer<ServerType, SpecificationType, Tool, ExchangeType, CallToolRequest, CallToolResultType> {

	protected ToolNodeConverter<Tool> toolNodeConverter;
	protected ToolGroupProvider<SpecificationType, ExchangeType, CallToolRequest, CallToolResultType> toolGroupProvider;

	public AbstractSpringToolGroupServer() {
		this(null);
	}

	public AbstractSpringToolGroupServer(ServerType server) {
		super(server);
		setToolNodeConverter(new SpringNodeConverter());
	}

	protected void setToolGroupProvider(
			ToolGroupProvider<SpecificationType, ExchangeType, CallToolRequest, CallToolResultType> toolGroupProvider) {
		this.toolGroupProvider = toolGroupProvider;
	}

	protected void setToolNodeConverter(ToolNodeConverter<Tool> toolNodeConverter) {
		this.toolNodeConverter = toolNodeConverter;
	}

	protected Tool convertToolNode(ToolNode toolNode) {
		return this.toolNodeConverter.convertFromToolNode(toolNode);
	}

}
