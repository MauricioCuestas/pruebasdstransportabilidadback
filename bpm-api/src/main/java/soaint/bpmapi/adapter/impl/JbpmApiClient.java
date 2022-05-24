package soaint.bpmapi.adapter.impl;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import soaint.bpmapi.adapter.IJbpmApiClient;
import soaint.bpmapi.commons.converter.TaskConverter;
import soaint.bpmapi.commons.dto.ProcessRequestDto;
import soaint.bpmapi.commons.dto.ProcessResponseDto;
import soaint.bpmapi.commons.dto.TaskResponse;
import soaint.bpmapi.commons.dto.TaskResponseDto;
import soaint.bpmapi.commons.exception.webClient.BusinessException;
import soaint.bpmapi.commons.exception.webClient.WebClientException;
import soaint.bpmapi.commons.util.enums.ValidationUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Component
public class JbpmApiClient implements IJbpmApiClient {

    private RestTemplate template = new RestTemplate();

    @Value("${endpoint.api.jbpm.process.startProcessInstance}")
    public String ENDPOINT_INICIAR_INSTANCIA;

    @Value("${endpoint.api.jbpm.task.pot-owner}")
    public String ENDPOINT_LISTAR_TAREAS_BY_POT_OWNERS;

    @Value("${endpoint.api.jbpm.process.variables}")
    public String ENDPOINT_LISTAR_VARIABLES_BY_PROCESSINSTANCE;

    @Value("${endpoint.api.jbpm.process.modifyvariables}")
    public String ENDPOINT_UPDATE_VARIABLES;

    @Value("${endpoint.api.jbpm.process.modifyStatus}")
    public String ENDPOINT_MODIFY_STATUS;

    @Override
    public ProcessResponseDto iniciarInstanciaProceso(ProcessRequestDto procesoRq, HttpServletRequest request) throws WebClientException {
        ProcessResponseDto responseDto = new ProcessResponseDto();
        try {
            String url = ENDPOINT_INICIAR_INSTANCIA
                    .concat(procesoRq.getContainerId())
                    .concat("/processes/").concat(procesoRq.getProcessId())
                    .concat("/instances");
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.AUTHORIZATION, request.getHeader(HttpHeaders.AUTHORIZATION));
            headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
            Map<String, Object> body = new HashMap<>();
            if (procesoRq.getParametros() != null) {
                if (procesoRq.getParametros().getValues() != null) {
                    body = procesoRq.getParametros().getValues();
                }
            }
            HttpEntity<?> entity = new HttpEntity<>(body, headers);
            ResponseEntity<String> responseService = template.exchange(url, HttpMethod.POST, entity, String.class);
            responseDto.setProcessInstanceId(responseService.getBody());
            return responseDto;
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            throw ValidationUtils.catchServerClientException(e);
        } catch (Exception e) {
            ValidationUtils.printLogErrorCatchException(e);
            throw new WebClientException(BusinessException.codeCatchAllException, e.getMessage());
        }
    }

    @Override
    public TaskResponseDto listAllTaskByPotOwners(HttpServletRequest request) throws WebClientException {
        TaskResponseDto responseDto = new TaskResponseDto();
        try {
            String url = ENDPOINT_LISTAR_TAREAS_BY_POT_OWNERS;

            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.AUTHORIZATION, request.getHeader(HttpHeaders.AUTHORIZATION));
            headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
            HttpEntity<?> entity = new HttpEntity<>(null, headers);
            ResponseEntity<String> responseService = template.exchange(url, HttpMethod.GET, entity, String.class);
            Gson gson = new Gson();
            if (responseService.getStatusCode().equals(HttpStatus.OK)) {
                TaskResponse response = gson.fromJson(responseService.getBody(), TaskResponse.class);
                responseDto = TaskConverter.taskResponseToTaskResponseDto(response);
            }
            return responseDto;
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            throw ValidationUtils.catchServerClientException(e);
        } catch (Exception e) {
            ValidationUtils.printLogErrorCatchException(e);
            throw new WebClientException(BusinessException.codeCatchAllException, e.getMessage());
        }
    }

    @Override
    public Map<String, Object> listAllVariablesByProcessInstance(String processInstance, String containerId, HttpServletRequest request) throws WebClientException {
        Map<String, Object> responseDto = new HashMap<>();
        try {
            String url = ENDPOINT_LISTAR_VARIABLES_BY_PROCESSINSTANCE
                    .concat(containerId)
                    .concat("/processes/instances/")
                    .concat(processInstance)
                    .concat("/variables");
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.AUTHORIZATION, request.getHeader(HttpHeaders.AUTHORIZATION));
            headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
            HttpEntity<?> entity = new HttpEntity<>(null, headers);
            ResponseEntity<String> responseService = template.exchange(url, HttpMethod.GET, entity, String.class);
            Gson gson = new Gson();
            if (responseService.getStatusCode().equals(HttpStatus.OK)) {
                responseDto = gson.fromJson(responseService.getBody(), Map.class);
            }
            return responseDto;
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            throw ValidationUtils.catchServerClientException(e);
        } catch (Exception e) {
            ValidationUtils.printLogErrorCatchException(e);
            throw new WebClientException(BusinessException.codeCatchAllException, e.getMessage());
        }
    }

    @Override
    public Map<String, Object> modifyvariables(ProcessRequestDto procesoRq, HttpServletRequest request) throws WebClientException {
        Map<String, Object> responseDto = new HashMap<>();
        try {
            String url = ENDPOINT_UPDATE_VARIABLES
                    .concat(procesoRq.getContainerId())
                    .concat("/processes/").concat("instances/")
                    .concat(procesoRq.getProcessInstanceId())
                    .concat("/variables");

            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.AUTHORIZATION, request.getHeader(HttpHeaders.AUTHORIZATION));
            headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
            Map<String, Object> body = new HashMap<>();
            if (procesoRq.getParametros() != null) {
                if (procesoRq.getParametros().getValues() != null) {
                    body = procesoRq.getParametros().getValues();
                }
            }
            HttpEntity<?> entity = new HttpEntity<>(body, headers);
            ResponseEntity<String> responseService = template.exchange(url, HttpMethod.POST, entity, String.class);
            Map<String, Object> response = new HashMap<>();
            response.put("mensage", "variables  actualizadas en proceso");
            response.put("processinstaceid", procesoRq.getProcessInstanceId());
            return response;
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            throw ValidationUtils.catchServerClientException(e);
        } catch (Exception e) {
            ValidationUtils.printLogErrorCatchException(e);
            throw new WebClientException(BusinessException.codeCatchAllException, e.getMessage());
        }
    }
//PRueba
    @Override
    public Map<String, Object> modifyStatusTask(ProcessRequestDto procesoRq, HttpServletRequest request) throws WebClientException {
        Map<String, Object> responseDto = new HashMap<>();
        try {
            if (procesoRq.getContainerId() == null) {
                throw new WebClientException("0002", "el id del contenedor no puede ser null");
            }
            if (procesoRq.getTaskId() == null) {
                throw new WebClientException("0003", "el id de la tarea no puede ser null");
            }
            if (procesoRq.getTaskStatus() == null) {
                throw new WebClientException("0004", "definir el status al que se desea actualizar la tarea");
            }
            String url = ENDPOINT_MODIFY_STATUS
                    .concat(procesoRq.getContainerId())
                    .concat("/tasks/")
                    .concat(procesoRq.getTaskId())
                    .concat("/states/")
                    .concat(procesoRq.getTaskStatus());
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.AUTHORIZATION, request.getHeader(HttpHeaders.AUTHORIZATION));
            headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
            Map<String, Object> body = new HashMap<>();
            if (procesoRq.getParametros() != null) {
                if (procesoRq.getParametros().getValues() != null) {
                    body = procesoRq.getParametros().getValues();
                }
            }
            System.out.println("URL " + url);
            System.out.println("BODY " + body);
            System.out.println("HEADER " + headers);
            ResponseEntity<String> responseService = template.exchange(url, HttpMethod.PUT, new HttpEntity<>(body, headers), String.class);
            //            responseDto.setProcessInstanceId(responseService.getBody());
            responseDto.put("taskId", procesoRq.getTaskId());
            responseDto.put("taskStatus", procesoRq.getTaskStatus());
            return responseDto;
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            e.printStackTrace();
            throw ValidationUtils.catchServerClientException(e);
        } catch (Exception e) {
            e.printStackTrace();
            ValidationUtils.printLogErrorCatchException(e);
            throw new WebClientException(BusinessException.codeCatchAllException, e.getMessage());
        }
    }
}
