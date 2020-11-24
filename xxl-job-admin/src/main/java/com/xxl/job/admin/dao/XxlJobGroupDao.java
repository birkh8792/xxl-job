package com.xxl.job.admin.dao;

import com.xxl.job.admin.core.model.XxlJobGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xuxueli on 16/9/30.
 */
@Repository
public interface XxlJobGroupDao extends JpaRepository<XxlJobGroup, Integer>, JpaSpecificationExecutor<XxlJobGroup>
{

    @Query("select c from XxlJobGroup c where c.addressType=:addressType order by c.appName,c.title,c.id asc")
    List<XxlJobGroup> findByAddressType(@Param("addressType") byte addressType);

}
