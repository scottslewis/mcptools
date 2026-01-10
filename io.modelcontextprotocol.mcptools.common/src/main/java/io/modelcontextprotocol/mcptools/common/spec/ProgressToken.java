package io.modelcontextprotocol.mcptools.common.spec;

public class ProgressToken {
    private String stringValue;
    private Number numberValue;
    private boolean isString;

    public ProgressToken(String value) {
        this.stringValue = value;
        this.isString = true;
    }

    public ProgressToken(Number value) {
        this.numberValue = value;
        this.isString = false;
    }

    public boolean isString() {
        return isString;
    }

    public String getStringValue() {
        return stringValue;
    }

    public Number getNumberValue() {
        return numberValue;
    }

    public Object getValue() {
        return isString ? stringValue : numberValue;
    }

    @Override
    public String toString() {
        return isString ? stringValue : String.valueOf(numberValue);
    }
}
