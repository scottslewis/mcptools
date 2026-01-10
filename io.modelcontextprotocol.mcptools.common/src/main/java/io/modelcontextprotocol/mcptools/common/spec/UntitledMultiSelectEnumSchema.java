package io.modelcontextprotocol.mcptools.common.spec;

import java.util.List;

/**
 * Untitled multi select enum schema
 */
public class UntitledMultiSelectEnumSchema implements MultiSelectEnumSchema {
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
        private String type = "string";
        private List<String> enumValues;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<String> getEnumValues() {
            return enumValues;
        }

        public void setEnumValues(List<String> enumValues) {
            this.enumValues = enumValues;
        }
    }
}
