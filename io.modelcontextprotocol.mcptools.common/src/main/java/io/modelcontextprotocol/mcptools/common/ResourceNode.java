package io.modelcontextprotocol.mcptools.common;

public class ResourceNode extends BaseLeafNode {

	protected String uri;

	protected Long size;

	protected String mimeType;

	protected AnnotationsNode annotations;

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

	public AnnotationsNode getAnnotations() {
		return annotations;
	}

	public void setAnnotations(AnnotationsNode annotations) {
		this.annotations = annotations;
	}

	@Override
	public String toString() {
		return "ResourceNode [name=" + name + ", title=" + title + ", description=" + description + ", meta=" + meta
				+ ", uri=" + uri + ", size=" + size + ", mimeType=" + mimeType + ", annotations=" + annotations
				+ "]";
	}

}
