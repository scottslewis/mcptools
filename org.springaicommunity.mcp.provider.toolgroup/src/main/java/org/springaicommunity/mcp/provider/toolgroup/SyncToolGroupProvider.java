package org.springaicommunity.mcp.provider.toolgroup;

import java.lang.reflect.Method;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import org.springaicommunity.mcp.McpPredicates;
import org.springaicommunity.mcp.method.tool.ReturnMode;
import org.springaicommunity.mcp.method.tool.SyncMcpToolMethodCallback;

import io.modelcontextprotocol.mcptools.common.ToolNode;
import io.modelcontextprotocol.mcptools.toolgroup.AbstractCallHandlerProvider;
import io.modelcontextprotocol.server.McpServerFeatures.SyncToolSpecification;
import io.modelcontextprotocol.server.McpSyncServerExchange;
import io.modelcontextprotocol.spec.McpSchema.CallToolRequest;
import io.modelcontextprotocol.spec.McpSchema.CallToolResult;

public class SyncToolGroupProvider
		extends AbstractSpringToolGroupProvider<SyncToolSpecification, McpSyncServerExchange, CallToolResult> {

	public SyncToolGroupProvider(List<Object> toolObjects, Class<?>... toolGroups) {
		super(toolObjects, toolGroups);
		setCallHandlerProvider(
				new AbstractCallHandlerProvider<McpSyncServerExchange, CallToolRequest, CallToolResult>() {
					@Override
					public BiFunction<McpSyncServerExchange, CallToolRequest, CallToolResult> getCallHandler(
							Method method, Object impl) {
						return new SyncMcpToolMethodCallback(getReturnMode(useStructuredOutput, method), method, impl,
								getToolCallException());
					}
				});
	}

	public SyncToolGroupProvider(Object toolObject, Class<?>... toolClasses) {
		this(List.of(toolObject), toolClasses);
	}

	@Override
	protected SyncToolSpecification buildSpecification(ToolNode toolNode,
			BiFunction<McpSyncServerExchange, CallToolRequest, CallToolResult> callHandler) {
		return SyncToolSpecification.builder().tool(convertToolNode(toolNode)).callHandler(callHandler).build();
	}

	@Override
	protected Stream<Method> filterMethodStream(Stream<Method> inputStream) {
		return inputStream.filter(McpPredicates.filterReactiveReturnTypeMethod());
	}

	@Override
	protected ReturnMode getReturnMode(boolean useStructuredOutput, Method mcpToolMethod) {
		Class<?> returnType = mcpToolMethod.getReturnType();
		return useStructuredOutput ? ReturnMode.STRUCTURED
				: (returnType == Void.TYPE || returnType == void.class ? ReturnMode.VOID : ReturnMode.TEXT);
	}

}
