/**
 * 
 */
package soaint.bpmapi.commons.dto;

import java.io.Serializable;

/**
 * @author ovillamil
 *
 */
public class InstanceDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String instanceId;

	/**
	 * 
	 */
	public InstanceDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the instanceId
	 */
	public String getInstanceId() {
		return instanceId;
	}

	/**
	 * @param instanceId the instanceId to set
	 */
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}
	
}
