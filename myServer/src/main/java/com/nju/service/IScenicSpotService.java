package com.nju.service;

import java.util.List;

import com.nju.beans.ScenicEvaluation;
import com.nju.beans.ScenicSpot;

public interface IScenicSpotService {
	 public ScenicSpot getUserById(int scenicId); 

	 public ScenicSpot getScenicByName(String scenicName);
	 
	 public int deleteByPrimaryKey(Integer id);

	 public int insert(ScenicSpot record);

	 public int insertSelective(ScenicSpot record);

//	    User selectById(Integer id);

	 public int updateByPrimaryKeySelective(ScenicSpot record);

	 public int updateByPrimaryKey(ScenicSpot record);
	 
	 public List<ScenicSpot> display();

	 public int insertScenicEvaluation(ScenicEvaluation record);
	 //public int deleteCustomer(Integer id);
	 
//		User selectByName(String userName);
}

