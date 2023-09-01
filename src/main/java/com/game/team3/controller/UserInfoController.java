package com.game.team3.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.game.team3.service.UserInfoService;
import com.game.team3.vo.UserInfoVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@Slf4j
public class UserInfoController {
	@Autowired
	private UserInfoService uiService;
	
	@GetMapping("/user-infos")
	public List<UserInfoVO> getUserInfos(UserInfoVO user){
		return uiService.getUserInfos(user);
	}
	@GetMapping("/user-infos/{uiNum}")
	public UserInfoVO getUserInfo(@PathVariable int uiNum) {
		return uiService.getUserInfo(uiNum);
	}
	@PostMapping("/user-infos")
	public int insertUserInfo(@RequestBody UserInfoVO user) {
		return uiService.getinsertUserInfo( user);
	}
	@PostMapping("/user-infos")
	public int updateUserInfo(UserInfoVO user) {
		return uiService.getupdateUserInfo( user);
	}
	@PostMapping("/user-infos/{uiNum}")
	public int deleteUserInfo(@PathVariable int uiNum) {
		return uiService.getdeleteUserInfo(uiNum);
	}
	@PostMapping("/user-infos/{uiNum}")
	public int deleteUserInfo(@PathVariable int uiNum) {
		return uiService.getdeleteUserInfo(uiNum);
	}
}
