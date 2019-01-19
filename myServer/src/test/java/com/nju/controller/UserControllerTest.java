package com.nju.controller;
import java.io.IOException;

import javax.annotation.Resource;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.nju.beans.User;
import com.nju.dao.IUserDao;
import com.nju.service.IUserService;
import com.nju.service.impl.UserServiceImpl;

import junit.framework.Assert;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试  
//@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:/spring-mvc.xml",
		                           "classpath*:/spring-mybatis.xml"}) //加载配置文件,这里写你自己的spring配置文件的存放目录
public class UserControllerTest {
	
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
//	@Autowired
//	protected WebApplicationContext wac;
//	private IUserService userService;
	@Autowired
	private UserController userController;
	
	private MockMvc mockMvc;
	
	@Before(value = "")
	public void setUp() {
		request = new MockHttpServletRequest();
		System.out.println("setup");
		request.setCharacterEncoding("UTF-8");
		response = new MockHttpServletResponse();
//		mockMvc = MockMvcBuilders.standaloneSetup(wac).build();
	}
	@Test
	public void testLogin() {
		int userId = 1;
		request = new MockHttpServletRequest();
		request.setCharacterEncoding("UTF-8");
		response = new MockHttpServletResponse();
		if (request == null) {
			System.out.println("nll");
		}
		request.setParameter("username", "yan");
		request.setParameter("password", "yan");
		
		try {
			userController.login(request, response);
			
			Assert.assertEquals("{login=success}",response.getContentAsString());
//			Assert.assertEquals(null,userController.login(request, response));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//	    ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("./user/login.do").param("username", "yan", "password","yan"));
//        MvcResult mvcResult = resultActions.andReturn();
//        String result = mvcResult.getResponse().getContentAsString();
//        System.out.println("result:"+result);
	    //	    Assert.assertEquals(null, obj);
//		Assert.assertEquals(user.getUserId().intValue(), userId);
//		public User getUserById(int userId); 
	}
}
