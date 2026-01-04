package org.springaicommunity.mcp.provider.toolgroup.server;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springaicommunity.mcp.provider.SpringNodeConverter;

import io.modelcontextprotocol.mcptools.common.ToolNode;
import io.modelcontextprotocol.mcptools.toolgroup.ToolNodeSpecification;
import io.modelcontextprotocol.mcptools.toolgroup.server.AbstractToolGroupServer;
import io.modelcontextprotocol.spec.McpSchema.CallToolRequest;
import io.modelcontextprotocol.spec.McpSchema.ServerCapabilities;
import io.modelcontextprotocol.spec.McpSchema.Tool;
import io.modelcontextprotocol.spec.McpServerTransportProvider;

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

	protected ServerCapabilities buildServerCapabilities() {
		return ServerCapabilities.builder().tools(true).build();
	}

	protected abstract ServerType buildServer(String serverName, String serverVersion,
			ServerCapabilities serverCapabilities, McpServerTransportProvider transport);

	protected ServerType buildServerFromProperties(Map<String, Object> properties) {
		String serverName = (String) properties.get(SERVER_NAME_PROP);
		Objects.requireNonNull(serverName, SERVER_NAME_PROP + "property must not be null");
		String serverVersion = (String) properties.get(SERVER_VERSION_PROP);
		Objects.requireNonNull(serverVersion, SERVER_VERSION_PROP + " property must not be null");
		McpServerTransportProvider transport = (McpServerTransportProvider) properties.get(SERVER_TRANSPORT_PROP);
		Objects.requireNonNull(transport, SERVER_TRANSPORT_PROP + " property must not be null");
		ServerCapabilities serverCapabilities = (ServerCapabilities) properties.get(SERVER_CAPABILITIES_PROP);
		if (serverCapabilities == null) {
			serverCapabilities = buildServerCapabilities();
		}
		return buildServer(serverName, serverVersion, serverCapabilities, transport);
	}

}
