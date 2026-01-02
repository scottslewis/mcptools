package io.modelcontextprotocol.mcptools.toolgroup;

import java.util.List;

public interface ToolGroupProvider<SpecificationType> {

	List<SpecificationType> getToolGroupSpecifications(List<Object> toolObjects, Class<?>... classes);

}
