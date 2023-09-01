package com.game.team3.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.game.team3.service.UserInfoService;
import com.game.team3.util.JWTToken;
import com.game.team3.vo.UserInfoVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin("*")
@Slf4j
public class UserInfoController {
	@Autowired
	private UserInfoService uiService;
	@Autowired
	private JWTToken jwtToken;

	@GetMapping("/expire")
	public Long getexpire() {
		return jwtToken.getJwtTokenExpire();
	}

	@GetMapping("/user-infos")
	public List<UserInfoVO> getUserInfos(HttpServletRequest req, UserInfoVO user) {
		String token = req.getHeader(HttpHeaders.AUTHORIZATION);
		jwtToken.getUserIdFromToken(token);
		return uiService.getUserInfos(user);
	}

	@GetMapping("/user-infos/{uiNum}")
	public UserInfoVO getUserInfo(@PathVariable int uiNum) {
		return uiService.getUserInfo(uiNum);

	}

	@PostMapping("/login")
	public UserInfoVO login(@RequestBody UserInfoVO user) {
		return uiService.login(user);
	}

	@PostMapping("/user-infos")
	public int insertUserInfo(@RequestBody UserInfoVO user) {
		return uiService.getinsertUserInfo(user);
	}

	@PutMapping("/user-infos")
	public int updateUserInfo(UserInfoVO user) {
		return uiService.getupdateUserInfo(user);
	}

	@DeleteMapping("/user-infos/{uiNum}")
	public int deleteUserInfo(@PathVariable int uiNum) {
		return uiService.getdeleteUserInfo(uiNum);
	}

}
