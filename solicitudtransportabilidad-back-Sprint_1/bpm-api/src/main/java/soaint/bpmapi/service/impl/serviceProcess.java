package soaint.bpmapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soaint.bpmapi.adapter.IJbpmApiClient;
import soaint.bpmapi.commons.dto.ProcessRequestDto;
import soaint.bpmapi.commons.dto.ProcessResponseDto;
import soaint.bpmapi.commons.dto.TaskDto;
import soaint.bpmapi.commons.exception.webClient.WebClientException;
import soaint.bpmapi.service.IServiceProcess;
import soaint.bpmapi.commons.dto.TaskResponseDto;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Service
public class serviceProcess implements IServiceProcess {

    @Autowired
    IJbpmApiClient iJbpmApiClient;
    @Override
    public ProcessResponseDto StartProcessInstance(ProcessRequestDto requestDto, HttpServletRequest request) throws WebClientException, WebClientException {
        return iJbpmApiClient.iniciarInstanciaProceso(requestDto, request);
    }

    @Override
    public TaskResponseDto ListAllTaskByPotOwner(HttpServletRequest request) throws WebClientException {
        try {
            TaskResponseDto responseDto = iJbpmApiClient.listAllTaskByPotOwners(request);
            if (responseDto != null && responseDto.getTasks() != null && !responseDto.getTasks().isEmpty()) {
                for (TaskDto dto : responseDto.getTasks()){
                    dto.setVariables(iJbpmApiClient.listAllVariablesByProcessInstance(dto.getInstanceId(), dto.getContainerId(), request));
                }
            }
            return responseDto;
        }catch (WebClientException e){
            throw new WebClientException("001","ERROR AL LISTAR TODAS LAS TAREAS CON VARIABLES");
        }
    }

    @Override
    public Map<String, Object> UpdateVar(ProcessRequestDto requestDto, HttpServletRequest request) throws WebClientException {
        return iJbpmApiClient.modifyvariables(requestDto, request);
    }

    @Override
    public Map<String, Object> modifyStatusTask(ProcessRequestDto requestDto, HttpServletRequest request) throws WebClientException {
        return iJbpmApiClient.modifyStatusTask(requestDto, request);
    }
}
