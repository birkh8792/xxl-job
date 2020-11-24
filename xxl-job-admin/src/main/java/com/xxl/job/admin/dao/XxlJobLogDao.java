package com.xxl.job.admin.dao;

import com.xxl.job.admin.core.model.XxlJobLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * job log
 * @author xuxueli 2016-1-12 18:03:06
 */
@Repository
public interface XxlJobLogDao extends JpaRepository<XxlJobLog, Long>, JpaSpecificationExecutor<XxlJobLog>
{

    /**
     * @function 自定义JPQL
     * @param ids
     */
    // 注意更新和删除是需要加事务的， 并且要加上 @Modify的注解
    @Modifying
    @Transactional
    @Query("delete from XxlJobLog s where s.id in (?1)")
    void clearLog(List<Long> ids);

    @Query("select s.id from XxlJobLog s where s.triggerCode=200 and s.handleCode=0 and s.triggerTime < :losedTime and s.executorAddress not in (select t from xx)")
    List<Long> findLostJobIds(@Param("losedTime") Date losedTime);

    @Query(nativeQuery = true,value = "SELECT "+
            "COUNT(handle_code) triggerDayCount,"+
            "SUM(CASE WHEN (trigger_code in (0, 200) and handle_code = 0) then 1 else 0 end) as triggerDayCountRunning,"+
            "SUM(CASE WHEN handle_code = 200 then 1 else 0 end) as triggerDayCountSuc"+
            "FROM xxl_job_log"+
            "WHERE trigger_time BETWEEN :todayFrom and :todayTo")
    Map<String, Object> findLogReport(@Param("todayFrom")Date todayFrom,@Param("todayTo")Date todayTo);

}
