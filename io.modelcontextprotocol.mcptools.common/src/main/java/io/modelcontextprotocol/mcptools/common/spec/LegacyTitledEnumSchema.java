package io.modelcontextprotocol.mcptools.common.spec;

import java.util.List;

/**
 * Legacy titled enum schema
 */
public class LegacyTitledEnumSchema implements PrimitiveSchemaDefinition {
	private String type = "string";
	private String title;
	private String description;
	private List<String> enumValues;
	private List<String> enumNames;
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

	public List<String> getEnumNames() {
		return enumNames;
	}

	public void setEnumNames(List<String> enumNames) {
		this.enumNames = enumNames;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
}
