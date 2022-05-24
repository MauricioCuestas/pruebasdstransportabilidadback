package soaint.bpmapi.commons.dto;

import java.io.Serializable;

/**
 * 
 * @author jjmorales
 *
 */
public class InputDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String inputId;

	private String inputName;
	
	public InputDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return the inputId
	 */
	public String getInputId() {
		return inputId;
	}

	/**
	 * 
	 * @param inputId the inputId to set
	 */
	public void setInputId(String inputId) {
		this.inputId = inputId;
	}

	/**
	 * 
	 * @return the inputName
	 */
	public String getInputName() {
		return inputName;
	}

	/**
	 * 
	 * @param inputName the inputName to set
	 */
	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

}
