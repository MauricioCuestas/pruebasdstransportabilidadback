/**
 * 
 */
package soaint.bpmapi.commons.dto;

import java.io.Serializable;

/**
 * @author ovillamil
 *
 */
public class SignalDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String signalName;
	private ParametrosDto parametros;

	/**
	 * 
	 */
	public SignalDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the signalName
	 */
	public String getSignalName() {
		return signalName;
	}

	/**
	 * @param signalName the signalName to set
	 */
	public void setSignalName(String signalName) {
		this.signalName = signalName;
	}

	/**
	 * @return the parametros
	 */
	public ParametrosDto getParametros() {
		return parametros;
	}

	/**
	 * @param parametros the parametros to set
	 */
	public void setParametros(ParametrosDto parametros) {
		this.parametros = parametros;
	}
	
}
