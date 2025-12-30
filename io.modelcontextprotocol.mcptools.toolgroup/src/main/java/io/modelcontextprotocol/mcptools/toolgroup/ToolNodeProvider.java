package io.modelcontextprotocol.mcptools.toolgroup;

import java.lang.reflect.Method;

import io.modelcontextprotocol.mcptools.annotation.McpTool;
import io.modelcontextprotocol.mcptools.common.GroupNode;
import io.modelcontextprotocol.mcptools.common.ToolNode;

public interface ToolNodeProvider {

	public static final String SEPARATOR = ".";

	ToolNode getToolNode(McpTool mcpToolAnnotation, Method mcpToolMethod, GroupNode group);

}
