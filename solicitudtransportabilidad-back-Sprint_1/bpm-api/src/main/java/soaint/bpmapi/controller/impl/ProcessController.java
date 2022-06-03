package soaint.bpmapi.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soaint.bpmapi.commons.dto.ProcessRequestDto;
import soaint.bpmapi.commons.dto.ProcessResponseDto;
import soaint.bpmapi.commons.dto.ResponseBuilder;
import soaint.bpmapi.commons.dto.TaskResponseDto;
import soaint.bpmapi.commons.exception.webClient.BusinessException;
import soaint.bpmapi.commons.exception.webClient.WebClientException;
import soaint.bpmapi.commons.util.EndPointProcessApi;
import soaint.bpmapi.commons.util.enums.TransactionState;
import soaint.bpmapi.controller.IProcessController;
import soaint.bpmapi.service.IServiceProcess;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping(value = EndPointProcessApi.PROCESS_API_V0)
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProcessController implements IProcessController {

    @Autowired
    IServiceProcess iServiceProcess;

    @Override
    @PostMapping(value = EndPointProcessApi.START_PROCESS_INSTANCE)
    public ResponseEntity iniProcessIntances(@RequestBody ProcessRequestDto requestDto, HttpServletRequest request) {
        ResponseBuilder res = ResponseBuilder.newBuilder();
        try {
            ProcessResponseDto responseDto = iServiceProcess.StartProcessInstance(requestDto, request);
            res.withResponse(responseDto);
            res.withStatus(HttpStatus.CREATED);
        } catch (WebClientException e) {
            res.withStatus(HttpStatus.BAD_REQUEST)
                    .withBusinessStatus(e.getCode())
                    .withMessage(e.getMessage())
                    .withTransactionState(TransactionState.FAIL);
        } catch (Exception e) {
            res.withStatus(HttpStatus.BAD_REQUEST)
                    .withBusinessStatus(BusinessException.codeCatchAllException)
                    .withMessage(e.getMessage())
                    .withTransactionState(TransactionState.FAIL);
        } finally {
            return res
                    .withPath(request.getRequestURI())
                    .buildResponse();
        }
    }

    @Override
    @GetMapping(value = EndPointProcessApi.LIST_ALL_TASK_DABOARDD)
    public ResponseEntity ListAllTaskByPotOwner(HttpServletRequest request) {
        ResponseBuilder res = ResponseBuilder.newBuilder();
        try {
            TaskResponseDto responseDto = iServiceProcess.ListAllTaskByPotOwner(request);
            res.withResponse(responseDto);
            res.withStatus(HttpStatus.OK);
        } catch (WebClientException e) {
            res.withStatus(HttpStatus.BAD_REQUEST)
                    .withBusinessStatus(e.getCode())
                    .withMessage(e.getMessage())
                    .withTransactionState(TransactionState.FAIL);
        } catch (Exception e) {
            res.withStatus(HttpStatus.BAD_REQUEST)
                    .withBusinessStatus(BusinessException.codeCatchAllException)
                    .withMessage(e.getMessage())
                    .withTransactionState(TransactionState.FAIL);
        } finally {
            return res
                    .withPath(request.getRequestURI())
                    .buildResponse();
        }
    }

    @Override
    @PostMapping(EndPointProcessApi.UPDATE_VARIABLES)
    public ResponseEntity actualizarvariables(@RequestBody ProcessRequestDto requestDto, HttpServletRequest request) {
        ResponseBuilder res = ResponseBuilder.newBuilder();
        try {
            Map<String, Object> responseDto = iServiceProcess.UpdateVar(requestDto, request);
            res.withResponse(responseDto);
            res.withStatus(HttpStatus.OK);
        } catch (WebClientException e) {
            res.withStatus(HttpStatus.BAD_REQUEST)
                    .withBusinessStatus(e.getCode())
                    .withMessage(e.getMessage())
                    .withTransactionState(TransactionState.FAIL);
        } catch (Exception e) {
            res.withStatus(HttpStatus.BAD_REQUEST)
                    .withBusinessStatus(BusinessException.codeCatchAllException)
                    .withMessage(e.getMessage())
                    .withTransactionState(TransactionState.FAIL);
        } finally {
            return res
                    .withPath(request.getRequestURI())
                    .buildResponse();
        }
    }

    @Override
    @PutMapping(EndPointProcessApi.MODIFY_STATUS_TASK)
    public ResponseEntity ModifyStatusTask(@RequestBody ProcessRequestDto requestDto, HttpServletRequest request) {
        ResponseBuilder res = ResponseBuilder.newBuilder();
        try {
            Map<String, Object> responseDto = iServiceProcess.modifyStatusTask(requestDto, request);
            res.withResponse(responseDto);
            res.withStatus(HttpStatus.OK);
        } catch (WebClientException e) {
            res.withStatus(HttpStatus.BAD_REQUEST)
                    .withBusinessStatus(e.getCode())
                    .withMessage(e.getMessage())
                    .withTransactionState(TransactionState.FAIL);
        } catch (Exception e) {
            res.withStatus(HttpStatus.BAD_REQUEST)
                    .withBusinessStatus(BusinessException.codeCatchAllException)
                    .withMessage(e.getMessage())
                    .withTransactionState(TransactionState.FAIL);
        } finally {
            return res
                    .withPath(request.getRequestURI())
                    .buildResponse();
        }
    }
}
