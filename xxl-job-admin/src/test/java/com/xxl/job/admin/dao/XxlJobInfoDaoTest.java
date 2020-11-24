package com.xxl.job.admin.dao;

import com.xxl.job.admin.core.model.XxlJobInfo;
import com.xxl.job.admin.core.scheduler.MisfireStrategyEnum;
import com.xxl.job.admin.core.scheduler.ScheduleTypeEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class XxlJobInfoDaoTest {
	
	@Resource
	private XxlJobInfoDao xxlJobInfoDao;
	
	@Test
	public void pageList(){

		int start = 0;
		int length = 20;
		int jobGroup = 0;
		int triggerStatus = -1;
		String jobDesc = null;
		String executorHandler = null;
		String author = null;

		int page = (start / length) + 1 ;
		Pageable pageable = PageRequest.of(page-1, length);
		Specification specification = new Specification<XxlJobInfo>() {
			@Override
			public Predicate toPredicate(Root<XxlJobInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				if (jobGroup > 0) {
					predicates.add(cb.equal(root.get("job_group"), jobGroup));
				}
				if (triggerStatus >= 0) {
					predicates.add(cb.equal(root.get("trigger_status"), triggerStatus));
				}
				// 判断传入的值是否为空
				if (!"".equals(jobDesc)) {
					predicates.add(cb.like(root.get("job_desc"), "%" + jobDesc + "%"));
				}
				if (!"".equals(executorHandler)) {
					predicates.add(cb.like(root.get("executor_handler"), "%" + executorHandler + "%"));
				}
				if (!"".equals(author)) {
					predicates.add(cb.like(root.get("author"), "%" + author + "%"));
				}
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		};
		Page pageVo = xxlJobInfoDao.findAll(specification, pageable);

		//List<XxlJobInfo> list = xxlJobInfoDao.pageList(0, 20, 0, -1, null, null, null);
		//int list_count = xxlJobInfoDao.pageListCount(0, 20, 0, -1, null, null, null);

		// page list
		List<XxlJobInfo> list = pageVo.getContent();
		long list_count = pageVo.getTotalElements();

		System.out.println(list);
		System.out.println(list_count);

		List<XxlJobInfo> list2 = xxlJobInfoDao.getJobsByGroup(1);
	}
	
	@Test
	public void save_load(){
		XxlJobInfo info = new XxlJobInfo();
		info.setJobGroup(1);
		info.setJobDesc("desc");
		info.setAuthor("setAuthor");
		info.setAlarmEmail("setAlarmEmail");
		info.setScheduleType(ScheduleTypeEnum.FIX_RATE.name());
		info.setScheduleConf(String.valueOf(33));
		info.setMisfireStrategy(MisfireStrategyEnum.DO_NOTHING.name());
		info.setExecutorRouteStrategy("setExecutorRouteStrategy");
		info.setExecutorHandler("setExecutorHandler");
		info.setExecutorParam("setExecutorParam");
		info.setExecutorBlockStrategy("setExecutorBlockStrategy");
		info.setGlueType("setGlueType");
		info.setGlueSource("setGlueSource");
		info.setGlueRemark("setGlueRemark");
		info.setChildJobid("1");

		info.setAddTime(new Date());
		info.setUpdateTime(new Date());
		info.setGlueUpdatetime(new Date());

		XxlJobInfo save = xxlJobInfoDao.save(info);

		XxlJobInfo info2 = xxlJobInfoDao.getOne(info.getId());
		info.setScheduleType(ScheduleTypeEnum.FIX_RATE.name());
		info.setScheduleConf(String.valueOf(44));
		info.setMisfireStrategy(MisfireStrategyEnum.FIRE_ONCE_NOW.name());
		info2.setJobDesc("desc2");
		info2.setAuthor("setAuthor2");
		info2.setAlarmEmail("setAlarmEmail2");
		info2.setExecutorRouteStrategy("setExecutorRouteStrategy2");
		info2.setExecutorHandler("setExecutorHandler2");
		info2.setExecutorParam("setExecutorParam2");
		info2.setExecutorBlockStrategy("setExecutorBlockStrategy2");
		info2.setGlueType("setGlueType2");
		info2.setGlueSource("setGlueSource2");
		info2.setGlueRemark("setGlueRemark2");
		info2.setGlueUpdatetime(new Date());
		info2.setChildJobid("1");

		info2.setUpdateTime(new Date());
		XxlJobInfo save2 = xxlJobInfoDao.save(info2);

		xxlJobInfoDao.deleteById(info2.getId());

		List<XxlJobInfo> list2 = xxlJobInfoDao.getJobsByGroup(1);

		long ret3 = xxlJobInfoDao.count();

	}

}
