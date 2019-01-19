package com.nju.dao;
import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.nju.beans.User;
import com.nju.service.impl.UserServiceImpl;

import junit.framework.Assert;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试  
@ContextConfiguration(locations = {"classpath*:/spring-mvc.xml",
		                           "classpath*:/spring-mybatis.xml"}) //加载配置文件,这里写你自己的spring配置文件的存放目录
public class IUserDaoTest {
	@Resource
	@Autowired
	private IUserDao userDao;
	
	@Test
	public void testGetUserById() {
		int userId = 1;
		User user = userDao.selectById(userId);
		Assert.assertEquals(user.getUserId().intValue(), userId);
//		public User getUserById(int userId); 
	}
}
