package io.modelcontextprotocol.mcptools.toolgroup;

import java.util.Objects;

import io.modelcontextprotocol.mcptools.common.ToolNode;

public class ToolNodeSpecification<SpecificationType> {

	protected final ToolNode toolNode;
	protected final SpecificationType specification;

	public ToolNodeSpecification(ToolNode toolNode, SpecificationType specification) {
		Objects.requireNonNull(toolNode, "toolNode must not be null");
		this.toolNode = toolNode;
		this.specification = specification;
	}

	public ToolNode getToolNode() {
		return this.toolNode;
	}

	public SpecificationType getSpecification() {
		return this.specification;
	}
}
