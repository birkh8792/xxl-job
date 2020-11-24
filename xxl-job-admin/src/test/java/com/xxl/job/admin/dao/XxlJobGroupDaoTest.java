package com.xxl.job.admin.dao;

import com.xxl.job.admin.core.model.XxlJobGroup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class XxlJobGroupDaoTest {

    @Resource
    private XxlJobGroupDao xxlJobGroupDao;

    @Test
    public void test(){
        List<XxlJobGroup> list = xxlJobGroupDao.findAll();

        List<XxlJobGroup> list2 = xxlJobGroupDao.findByAddressType((byte)0);

        XxlJobGroup group = new XxlJobGroup();
        group.setAppName("setAppName");
        group.setTitle("setTitle");
        group.setAddressType((byte)0);
        group.setAddressList("setAddressList");
        group.setUpdateTime(new Date());

        xxlJobGroupDao.save(group);

        XxlJobGroup group2 = xxlJobGroupDao.getOne(group.getId());
        group2.setAppName("setAppName2");
        group2.setTitle("setTitle2");
        group2.setAddressType((byte)2);
        group2.setAddressList("setAddressList2");
        group2.setUpdateTime(new Date());

        xxlJobGroupDao.save(group2);

        xxlJobGroupDao.deleteById(group.getId());
    }

}
