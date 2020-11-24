package com.xxl.job.admin.dao;

import com.xxl.job.admin.core.model.XxlJobInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * job info
 * @author xuxueli 2016-1-12 18:03:45
 */
@Repository
public interface XxlJobInfoDao extends JpaRepository<XxlJobInfo, Integer>, JpaSpecificationExecutor<XxlJobInfo>
{

    //@Query("select c from XxlJobInfo c where c.triggerStatus=1 and c.triggerNextTime <=:maxNextTime order by c.id asc limit :pagesize")
    @Query(nativeQuery = true,value = "select * from xxl_job_info c where c.trigger_status=1 and c.trigger_next_time <=:maxNextTime order by c.id asc limit :pagesize ")
    List<XxlJobInfo> scheduleJobQuery(@Param("maxNextTime") long maxNextTime, @Param("pagesize") int pagesize );

    @Query("select c from XxlJobInfo c where c.jobGroup=:jobGroup")
    List<XxlJobInfo> getJobsByGroup(@Param("jobGroup") int jobGroup);

    @Query(" select count(t) from XxlJobInfo t where t.jobGroup = :jobGroup")
    Integer findCountByJobGroup(@Param("jobGroup") Integer jobGroup);

}
