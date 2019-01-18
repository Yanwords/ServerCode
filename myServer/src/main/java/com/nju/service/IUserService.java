package com.nju.service;

import java.util.List;

import com.nju.beans.Friend;
import com.nju.beans.ShareExperience;
import com.nju.beans.TravelRecord;
import com.nju.beans.User;

public interface IUserService {
	 public User getUserById(int userId); 

	 public User getUserByName(String userName);
	 
	 public int deleteByPrimaryKey(Integer id);

	 public int insert(User record);

	 public int insertSelective(User record);

//	    User selectById(Integer id);

	 public int updateByPrimaryKeySelective(User record);

	 public int updateByPrimaryKey(User record);
	 
	 public List<User> display();
     
	 public int insertTravelRecord(TravelRecord record);
	 
	 public int insertShareExperience(ShareExperience record);
	 
	 public int addFriend(Friend record);
	 //public int deleteCustomer(Integer id);
	 
//		User selectByName(String userName);
}
