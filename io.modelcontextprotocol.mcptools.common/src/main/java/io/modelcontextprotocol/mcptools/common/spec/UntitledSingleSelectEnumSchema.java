package io.modelcontextprotocol.mcptools.common.spec;

import java.util.List;

/**
 * Untitled single select enum schema
 */
public class UntitledSingleSelectEnumSchema implements SingleSelectEnumSchema {
	private String type = "string";
	private String title;
	private String description;
	private List<String> enumValues;
	private String defaultValue;

	@Override
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getEnumValues() {
		return enumValues;
	}

	public void setEnumValues(List<String> enumValues) {
		this.enumValues = enumValues;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
}
