package com.xxl.job.admin.core.model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/** 
@program
@description
@author lichang 
@createDate 2020-11-17 14:29 
@version 1.0.0
*/ 
@Entity
@Table(name = "xxl_job_group")
public class XxlJobGroup
{
    @Id
    private Integer id;

    /**
     * 执行器AppName
     */
    @Column(name = "app_name")
    private String appName;

    /**
     * 执行器名称
     */
    @Column(name = "title")
    private String title;

    /**
     * 执行器地址类型：0=自动注册、1=手动录入
     */
    @Column(name = "address_type")
    private Byte addressType;

    /**
     * 执行器地址列表，多地址逗号分隔
     */
    @Column(name = "address_list", columnDefinition = "LONGTEXT")
    @Type(type = "text")
    private String addressList;

    @Column(name = "update_time")
    private Date updateTime;

    @Transient
    // registry list
    private List<String> registryList;  // 执行器地址列表(系统注册)
    public List<String> getRegistryList() {
        if (addressList!=null && addressList.trim().length()>0) {
            registryList = new ArrayList<String>(Arrays.asList(addressList.split(",")));
        }
        return registryList;
    }

    public static final String COL_ID = "id";

    public static final String COL_APP_NAME = "app_name";

    public static final String COL_TITLE = "title";

    public static final String COL_ADDRESS_TYPE = "address_type";

    public static final String COL_ADDRESS_LIST = "address_list";

    public static final String COL_UPDATE_TIME = "update_time";

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getAppName()
    {
        return appName;
    }

    public void setAppName(String appName)
    {
        this.appName = appName;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Byte getAddressType()
    {
        return addressType;
    }

    public void setAddressType(Byte addressType)
    {
        this.addressType = addressType;
    }

    public String getAddressList()
    {
        return addressList;
    }

    public void setAddressList(String addressList)
    {
        this.addressList = addressList;
    }

    public Date getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }
}