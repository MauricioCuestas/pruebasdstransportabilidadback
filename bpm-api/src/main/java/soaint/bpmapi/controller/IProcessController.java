package soaint.bpmapi.controller;

import org.springframework.http.ResponseEntity;
import soaint.bpmapi.commons.dto.ProcessRequestDto;
import soaint.bpmapi.commons.exception.webClient.WebClientException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface IProcessController {

    ResponseEntity iniProcessIntances(ProcessRequestDto requestDto, HttpServletRequest request);

    ResponseEntity ListAllTaskByPotOwner(HttpServletRequest request);

    ResponseEntity actualizarvariables(ProcessRequestDto requestDto, HttpServletRequest request);

    ResponseEntity ModifyStatusTask(ProcessRequestDto requestDto, HttpServletRequest request);


}
