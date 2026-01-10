package io.modelcontextprotocol.mcptools.common.spec;

/**
 * Request ID can be either a string or a number
 */
public class RequestId {
    private String stringValue;
    private Number numberValue;
    private boolean isString;

    public RequestId(String value) {
        this.stringValue = value;
        this.isString = true;
    }

    public RequestId(Number value) {
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
