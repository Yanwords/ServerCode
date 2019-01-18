package com.nju.dao;

import java.util.List;

import com.nju.beans.ScenicEvaluation;
import com.nju.beans.ScenicSpot;

public interface IScenicSpotDao {
    int deleteByPrimaryKey(Integer id);

    int insert(ScenicSpot record);

    int insertSelective(ScenicSpot record);

    ScenicSpot selectById(Integer id);

    int updateByPrimaryKeySelective(ScenicSpot record);

    int updateByPrimaryKey(ScenicSpot record);

	ScenicSpot selectByName(String scenicName);
	List<ScenicSpot> display();
	
	int insertScenicEvaluation(ScenicEvaluation record);
//	int deleteCustomer(Integer id);
}

