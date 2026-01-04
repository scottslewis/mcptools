package org.springaicommunity.mcp.provider.toolgroup.server;

import java.util.List;

import org.springaicommunity.mcp.provider.SpringNodeConverter;

import io.modelcontextprotocol.mcptools.common.ToolNode;
import io.modelcontextprotocol.mcptools.toolgroup.ToolNodeSpecification;
import io.modelcontextprotocol.mcptools.toolgroup.server.AbstractToolGroupServer;
import io.modelcontextprotocol.spec.McpSchema.CallToolRequest;
import io.modelcontextprotocol.spec.McpSchema.Tool;

public abstract class AbstractSpringToolGroupServer<ServerType, SpecificationType, ExchangeType, CallToolResultType>
		extends
		AbstractToolGroupServer<ServerType, SpecificationType, Tool, ExchangeType, CallToolRequest, CallToolResultType> {

	public AbstractSpringToolGroupServer() {
		setToolNodeConverter(new SpringNodeConverter());
	}

	protected Tool convertToolNode(ToolNode toolNode) {
		return this.toolNodeConverter.convertFromToolNode(toolNode);
	}

	@Override
	public List<ToolNode> addToolGroup(Object instance, Class<?>... classes) {
		List<ToolNodeSpecification<SpecificationType>> specs = this.toolGroupProvider
				.getToolGroupSpecifications(instance, classes);
		specs.forEach(s -> {
			addTool(this.server, s.getSpecification());
		});
		return specs.stream().map(sp -> {
			return sp.getToolNode();
		}).toList();
	}

}
