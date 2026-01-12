package io.modelcontextprotocol.mcptools.common.spec;

import java.util.List;

/**
 * Titled single select enum schema
 */
public class TitledSingleSelectEnumSchema implements SingleSelectEnumSchema {
	private String type = "string";
	private String title;
	private String description;
	private List<EnumOption> oneOf;
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

	public List<EnumOption> getOneOf() {
		return oneOf;
	}

	public void setOneOf(List<EnumOption> oneOf) {
		this.oneOf = oneOf;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
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
