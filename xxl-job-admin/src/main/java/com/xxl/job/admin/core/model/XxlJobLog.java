package com.xxl.job.admin.core.model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/** 
@program
@description
@author lichang 
@createDate 2020-11-17 14:29 
@version 1.0.0
*/
@Entity
@Table(name =  "xxl_job_log")
public class XxlJobLog
{
    @Id
    private Long id;

    /**
     * 执行器主键ID
     */
    @Column(name = "job_group")
    private Integer jobGroup;

    /**
     * 任务，主键ID
     */
    @Column(name = "job_id")
    private Integer jobId;

    /**
     * 执行器地址，本次执行的地址
     */
    @Column(name = "executor_address")
    private String executorAddress;

    /**
     * 执行器任务handler
     */
    @Column(name = "executor_handler")
    private String executorHandler;

    /**
     * 执行器任务参数
     */
    @Column(name = "executor_param")
    private String executorParam;

    /**
     * 执行器任务分片参数，格式如 1/2
     */
    @Column(name = "executor_sharding_param")
    private String executorShardingParam;

    /**
     * 失败重试次数
     */
    @Column(name = "executor_fail_retry_count")
    private Integer executorFailRetryCount;

    /**
     * 调度-时间
     */
    @Column(name = "trigger_time")
    private Date triggerTime;

    /**
     * 调度-结果
     */
    @Column(name = "trigger_code")
    private Integer triggerCode;

    /**
     * 调度-日志
     */
    @Column(name = "trigger_msg", columnDefinition = "TEXT")
    @Type(type = "text")
    private String triggerMsg;

    /**
     * 执行-时间
     */
    @Column(name = "handle_time")
    private Date handleTime;

    /**
     * 执行-状态
     */
    @Column(name = "handle_code")
    private Integer handleCode;

    /**
     * 执行-日志
     */
    @Column(name = "handle_msg", columnDefinition = "TEXT")
    @Type(type = "text")
    private String handleMsg;

    /**
     * 告警状态：0-默认、1-无需告警、2-告警成功、3-告警失败
     */
    @Column(name = "alarm_status")
    private Byte alarmStatus;

    public static final String COL_ID = "id";

    public static final String COL_JOB_GROUP = "job_group";

    public static final String COL_JOB_ID = "job_id";

    public static final String COL_EXECUTOR_ADDRESS = "executor_address";

    public static final String COL_EXECUTOR_HANDLER = "executor_handler";

    public static final String COL_EXECUTOR_PARAM = "executor_param";

    public static final String COL_EXECUTOR_SHARDING_PARAM = "executor_sharding_param";

    public static final String COL_EXECUTOR_FAIL_RETRY_COUNT = "executor_fail_retry_count";

    public static final String COL_TRIGGER_TIME = "trigger_time";

    public static final String COL_TRIGGER_CODE = "trigger_code";

    public static final String COL_TRIGGER_MSG = "trigger_msg";

    public static final String COL_HANDLE_TIME = "handle_time";

    public static final String COL_HANDLE_CODE = "handle_code";

    public static final String COL_HANDLE_MSG = "handle_msg";

    public static final String COL_ALARM_STATUS = "alarm_status";

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Integer getJobGroup()
    {
        return jobGroup;
    }

    public void setJobGroup(Integer jobGroup)
    {
        this.jobGroup = jobGroup;
    }

    public Integer getJobId()
    {
        return jobId;
    }

    public void setJobId(Integer jobId)
    {
        this.jobId = jobId;
    }

    public String getExecutorAddress()
    {
        return executorAddress;
    }

    public void setExecutorAddress(String executorAddress)
    {
        this.executorAddress = executorAddress;
    }

    public String getExecutorHandler()
    {
        return executorHandler;
    }

    public void setExecutorHandler(String executorHandler)
    {
        this.executorHandler = executorHandler;
    }

    public String getExecutorParam()
    {
        return executorParam;
    }

    public void setExecutorParam(String executorParam)
    {
        this.executorParam = executorParam;
    }

    public String getExecutorShardingParam()
    {
        return executorShardingParam;
    }

    public void setExecutorShardingParam(String executorShardingParam)
    {
        this.executorShardingParam = executorShardingParam;
    }

    public Integer getExecutorFailRetryCount()
    {
        return executorFailRetryCount;
    }

    public void setExecutorFailRetryCount(Integer executorFailRetryCount)
    {
        this.executorFailRetryCount = executorFailRetryCount;
    }

    public Date getTriggerTime()
    {
        return triggerTime;
    }

    public void setTriggerTime(Date triggerTime)
    {
        this.triggerTime = triggerTime;
    }

    public Integer getTriggerCode()
    {
        return triggerCode;
    }

    public void setTriggerCode(Integer triggerCode)
    {
        this.triggerCode = triggerCode;
    }

    public String getTriggerMsg()
    {
        return triggerMsg;
    }

    public void setTriggerMsg(String triggerMsg)
    {
        this.triggerMsg = triggerMsg;
    }

    public Date getHandleTime()
    {
        return handleTime;
    }

    public void setHandleTime(Date handleTime)
    {
        this.handleTime = handleTime;
    }

    public Integer getHandleCode()
    {
        return handleCode;
    }

    public void setHandleCode(Integer handleCode)
    {
        this.handleCode = handleCode;
    }

    public String getHandleMsg()
    {
        return handleMsg;
    }

    public void setHandleMsg(String handleMsg)
    {
        this.handleMsg = handleMsg;
    }

    public Byte getAlarmStatus()
    {
        return alarmStatus;
    }

    public void setAlarmStatus(Byte alarmStatus)
    {
        this.alarmStatus = alarmStatus;
    }
}