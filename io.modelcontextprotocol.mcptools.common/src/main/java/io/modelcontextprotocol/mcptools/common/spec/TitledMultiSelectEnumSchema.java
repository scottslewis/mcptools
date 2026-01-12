package io.modelcontextprotocol.mcptools.common.spec;

import java.util.List;

/**
 * Titled multi select enum schema
 */
public class TitledMultiSelectEnumSchema implements MultiSelectEnumSchema {
	private String type = "array";
	private String title;
	private String description;
	private Integer minItems;
	private Integer maxItems;
	private ArrayItems items;
	private List<String> defaultValue;

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

	public Integer getMinItems() {
		return minItems;
	}

	public void setMinItems(Integer minItems) {
		this.minItems = minItems;
	}

	public Integer getMaxItems() {
		return maxItems;
	}

	public void setMaxItems(Integer maxItems) {
		this.maxItems = maxItems;
	}

	public ArrayItems getItems() {
		return items;
	}

	public void setItems(ArrayItems items) {
		this.items = items;
	}

	public List<String> getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(List<String> defaultValue) {
		this.defaultValue = defaultValue;
	}

	public static class ArrayItems {
		private List<EnumOption> anyOf;

		public List<EnumOption> getAnyOf() {
			return anyOf;
		}

		public void setAnyOf(List<EnumOption> anyOf) {
			this.anyOf = anyOf;
		}
	}

	public static class EnumOption {
		private String constValue;
		private String title;

		public String getConstValue() {
			return constValue;
		}

		public void setConstValue(String constValue) {
			this.constValue = constValue;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}
	}
}
