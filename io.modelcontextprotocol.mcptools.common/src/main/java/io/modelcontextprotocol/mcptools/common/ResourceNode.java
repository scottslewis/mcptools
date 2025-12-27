package io.modelcontextprotocol.mcptools.common;

public class ResourceNode extends BaseLeafNode {

	protected String uri;

	protected Long size;

	protected String mimeType;

	protected AnnotationsNode annotations;

	protected String lastModified;

	public ResourceNode(String name) {
		super(name);
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getLastModified() {
		return lastModified;
	}

	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	public AnnotationsNode getAnnotations() {
		return annotations;
	}

	public void setAnnotations(AnnotationsNode annotations) {
		this.annotations = annotations;
	}

//	public McpSchema.Resource.Builder convert() {
//		McpSchema.Resource.Builder resourceBuilder = new McpSchema.Resource.Builder();
//		resourceBuilder.name(getName());
//		resourceBuilder.title(getTitle());
//		resourceBuilder.description(getDescription());
//		resourceBuilder.uri(getUri());
//		resourceBuilder.size(getSize());
//		resourceBuilder.mimeType(getMimeType());
//		AnnotationsNode an = getAnnotations();
//		if (an != null) {
//			resourceBuilder.annotations(an.serialize());
//		}
//		return resourceBuilder;
//	}
//
	@Override
	public String toString() {
		return "ResourceNode [name=" + name + ", title=" + title + ", description=" + description + ", meta=" + meta
				+ ", uri=" + uri + ", size=" + size + ", mimeType=" + mimeType + ", annotations=" + annotations
				+ ", lastModified=" + lastModified + "]";
	}

}
