package com.game.team3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.game.team3.mapper.UserInfoMapper;
import com.game.team3.util.JWTToken;
import com.game.team3.vo.UserInfoVO;

@Service
public class UserInfoService {
		
	@Autowired
	private UserInfoMapper uiMapper;
	@Autowired
	private JWTToken jwtToken;
	
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
	public UserInfoVO login(UserInfoVO user) {
		user = uiMapper.selectUserInfoByIdAndPwd(user);
		if(user!=null) {
			String token =jwtToken.getToken(user.getUiId());
			user.setToken(token);
			user.setUiId(token);
		}
		return user;
	}
}
