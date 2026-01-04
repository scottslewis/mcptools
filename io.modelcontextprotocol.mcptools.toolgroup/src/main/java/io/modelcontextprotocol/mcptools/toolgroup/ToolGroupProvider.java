package io.modelcontextprotocol.mcptools.toolgroup;

import java.util.List;

public interface ToolGroupProvider<SpecificationType, ExchangeType, CallRequestType, CallResultType> {

	List<ToolNodeSpecification<SpecificationType>> getToolGroupSpecifications(Object toolGroupObject,
			Class<?>... classes);

	List<ToolNodeSpecification<SpecificationType>> getToolGroupSpecifications(List<Object> toolGroupObjects,
			Class<?>... classes);

}
