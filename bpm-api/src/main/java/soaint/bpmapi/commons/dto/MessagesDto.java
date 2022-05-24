/**
 * 
 */
package soaint.bpmapi.commons.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

/**
 * @author ovillamil
 *
 */
public class MessagesDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String severity;

	private BigInteger fecha;

	private List<String> content;

	/**
	 * 
	 */
	public MessagesDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the severity
	 */
	public String getSeverity() {
		return severity;
	}

	/**
	 * @param severity the severity to set
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	/**
	 * @return the fecha
	 */
	public BigInteger getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(BigInteger fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the content
	 */
	public List<String> getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(List<String> content) {
		this.content = content;
	}

}
