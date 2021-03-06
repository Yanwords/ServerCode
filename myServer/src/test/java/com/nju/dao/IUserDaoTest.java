package com.nju.dao;
import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.nju.beans.Permission;
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
	
	@Test
	public void testGetUserByName() {
		String userName = "yan";
		User user = userDao.selectByName(userName);
		Assert.assertEquals(user.getUserName(), userName);
	}
	
	@Test
	public void testInserUser() {
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
	    User temp = userDao.selectByName(user.getUserName());
		if (temp == null) {
			int result = userDao.insert(user);
			Assert.assertEquals(1, result);
		}else {
			Assert.assertEquals(user.getUserName(), temp.getUserName());
		}		
	}

	@Test
	public void testDeleteById() {
		int userId = 0;
		String userName = "test";
		User user = userDao.selectByName(userName);
		if (user == null) {
			Assert.assertEquals(0, userId);
		}else {
			userId = user.getUserId();
			int result = userDao.deleteByPrimaryKey(userId);
			Assert.assertEquals(1, result);
		}
	}
}
