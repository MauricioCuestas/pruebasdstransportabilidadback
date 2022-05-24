package soaint.bpmapi.commons.exception.webClient;

import java.io.PrintWriter;
import java.io.StringWriter;

public class WebClientException extends  Exception{
    private  static final long serialVersionUID = 1L;
    private String code;
    private String message;
    public WebClientException(String message){
        super(message);
    }

    public WebClientException(String code, String message){
        super(message);
        this.code = code;
        this.message = message;
    }

    public WebClientException(String code, Exception stack){
        StringWriter errors = new StringWriter();
        stack.printStackTrace(new PrintWriter(errors));
        this.message = errors.toString();
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
