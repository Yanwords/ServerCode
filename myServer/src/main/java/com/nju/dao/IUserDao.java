package com.nju.dao;

import java.util.List;

import com.nju.beans.Friend;
import com.nju.beans.ShareExperience;
import com.nju.beans.TravelRecord;
import com.nju.beans.User;

public interface IUserDao {
	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	User selectById(Integer id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	User selectByName(String userName);

	List<User> display();

	List<Friend> friend(Integer id);

	int removeFriend(Friend friend);

	int insertTravelRecord(TravelRecord record);

	int insertShareExperience(ShareExperience record);

	int addFriend(Friend record);
//	int deleteCustomer(Integer id);
}
