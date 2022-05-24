package soaint.bpmapi.commons.converter;

import soaint.bpmapi.commons.dto.TaskDto;
import soaint.bpmapi.commons.dto.TaskResponse;
import soaint.bpmapi.commons.dto.TaskResponseDto;
import soaint.bpmapi.commons.dto.TaskSummary;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskConverter {

    public static TaskResponseDto taskResponseToTaskResponseDto(TaskResponse taskResponse) {
        TaskResponseDto responseDto = new TaskResponseDto();
        List<TaskDto> taskDtos = new ArrayList<>();
        if (taskResponse != null && taskResponse.getTaskSummary() != null && !taskResponse.getTaskSummary().isEmpty()) {
            for (TaskSummary taskSummary : taskResponse.getTaskSummary()) {
                TaskDto dto = new TaskDto();
                dto.setTaskId(taskSummary.getTaskId());
                dto.setTaskName(taskSummary.getTaskName());
                dto.setTaskDescription(taskSummary.getTaskDescription());
                dto.setTaskStatus(getDescriptionTask(taskSummary.getTaskStatus()));
                dto.setTaskCreatedBy(taskSummary.getTaskCreatedBy());
                dto.setTaskActualOwner(taskSummary.getTaskActualOwner());
                long createdOn = taskSummary.getTaskCreatedOn().getJavaUtilDate().longValue();
                long activationTime = taskSummary.getTaskActivationTime().getJavaUtilDate().longValue();
                Date dateCreatedOn = new Date(createdOn);
                Date dateActivationTime = new Date(activationTime);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                dto.setTaskCreatedOn(sdf.format(dateCreatedOn));
                dto.setTaskActivationTime(sdf.format(dateActivationTime));
                dto.setContainerId(taskSummary.getTaskContainerId());
                dto.setTaskProcDefId(taskSummary.getTaskProcDefId());
                dto.setInstanceId(taskSummary.getTaskProcInstId().toString());
                taskDtos.add(dto);
            }
            responseDto.setTasks(taskDtos);
        }
        return responseDto;


    }

    public static String getDescriptionTask(String taskstatus) {
        if (taskstatus.equalsIgnoreCase("InProgress")) {
            taskstatus = "En Progreso";

        }
        if (taskstatus.equalsIgnoreCase("Reserved")) {
            taskstatus = "Reservado";

        }
        if (taskstatus.equalsIgnoreCase("Ready")) {
            taskstatus = "Listo";

        }


        return taskstatus;


    }

}
