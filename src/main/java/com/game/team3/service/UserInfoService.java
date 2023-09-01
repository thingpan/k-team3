package com.game.team3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.team3.mapper.UserInfoMapper;
import com.game.team3.vo.UserInfoVO;

@Service
public class UserInfoService {
		
	@Autowired
	private UserInfoMapper uiMapper;
	
	public List<UserInfoVO> getUserInfos(UserInfoVO user){
		return uiMapper.selectUserInfos(user);
	}
	public UserInfoVO getUserInfo(int uiNum) {
		return uiMapper.selectUserInfo(uiNum);
	}
	public int getinsertUserInfo(UserInfoVO user) {
		return uiMapper.insertUserInfo(user);
	}
	public int getupdateUserInfo(UserInfoVO user) {
		return uiMapper.updateUserInfo(user);
	}
	public int getdeleteUserInfo(int uiNum) {
		return uiMapper.deleteUserInfo(uiNum);
	}
}
