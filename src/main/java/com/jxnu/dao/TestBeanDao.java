package com.jxnu.dao;

import java.util.List;
import com.jxnu.model.TestBean;
import org.apache.ibatis.annotations.Param;

public interface TestBeanDao {
	/**
	 * 添加数据
	 * @param testBean
	 */
	public void add(TestBean testBean);
	
	/**
	 * 查询所有数据
	 * @return
	 */
	public List<TestBean> findAll();

	/**
	 * 删除数据
	 * @return
	 */
	public void delete(Integer id);

	/**
	 * 修改数据
	 * @Param("testBean")TestBean testBean,@Param("id")int id
	 */
	public void update(@Param("testBean")TestBean testBean,@Param("id")int id);

    /**
     * 登录
     * @Param("name")String name, @Param("age")String age
     */
    public TestBean login(@Param("name")String name, @Param("age")String age);

}
