package org.springaicommunity.mcp.provider.toolgroup.server;

import io.modelcontextprotocol.mcptools.common.ToolNode;
import io.modelcontextprotocol.mcptools.common.ToolNodeConverter;
import io.modelcontextprotocol.mcptools.toolgroup.server.AbstractToolGroupServer;
import io.modelcontextprotocol.spec.McpSchema.CallToolRequest;
import io.modelcontextprotocol.spec.McpSchema.Tool;

public abstract class AbstractSpringToolGroupServer<ServerType, SpecificationType, ExchangeType, CallToolResultType>
		extends
		AbstractToolGroupServer<ServerType, SpecificationType, Tool, ExchangeType, CallToolRequest, CallToolResultType> {

	public AbstractSpringToolGroupServer() {
		super();
	}

	public AbstractSpringToolGroupServer(ServerType server) {
		super(server);
	}

	protected ToolNodeConverter<Tool> toolNodeConverter;

	protected void setToolNodeConverter(ToolNodeConverter<Tool> toolNodeConverter) {
		this.toolNodeConverter = toolNodeConverter;
	}

	protected Tool convertToolNode(ToolNode toolNode) {
		return this.toolNodeConverter.convertToolNode(toolNode);
	}

}
