package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Number schema definition
 */
public class NumberSchema implements PrimitiveSchemaDefinition {
	private String type; // "number" or "integer"
	private String title;
	private String description;
	private Number minimum;
	private Number maximum;
	private Number defaultValue;

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

	public Number getMinimum() {
		return minimum;
	}

	public void setMinimum(Number minimum) {
		this.minimum = minimum;
	}

	public Number getMaximum() {
		return maximum;
	}

	public void setMaximum(Number maximum) {
		this.maximum = maximum;
	}

	public Number getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(Number defaultValue) {
		this.defaultValue = defaultValue;
	}
}
