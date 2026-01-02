package org.springaicommunity.mcp.provider.toolgroup;

import java.lang.reflect.Method;

import org.springaicommunity.mcp.method.tool.ReturnMode;
import org.springaicommunity.mcp.provider.SpringJsonObjectMapper;
import org.springaicommunity.mcp.provider.SpringNodeConverter;

import io.modelcontextprotocol.mcptools.common.ToolNode;
import io.modelcontextprotocol.mcptools.common.ToolNodeConverter;
import io.modelcontextprotocol.mcptools.toolgroup.AbstractToolGroupProvider;
import io.modelcontextprotocol.spec.McpSchema.CallToolRequest;
import io.modelcontextprotocol.spec.McpSchema.Group;
import io.modelcontextprotocol.spec.McpSchema.Tool;

public abstract class AbstractSpringToolGroupProvider<SpecificationType, ExchangeType, CallToolResultType> extends
		AbstractToolGroupProvider<SpecificationType, Tool, Group, ExchangeType, CallToolRequest, CallToolResultType> {

	protected ToolNodeConverter<Tool> toolNodeConverter;

	protected AbstractSpringToolGroupProvider() {
		setJsonObjectMapper(new SpringJsonObjectMapper());
		setToolNodeConverter(new SpringNodeConverter());
	}

	protected void setToolNodeConverter(ToolNodeConverter<Tool> toolNodeConverter) {
		this.toolNodeConverter = toolNodeConverter;
	}

	protected Tool convertToolNode(ToolNode toolNode) {
		return this.toolNodeConverter.convertFromToolNode(toolNode);
	}

	protected abstract ReturnMode getReturnMode(boolean useStructuredOutput, Method mcpToolMethod);

	protected Class<? extends Throwable> getToolCallException() {
		return Exception.class;
	}

}
