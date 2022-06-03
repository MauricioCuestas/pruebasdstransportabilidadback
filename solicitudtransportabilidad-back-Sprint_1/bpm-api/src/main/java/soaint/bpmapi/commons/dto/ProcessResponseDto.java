package soaint.bpmapi.commons.dto;

import java.util.List;

public class ProcessResponseDto {

    private String processInstanceId;
    private List<ContainerDto> containers;
    private ResponseDto response;

    public ProcessResponseDto() {
    }

    public ProcessResponseDto(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public List<ContainerDto> getContainers() {
        return containers;
    }

    public void setContainers(List<ContainerDto> containers) {
        this.containers = containers;
    }

    public ResponseDto getResponse() {
        return response;
    }

    public void setResponse(ResponseDto response) {
        this.response = response;
    }
}
