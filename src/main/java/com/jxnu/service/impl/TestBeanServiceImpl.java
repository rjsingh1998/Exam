package com.jxnu.service.impl;

import java.util.List;

import com.jxnu.dao.TestBeanDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jxnu.model.TestBean;
import com.jxnu.service.TestBeanService;

@Service
@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
public class TestBeanServiceImpl implements TestBeanService{
	
	@Autowired
    TestBeanDao testBeanDao;

    @Override
	public void add(TestBean testBean) {
		// TODO Auto-generated method stub
		testBeanDao.add(testBean);
		
	}

    @Override
	public List<TestBean> findAll(){
		return testBeanDao.findAll();
	}

    @Override
    public void delete(Integer id) {
        testBeanDao.delete(id);
    }

    @Override
    public TestBean login(@Param("name") String name, @Param("age") String age) {
        return testBeanDao.login(name,age);
    }

    @Override
    public void update(@Param("testBean") TestBean testBean, @Param("id") int id) {
        testBeanDao.update(testBean,id);
    }
}
