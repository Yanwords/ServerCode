package com.nju.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nju.beans.Friend;
import com.nju.beans.ShareExperience;
import com.nju.beans.TravelRecord;
import com.nju.beans.User;
import com.nju.dao.IUserDao;
import com.nju.service.IUserService;

@Service("userService")  
public class UserServiceImpl implements IUserService {  
    @Resource  
    private IUserDao userDao;  
    public User getUserById(int userId) {  
        return this.userDao.selectById(userId);  
    }
	public User getUserByName(String userName) {
		/**/
		User user = userDao.selectByName(userName);
		
		if(user == null){
			
		    return user;
		}
		else
		{
			System.out.println("UserService/username:"+user.getUserName()+"  password:"+user.getPassword());
		    return user;
		}
	}
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		if(id != null){
			return userDao.deleteByPrimaryKey(id);
		}
		return 0;
	}
	public int insert(User record) {
		// TODO Auto-generated method stub
		if(record != null){
		    return userDao.insert(record);
		}
		return 0;
	}
	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		if(record != null){
			System.out.println("userdao update:"+record.getUserName());
			return userDao.updateByPrimaryKey(record);
		}
		return 0;
	}
	public int updateByPrimaryKey(User record) {
		// TODO Auto-generated method stub
		if(record != null){
			System.out.println("userdao update:"+record.getUserName());
			return userDao.updateByPrimaryKey(record);
		}
		return 0;
	}
	public List<User> display() {
		// TODO Auto-generated method stub
		return userDao.display();
	}
	/*
	public int deleteCustomer(Integer id){
		return userDao.deleteCustomer(id);
	}
	*/
	public int insertTravelRecord(TravelRecord record) {
		// TODO Auto-generated method stub
		if(record != null){
		    return userDao.insertTravelRecord(record);
		}
		return 0;
	}
	public int insertShareExperience(ShareExperience record) {
		// TODO Auto-generated method stub
		if(record != null){
		    return userDao.insertShareExperience(record);
		}
		return 0;
	}
	public int addFriend(Friend record) {
		// TODO Auto-generated method stub
		if(record != null){
		    return userDao.addFriend(record);
		}
		return 0;
	}
} 

