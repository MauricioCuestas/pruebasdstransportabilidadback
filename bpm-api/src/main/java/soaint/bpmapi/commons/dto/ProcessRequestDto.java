package soaint.bpmapi.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@ToString
public class ProcessRequestDto implements Serializable {

    private String containerId;
    private String processId;
    private String processInstance;
    private String taskId;
    private String taskStatus;
    private String processInstanceId;
    private UserDto ownerUser;
    private UserDto assignment;
    private ParametrosDto parametros;
    private SignalDto signal;
    private List<String> groups;
    private List<String> taskStates;
    private int page;
    private int pageSize;
    private int instanceStatus;
    private List<String> instanceStates;

    public ProcessRequestDto() {
        super();
        pageSize = -1; //lista todas por defecto
//		pageSize = 10;
        page=0; //pagina inicial por defecto

        //Carga lista completa de estados por defecto
        taskStates = new ArrayList<String>();
        taskStates.add("Created");
        taskStates.add("Ready");
        taskStates.add("Reserved");
        taskStates.add("InProgress");
        taskStates.add("Suspended");
        taskStates.add("Completed");
        taskStates.add("Failed");
        taskStates.add("Error");
        taskStates.add("Exited");
        taskStates.add("Obsolete");
        

        //Carga la lista completa de estados de las instancias por defecto.
        instanceStates = new ArrayList<String>();
        instanceStates.add("1");//active
        instanceStates.add("2");//completed
        instanceStates.add("3");//aborted
        
        
        
        
        
    }
    
    
    
    
    
    
    

}
