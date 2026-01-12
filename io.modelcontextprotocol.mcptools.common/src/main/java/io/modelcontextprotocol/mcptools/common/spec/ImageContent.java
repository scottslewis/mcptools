package io.modelcontextprotocol.mcptools.common.spec;

import java.util.Map;

/**
 * Image content block
 */
public class ImageContent implements ContentBlock {
	private String type = "image";
	private String data;
	private String mimeType;
	private Annotations annotations;
	private Map<String, Object> _meta;

	@Override
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public Annotations getAnnotations() {
		return annotations;
	}

	public void setAnnotations(Annotations annotations) {
		this.annotations = annotations;
	}

	public Map<String, Object> get_meta() {
		return _meta;
	}

	public void set_meta(Map<String, Object> _meta) {
		this._meta = _meta;
	}
}
