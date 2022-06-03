package soaint.bpmapi.commons.dto;

import java.io.Serializable;

public class ValueDto implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String key;

    private String value;

    /**
     *
     */
    public ValueDto() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ValueDto(String key, String value) {
        super();
        this.key = key;
        this.value = value;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

}
