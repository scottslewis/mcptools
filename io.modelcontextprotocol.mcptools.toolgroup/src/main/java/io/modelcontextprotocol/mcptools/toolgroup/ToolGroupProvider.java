package io.modelcontextprotocol.mcptools.toolgroup;

import java.lang.reflect.Method;
import java.util.List;

import io.modelcontextprotocol.mcptools.common.ToolNode;

public interface ToolGroupProvider<SpecificationType, ExchangeType, CallRequestType, CallResultType> {

	List<ToolNodeSpecification<SpecificationType>> getToolGroupSpecifications(Object toolGroupObject,
			Class<?>... classes);

	List<ToolNodeSpecification<SpecificationType>> getToolGroupSpecifications(List<Object> toolGroupObjects,
			Class<?>... classes);

	public ToolNodeSpecification<SpecificationType> getToolNodeSpecification(ToolNode toolNode, Method toolMethod, Object instance, boolean outputSchema);
}
