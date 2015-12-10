package com.jxnu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jxnu.model.TestBean;
import com.jxnu.service.TestBeanService;

@Controller
@RequestMapping("/test")
public class TestBeanController{
	
	@Autowired
	TestBeanService testBeanService;
	
	//正常spring mvc视图解析样例
	@RequestMapping("/testBean")
	public ModelAndView testBean(){
		
		TestBean testBean = new TestBean();
		testBean.setName("zby");
		testBean.setAge("15");
		
		testBeanService.add(testBean);
		
		
		ModelAndView view = new ModelAndView();
		view.addObject(testBean);
		view.setViewName("testPage/testJsp");
		
		return view;
	}

    //REST风格测试样例
    @RequestMapping("/restTest/{id}")
    @ResponseBody
    public TestBean restTest(@PathVariable("id") Integer id){

        System.out.println(id);

        TestBean testBean = new TestBean();
        testBean.setName("zby");
        testBean.setAge("22");

        return testBean;
    }

	//Json数据测试样例
	@RequestMapping("/jsonTest")
	@ResponseBody
	public List<TestBean> jsonTest(@RequestParam Map<String, String> data){
		List<TestBean> testBeans= new ArrayList<TestBean>();

		TestBean testBean = new TestBean();
		testBean.setName("zby");
		testBean.setAge("22");

		testBeans.add(testBean);
		return testBeans;
	}

	
}
