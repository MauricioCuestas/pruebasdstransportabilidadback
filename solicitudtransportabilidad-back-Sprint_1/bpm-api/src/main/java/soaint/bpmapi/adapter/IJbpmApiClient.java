package soaint.bpmapi.adapter;

import soaint.bpmapi.commons.dto.ProcessRequestDto;
import soaint.bpmapi.commons.dto.ProcessResponseDto;
import soaint.bpmapi.commons.dto.TaskResponseDto;
import soaint.bpmapi.commons.exception.webClient.WebClientException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface IJbpmApiClient {

    ProcessResponseDto iniciarInstanciaProceso(ProcessRequestDto procesoRq, HttpServletRequest request) throws WebClientException;

    TaskResponseDto listAllTaskByPotOwners(HttpServletRequest request) throws WebClientException;

    Map<String, Object> listAllVariablesByProcessInstance(String processInstance, String containerId, HttpServletRequest request) throws WebClientException;

    Map<String, Object> modifyvariables(ProcessRequestDto procesoRq, HttpServletRequest request) throws WebClientException;

    Map<String, Object> modifyStatusTask(ProcessRequestDto procesoRq, HttpServletRequest request) throws WebClientException;

}
