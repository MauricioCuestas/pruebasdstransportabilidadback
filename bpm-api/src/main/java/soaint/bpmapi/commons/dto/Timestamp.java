
package soaint.bpmapi.commons.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.math.BigInteger;

public class Timestamp {

    @SerializedName("java.util.Date")
    @Expose
    private BigInteger javaUtilDate;

    /**
     *
     */
    public Timestamp() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the javaUtilDate
     */
    public BigInteger getJavaUtilDate() {
        return javaUtilDate;
    }

    /**
     * @param javaUtilDate the javaUtilDate to set
     */
    public void setJavaUtilDate(BigInteger javaUtilDate) {
        this.javaUtilDate = javaUtilDate;
    }

}
