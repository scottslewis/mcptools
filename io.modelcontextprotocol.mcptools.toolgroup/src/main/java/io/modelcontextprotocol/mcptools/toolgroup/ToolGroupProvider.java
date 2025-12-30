package io.modelcontextprotocol.mcptools.toolgroup;

import java.util.List;

import io.modelcontextprotocol.mcptools.common.GroupNode;

public interface ToolGroupProvider<SpecificationType> {

	List<SpecificationType> getToolGroupSpecifications(List<Object> toolObjects, Class<?>... classes);

	List<SpecificationType> getToolGroupSpecifications(Object toolObject, Class<?> toolClass, GroupNode toolGroup);

}
