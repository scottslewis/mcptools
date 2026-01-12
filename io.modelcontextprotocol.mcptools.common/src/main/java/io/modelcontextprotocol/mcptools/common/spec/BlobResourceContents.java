package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Blob resource contents (base64 encoded)
 */
public class BlobResourceContents extends ResourceContents {
	private String blob;

	public String getBlob() {
		return blob;
	}

	public void setBlob(String blob) {
		this.blob = blob;
	}
}
