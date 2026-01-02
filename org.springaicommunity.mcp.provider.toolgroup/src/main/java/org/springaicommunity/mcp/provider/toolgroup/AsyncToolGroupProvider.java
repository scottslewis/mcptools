package org.springaicommunity.mcp.provider.toolgroup;

import java.lang.reflect.Method;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import org.springaicommunity.mcp.McpPredicates;
import org.springaicommunity.mcp.method.tool.AsyncMcpToolMethodCallback;
import org.springaicommunity.mcp.method.tool.ReactiveUtils;
import org.springaicommunity.mcp.method.tool.ReturnMode;
import org.springaicommunity.mcp.provider.SpringToolNodeProvider;

import io.modelcontextprotocol.mcptools.common.ToolNode;
import io.modelcontextprotocol.mcptools.toolgroup.AbstractCallHandlerProvider;
import io.modelcontextprotocol.server.McpAsyncServerExchange;
import io.modelcontextprotocol.server.McpServerFeatures.AsyncToolSpecification;
import io.modelcontextprotocol.spec.McpSchema.CallToolRequest;
import io.modelcontextprotocol.spec.McpSchema.CallToolResult;
import reactor.core.publisher.Mono;

public class AsyncToolGroupProvider
		extends AbstractSpringToolGroupProvider<AsyncToolSpecification, McpAsyncServerExchange, Mono<CallToolResult>> {

	public AsyncToolGroupProvider() {
		setToolNodeProvider(new SpringToolNodeProvider.Async());
		setCallHandlerProvider(
				new AbstractCallHandlerProvider<McpAsyncServerExchange, CallToolRequest, Mono<CallToolResult>>() {
					@Override
					public BiFunction<McpAsyncServerExchange, CallToolRequest, Mono<CallToolResult>> getCallHandler(
							Method method, Object impl) {
						return new AsyncMcpToolMethodCallback(getReturnMode(useStructuredOutput, method), method, impl,
								getToolCallException());
					}
				});
	}

	@Override
	protected AsyncToolSpecification buildSpecification(ToolNode toolNode,
			BiFunction<McpAsyncServerExchange, CallToolRequest, Mono<CallToolResult>> callHandler) {
		return AsyncToolSpecification.builder().tool(convertToolNode(toolNode)).callHandler(callHandler).build();
	}

	@Override
	protected Stream<Method> filterMethodStream(Stream<Method> inputStream) {
		return inputStream.filter(McpPredicates.filterNonReactiveReturnTypeMethod());
	}

	@Override
	protected ReturnMode getReturnMode(boolean useStructuredOutput, Method mcpToolMethod) {
		return useStructuredOutput ? ReturnMode.STRUCTURED
				: ReactiveUtils.isReactiveReturnTypeOfVoid(mcpToolMethod) ? ReturnMode.VOID : ReturnMode.TEXT;
	}

}
