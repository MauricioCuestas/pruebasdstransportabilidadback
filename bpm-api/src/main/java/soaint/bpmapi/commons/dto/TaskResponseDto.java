package soaint.bpmapi.commons.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TaskResponseDto {

    private List<TaskDto> tasks;

}
