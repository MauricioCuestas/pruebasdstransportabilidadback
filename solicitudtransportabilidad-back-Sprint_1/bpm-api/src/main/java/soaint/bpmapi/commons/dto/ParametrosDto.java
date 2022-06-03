package soaint.bpmapi.commons.dto;

import java.io.Serializable;
import java.util.Map;

public class ParametrosDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private ValueDto value;

    private Map<String, Object> values;


    public ParametrosDto() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Map<String, Object> getValues() {
        return values;
    }

    public void setValues(Map<String, Object> values) {
        this.values = values;
    }

    /**
     * @return the value
     */
    public ValueDto getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(ValueDto value) {
        this.value = value;
    }

}
