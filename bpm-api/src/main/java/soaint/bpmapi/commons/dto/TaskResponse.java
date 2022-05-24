
package soaint.bpmapi.commons.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TaskResponse {

    @SerializedName("task-summary")
    @Expose
    private List<TaskSummary> taskSummary = null;

    /**
     *
     */
    public TaskResponse() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the taskSummary
     */
    public List<TaskSummary> getTaskSummary() {
        return taskSummary;
    }

    /**
     * @param taskSummary the taskSummary to set
     */
    public void setTaskSummary(List<TaskSummary> taskSummary) {
        this.taskSummary = taskSummary;
    }

}
