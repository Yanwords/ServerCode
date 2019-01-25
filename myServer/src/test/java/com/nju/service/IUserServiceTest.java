package com.nju.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.nju.beans.Permission;
import com.nju.beans.User;
import com.nju.service.IUserService;
import com.nju.service.impl.UserServiceImpl;

import junit.framework.Assert;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试  
@ContextConfiguration(locations = {"classpath*:/spring-mvc.xml",
		                           "classpath*:/spring-mybatis.xml"}) //加载配置文件,这里写你自己的spring配置文件的存放目录
public class IUserServiceTest {
	@Resource
	@Autowired
	private IUserService userService;
	
	@Test
	public void testGetUserById() {
		int userId = 1;
		User user = userService.getUserById(userId);
		Assert.assertEquals(user.getUserId().intValue(), userId);
//		public User getUserById(int userId); 
	}
	@Test
	public void testUserByName() {
		String userName = "yan";
		User user = userService.getUserByName(userName);
		Assert.assertEquals(user.getUserName(), userName);
	}
	
	@Test
	public void testInsertUser() {
		User user = new User();
		Permission permission = new Permission();
		user.setUserName("test");
		user.setPassword("test");
		user.setAge(23);
		user.setGender("男");
		user.setpId(1);
		permission.setpId(1);
		permission.setpName("USER");
		user.setPermission(permission);
		User temp = userService.getUserByName(user.getUserName());
		if (temp == null) {
			int result = userService.insert(user);
			Assert.assertEquals(1, result);
		}else {
			Assert.assertEquals(user.getUserName(), temp.getUserName());
		}
	}
}
