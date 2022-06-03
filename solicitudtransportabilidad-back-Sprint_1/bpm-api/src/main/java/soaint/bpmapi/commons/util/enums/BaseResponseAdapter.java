package soaint.bpmapi.commons.util.enums;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;


@Data
@NoArgsConstructor
public class BaseResponseAdapter<T> implements Serializable {

    private T body;
    private HttpStatus status;
    private String businessStatus;
    private String timeResponse;
    private String message;
    private String path;
    private TransactionState transactionState;

    public BaseResponseAdapter(T body, HttpStatus status, String httpBusinessStatus, String timeResponse, String message, String path, TransactionState transactionState) {
        this.body = body;
        this.status = status;
        this.businessStatus = httpBusinessStatus;
        this.timeResponse = timeResponse;
        this.message = message;
        this.path = path;
        this.transactionState = transactionState;
    }

}
