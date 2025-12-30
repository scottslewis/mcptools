package org.springaicommunity.mcp.provider.toolgroup;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.springaicommunity.mcp.method.tool.ReturnMode;
import org.springaicommunity.mcp.provider.SpringJsonObjectMapper;
import org.springaicommunity.mcp.provider.SpringNodeConverter;
import org.springaicommunity.mcp.provider.SpringToolNodeProvider;

import io.modelcontextprotocol.mcptools.common.ToolNode;
import io.modelcontextprotocol.mcptools.common.ToolNodeConverter;
import io.modelcontextprotocol.mcptools.toolgroup.AbstractToolGroupProvider;
import io.modelcontextprotocol.spec.McpSchema.CallToolRequest;
import io.modelcontextprotocol.spec.McpSchema.Group;
import io.modelcontextprotocol.spec.McpSchema.Tool;
import io.modelcontextprotocol.util.Assert;

public abstract class AbstractSpringToolGroupProvider<SpecificationType, ExchangeType, CallToolResultType> extends
		AbstractToolGroupProvider<SpecificationType, Tool, Group, ExchangeType, CallToolRequest, CallToolResultType> {

	protected final Class<?>[] toolClasses;
	protected final List<Object> toolObjects;
	protected final ToolNodeConverter<Tool> toolNodeConverter;

	protected AbstractSpringToolGroupProvider(List<Object> toolObjects, Class<?>... toolGroups) {
		Assert.notNull(toolGroups, "toolClasses cannot be null");
		this.toolObjects = toolObjects;
		this.toolClasses = toolGroups;
		// verify that every toolObject is instance of all toolClasses
		this.toolObjects.forEach(toolObject -> {
			Arrays.asList(this.toolClasses).forEach(clazz -> Assert.isTrue(clazz.isInstance(toolObject),
					String.format("toolObject=%s is not an instance of %s", toolObject, clazz.getName())));
		});
		setJsonObjectMapper(new SpringJsonObjectMapper());
		setToolNodeProvider(new SpringToolNodeProvider());
		this.toolNodeConverter = new SpringNodeConverter();
	}

	protected Tool convertToolNode(ToolNode toolNode) {
		return this.toolNodeConverter.convertToolNode(toolNode);
	}

	protected abstract ReturnMode getReturnMode(boolean useStructuredOutput, Method mcpToolMethod);

	protected Class<? extends Throwable> getToolCallException() {
		return Exception.class;
	}

}
