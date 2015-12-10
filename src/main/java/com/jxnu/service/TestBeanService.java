package com.jxnu.service;

import com.jxnu.model.TestBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestBeanService {

	public void add(TestBean testBean);
    public List<TestBean> findAll();
    public void delete(Integer id);
    public void update(@Param("testBean")TestBean testBean,@Param("id")int id);
    public TestBean login(@Param("name")String name, @Param("age")String age);

}
