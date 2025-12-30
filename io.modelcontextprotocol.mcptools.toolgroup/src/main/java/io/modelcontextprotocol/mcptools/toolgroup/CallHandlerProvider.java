package io.modelcontextprotocol.mcptools.toolgroup;

import java.lang.reflect.Method;
import java.util.function.BiFunction;

public interface CallHandlerProvider<ExchangeType, CallToolRequestType, CallToolResultType> {

	BiFunction<ExchangeType, CallToolRequestType, CallToolResultType> getCallHandler(Method method, Object impl);
}
