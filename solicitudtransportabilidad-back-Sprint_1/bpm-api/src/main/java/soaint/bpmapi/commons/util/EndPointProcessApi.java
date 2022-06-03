package soaint.bpmapi.commons.util;

public interface EndPointProcessApi {
    String PROCESS_API_V0 = "/soaint-toolbox-eis/bpm-api/v1/processes";
    String START_PROCESS_INSTANCE = "/startProcess";
    String LIST_ALL_TASK_DABOARDD = "/task/dasboard";
    String AUTENTICATION_PROCESS = "/autenticationProcess";
    String MODIFY_STATUS_TASK = "/task/modifyStatus";
    String ABORT_PROCESS_INSTANCE = "/abortProcess";
    String UPDATE_VARIABLES = "/updatevariables";
    String WACTH_PROCESS = "/verproceso";
    String GET_ID_TASK = "/getidtask";
    String GET_VAR_PROCESS ="/getvarprocess";

}
