package org.springaicommunity.mcp.provider.toolgroup.server;

import java.util.List;

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
	protected ToolGroupProvider<SpecificationType> toolGroupProvider;

	public AbstractSpringToolGroupServer() {
		this(null);
	}

	public AbstractSpringToolGroupServer(ServerType server) {
		super(server);
		setToolNodeConverter(new SpringNodeConverter());
	}

	protected void setToolGroupProvider(ToolGroupProvider<SpecificationType> toolGroupProvider) {
		this.toolGroupProvider = toolGroupProvider;
	}

	protected void setToolNodeConverter(ToolNodeConverter<Tool> toolNodeConverter) {
		this.toolNodeConverter = toolNodeConverter;
	}

	protected Tool convertToolNode(ToolNode toolNode) {
		return this.toolNodeConverter.convertFromToolNode(toolNode);
	}

	@Override
	public void addToolGroup(Object instance, Class<?>... classes) {
		this.toolGroupProvider.getToolGroupSpecifications(List.of(instance), classes).forEach(s -> {
			addTool(this.server, s);
		});
	}

}
