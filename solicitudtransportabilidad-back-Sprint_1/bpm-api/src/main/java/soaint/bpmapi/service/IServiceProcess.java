package soaint.bpmapi.service;

import soaint.bpmapi.commons.dto.ProcessRequestDto;
import soaint.bpmapi.commons.dto.ProcessResponseDto;
import soaint.bpmapi.commons.dto.TaskResponseDto;
import soaint.bpmapi.commons.exception.webClient.WebClientException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface IServiceProcess {

    ProcessResponseDto StartProcessInstance(ProcessRequestDto requestDto, HttpServletRequest request) throws WebClientException;
    TaskResponseDto ListAllTaskByPotOwner(HttpServletRequest request) throws WebClientException;
    Map<String, Object> UpdateVar(ProcessRequestDto requestDto, HttpServletRequest request) throws WebClientException;
    Map<String, Object> modifyStatusTask(ProcessRequestDto requestDto, HttpServletRequest request) throws WebClientException;

}
