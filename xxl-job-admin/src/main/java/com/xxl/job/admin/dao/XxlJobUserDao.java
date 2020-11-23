package com.xxl.job.admin.dao;

import com.xxl.job.admin.core.model.XxlJobUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author xuxueli 2019-05-04 16:44:59
 */
@Repository
public interface XxlJobUserDao extends JpaRepository<XxlJobUser, Integer>, JpaSpecificationExecutor<XxlJobUser>
{

	XxlJobUser findByUsername(String username);

}
