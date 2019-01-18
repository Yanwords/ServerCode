package com.nju.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nju.beans.ScenicEvaluation;
import com.nju.beans.ScenicSpot;
import com.nju.dao.IScenicSpotDao;
import com.nju.service.IScenicSpotService;

@Service("scenicSpotService")  
public class ScenicSpotServiceImpl implements IScenicSpotService {  
    @Resource  
    private IScenicSpotDao scenicDao;  
    public ScenicSpot getUserById(int scenicId) {  
        return this.scenicDao.selectById(scenicId);  
    }
	public ScenicSpot getScenicByName(String scenicName) {
		/**/
		ScenicSpot scenic = scenicDao.selectByName(scenicName);
		
		if(scenic == null){
			
		    return scenic;
		}
		else
		{
			System.out.println("scenicService/scenicname:"+scenic.getScenicName()+"scenicService/scenicInfo:"+scenic.getScenicInfo());
		    return scenic;
		}
	}
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		if(id != null){
			return scenicDao.deleteByPrimaryKey(id);
		}
		return 0;
	}
	public int insert(ScenicSpot record) {
		// TODO Auto-generated method stub
		if(record != null){
		    return scenicDao.insert(record);
		}
		return 0;
	}
	public int insertSelective(ScenicSpot record) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int updateByPrimaryKeySelective(ScenicSpot record) {
		// TODO Auto-generated method stub
		if(record != null){
			System.out.println("scenicdao update:"+record.getScenicName());
			return scenicDao.updateByPrimaryKey(record);
		}
		return 0;
	}
	public int updateByPrimaryKey(ScenicSpot record) {
		// TODO Auto-generated method stub
		if(record != null){
			System.out.println("scenicdao update:"+record.getScenicName());
			return scenicDao.updateByPrimaryKey(record);
		}
		return 0;
	}
	public List<ScenicSpot> display() {
		// TODO Auto-generated method stub
		return scenicDao.display();
	}
	public int insertScenicEvaluation(ScenicEvaluation record) {
		// TODO Auto-generated method stub
		if(record != null){
		    return scenicDao.insertScenicEvaluation(record);
		}
		return 0;
	}
	
} 
