package io.modelcontextprotocol.mcptools.common;

import java.util.List;

public class AnnotationsNode {

	private List<RoleNode> audience;

	private Double priority;

	private String lastModified;

	public AnnotationsNode(List<RoleNode> audience, Double priority, String lastModified) {
		this.audience = audience;
		this.priority = priority;
		this.lastModified = lastModified;
	}

//	public McpSchema.Annotations serialize() {
//		return new McpSchema.Annotations(getAudience(), getPriority(), getLastModified());
//	}
//
//	public static AnnotationsNode deserialize(Annotations annotations) {
//		return new AnnotationsNode(annotations.audience(), annotations.priority(), annotations.lastModified());
//	}
//
	public List<RoleNode> getAudience() {
		return audience;
	}

	public void setAudience(List<RoleNode> audience) {
		this.audience = audience;
	}

	public Double getPriority() {
		return priority;
	}

	public void setPriority(Double priority) {
		this.priority = priority;
	}

	public String getLastModified() {
		return lastModified;
	}

	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	@Override
	public String toString() {
		return "AnnotationsNode [audience=" + audience + ", priority=" + priority + ", lastModified=" + lastModified
				+ "]";
	}

}
