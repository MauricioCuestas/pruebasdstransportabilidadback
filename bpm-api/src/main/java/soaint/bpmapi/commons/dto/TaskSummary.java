
package soaint.bpmapi.commons.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TaskSummary {

    @SerializedName("task-id")
    @Expose
    private Integer taskId;

    @SerializedName("task-name")
    @Expose
    private String taskName;

    @SerializedName("task-subject")
    @Expose
    private Object taskSubject;

    @SerializedName("task-description")
    @Expose
    private String taskDescription;

    @SerializedName("task-status")
    @Expose
    private String taskStatus;

    @SerializedName("task-priority")
    @Expose
    private Integer taskPriority;

    @SerializedName("task-is-skipable")
    @Expose
    private Object taskIsSkipable;

    @SerializedName("task-actual-owner")
    @Expose
    private String taskActualOwner;

    @SerializedName("task-created-by")
    @Expose
    private String taskCreatedBy;

    @SerializedName("task-created-on")
    @Expose
    private Timestamp taskCreatedOn;

    @SerializedName("task-activation-time")
    @Expose
    private Timestamp taskActivationTime;

    @SerializedName("task-expiration-time")
    @Expose
    private Object taskExpirationTime;

    @SerializedName("task-proc-inst-id")
    @Expose
    private Integer taskProcInstId;

    @SerializedName("task-process-instance-id")
    @Expose
    private Integer taskProcessInstanceId;

    @SerializedName("task-proc-def-id")
    @Expose
    private String taskProcDefId;

    @SerializedName("task-process-id")
    @Expose
    private String taskProcessId;

    @SerializedName("task-container-id")
    @Expose
    private String taskContainerId;

    @SerializedName("task-parent-id")
    @Expose
    private Integer taskParentId;

    /**
     *
     */
    public TaskSummary() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the taskId
     */
    public Integer getTaskId() {
        return taskId;
    }

    /**
     * @param taskId the taskId to set
     */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    /**
     * @return the taskName
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * @param taskName the taskName to set
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * @return the taskSubject
     */
    public Object getTaskSubject() {
        return taskSubject;
    }

    /**
     * @param taskSubject the taskSubject to set
     */
    public void setTaskSubject(Object taskSubject) {
        this.taskSubject = taskSubject;
    }

    /**
     * @return the taskDescription
     */
    public String getTaskDescription() {
        return taskDescription;
    }

    /**
     * @param taskDescription the taskDescription to set
     */
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    /**
     * @return the taskStatus
     */
    public String getTaskStatus() {
        return taskStatus;
    }

    /**
     * @param taskStatus the taskStatus to set
     */
    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    /**
     * @return the taskPriority
     */
    public Integer getTaskPriority() {
        return taskPriority;
    }

    /**
     * @param taskPriority the taskPriority to set
     */
    public void setTaskPriority(Integer taskPriority) {
        this.taskPriority = taskPriority;
    }

    /**
     * @return the taskIsSkipable
     */
    public Object getTaskIsSkipable() {
        return taskIsSkipable;
    }

    /**
     * @param taskIsSkipable the taskIsSkipable to set
     */
    public void setTaskIsSkipable(Object taskIsSkipable) {
        this.taskIsSkipable = taskIsSkipable;
    }

    /**
     * @return the taskActualOwner
     */
    public String getTaskActualOwner() {
        return taskActualOwner;
    }

    /**
     * @param taskActualOwner the taskActualOwner to set
     */
    public void setTaskActualOwner(String taskActualOwner) {
        this.taskActualOwner = taskActualOwner;
    }

    /**
     * @return the taskCreatedBy
     */
    public String getTaskCreatedBy() {
        return taskCreatedBy;
    }

    /**
     * @param taskCreatedBy the taskCreatedBy to set
     */
    public void setTaskCreatedBy(String taskCreatedBy) {
        this.taskCreatedBy = taskCreatedBy;
    }

    /**
     * @return the taskCreatedOn
     */
    public Timestamp getTaskCreatedOn() {
        return taskCreatedOn;
    }

    /**
     * @param taskCreatedOn the taskCreatedOn to set
     */
    public void setTaskCreatedOn(Timestamp taskCreatedOn) {
        this.taskCreatedOn = taskCreatedOn;
    }

    /**
     * @return the taskActivationTime
     */
    public Timestamp getTaskActivationTime() {
        return taskActivationTime;
    }

    /**
     * @param taskActivationTime the taskActivationTime to set
     */
    public void setTaskActivationTime(Timestamp taskActivationTime) {
        this.taskActivationTime = taskActivationTime;
    }

    /**
     * @return the taskExpirationTime
     */
    public Object getTaskExpirationTime() {
        return taskExpirationTime;
    }

    /**
     * @param taskExpirationTime the taskExpirationTime to set
     */
    public void setTaskExpirationTime(Object taskExpirationTime) {
        this.taskExpirationTime = taskExpirationTime;
    }

    /**
     * @return the taskProcInstId
     */
    public Integer getTaskProcInstId() {
        return taskProcInstId;
    }

    /**
     * @param taskProcInstId the taskProcInstId to set
     */
    public void setTaskProcInstId(Integer taskProcInstId) {
        this.taskProcInstId = taskProcInstId;
    }

    /**
     * @return the taskProcDefId
     */
    public String getTaskProcDefId() {
        return taskProcDefId;
    }

    /**
     * @param taskProcDefId the taskProcDefId to set
     */
    public void setTaskProcDefId(String taskProcDefId) {
        this.taskProcDefId = taskProcDefId;
    }

    /**
     * @return the taskContainerId
     */
    public String getTaskContainerId() {
        return taskContainerId;
    }

    /**
     * @param taskContainerId the taskContainerId to set
     */
    public void setTaskContainerId(String taskContainerId) {
        this.taskContainerId = taskContainerId;
    }

    /**
     * @return the taskParentId
     */
    public Integer getTaskParentId() {
        return taskParentId;
    }

    /**
     * @param taskParentId the taskParentId to set
     */
    public void setTaskParentId(Integer taskParentId) {
        this.taskParentId = taskParentId;
    }

    /**
     * @return the taskProcessInstanceId
     */
    public Integer getTaskProcessInstanceId() {
        return taskProcessInstanceId;
    }

    /**
     * @param taskProcessInstanceId the taskProcessInstanceId to set
     */
    public void setTaskProcessInstanceId(Integer taskProcessInstanceId) {
        this.taskProcessInstanceId = taskProcessInstanceId;
    }

    /**
     * @return the taskProcessId
     */
    public String getTaskProcessId() {
        return taskProcessId;
    }

    /**
     * @param taskProcessId the taskProcessId to set
     */
    public void setTaskProcessId(String taskProcessId) {
        this.taskProcessId = taskProcessId;
    }

}
