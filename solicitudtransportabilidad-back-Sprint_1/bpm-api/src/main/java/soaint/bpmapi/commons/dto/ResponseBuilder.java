package soaint.bpmapi.commons.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import soaint.bpmapi.commons.util.enums.TransactionState;

import java.time.LocalDateTime;

public class ResponseBuilder<T> {

    private T response;
    private HttpStatus httpStatus;
    private String httpBusinessStatus;
    private LocalDateTime timeResponse;
    private String path;
    private String message;
    private TransactionState state;

    private ResponseBuilder() {
        this.httpBusinessStatus = "";
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getTimeResponse() {
        return timeResponse;
    }

    public static ResponseBuilder newBuilder() {
        return new ResponseBuilder();
    }

    public ResponseBuilder withResponse(T response) {
        this.response = response;
        this.timeResponse = LocalDateTime.now();
        return this;
    }

    public ResponseBuilder withPath(String path) {
        this.path = path;
        this.timeResponse = LocalDateTime.now();
        return this;
    }

    public ResponseBuilder withStatus(HttpStatus status) {
        this.httpStatus = status;
        return this;
    }

    public ResponseBuilder withBusinessStatus(String status) {
        this.httpBusinessStatus = status;
        return this;
    }

    public ResponseBuilder withMessage(String message) {
        this.message = message;
        this.timeResponse = LocalDateTime.now();
        return this;
    }

    public ResponseBuilder withTransactionState(TransactionState state) {
        this.state = state;
        this.timeResponse = LocalDateTime.now();
        return this;
    }

    public ResponseEntity buildResponse() {
        BaseResponse base = new BaseResponse(this.response, this.httpStatus, this.httpBusinessStatus, this.timeResponse, this.message, this.path, this.state);
        return new ResponseEntity(base, this.httpStatus);
    }

    public BaseResponse buildSimpleResponse() {
        return new BaseResponse(this.response, this.httpStatus, this.httpBusinessStatus, this.timeResponse, this.message, this.path, this.state);
    }
}
