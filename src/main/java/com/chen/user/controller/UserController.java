package com.chen.user.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chen.constant.Constants;
import com.chen.user.bean.Man;
import com.chen.user.bean.UserBean;
import com.chen.user.bean.UserResBean;
import com.chen.user.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "获取用户信息列表", notes = "获取用户信息列表")
	@GetMapping("/user")
	public UserResBean getUserList() {
		UserResBean userResBean = new UserResBean();
		List<UserBean> users = userService.selectUserList();
		userResBean.setCode(Constants.CODE_SUCCESS).setMessage(Constants.MESSAGE_SUCCESS_SELECT).setUsers(users);
		return userResBean;
	}

	@PostMapping("/user")
	public UserResBean addUser(UserBean user) {
		UserResBean userResBean = new UserResBean();
		int flag = userService.insertUser(user);
		if (flag > 0) {
			userResBean.setCode(Constants.CODE_SUCCESS).setMessage(Constants.MESSAGE_SUCCESS_INSERT);
		} else {
			userResBean.setCode(Constants.CODE_FAILURE).setMessage(Constants.MESSAGE_FAILURE_INSERT);
		}
		return userResBean;
	}

	@PutMapping("/user")
	public UserResBean modifyUser(UserBean user) {
		UserResBean userResBean = new UserResBean();
		int flag = userService.updateUser(user);
		if (flag > 0) {
			userResBean.setCode(Constants.CODE_SUCCESS).setMessage(Constants.MESSAGE_SUCCESS_UPDATE);
		} else {
			userResBean.setCode(Constants.CODE_FAILURE).setMessage(Constants.MESSAGE_FAILURE_UPDATE);
		}
		return userResBean;
	}

	@DeleteMapping("/user/{id}")
	public UserResBean deleteUse(int id) {
		UserResBean userResBean = new UserResBean();
		int flag = userService.deleteUserById(id);
		if (flag > 0) {
			userResBean.setCode(Constants.CODE_SUCCESS).setMessage(Constants.MESSAGE_SUCCESS_DELETE);
		} else {
			userResBean.setCode(Constants.CODE_FAILURE).setMessage(Constants.MESSAGE_FAILURE_DELETE);
		}
		return userResBean;
	}

	@ApiOperation(value = "获取男人列表", notes = "获取男人列表")
	@GetMapping("/man")
	public UserResBean getManList() {
		UserResBean userResBean = new UserResBean();
		List<Man> mans = userService.selectManList();
		userResBean.setCode(Constants.CODE_SUCCESS).setMessage(Constants.MESSAGE_SUCCESS_SELECT).setMans(mans);
		return userResBean;
	}
	
	@GetMapping("/dic")
	public UserResBean getDicList() {
		UserResBean userResBean = new UserResBean();
		List<Map<String,String>> dics = userService.selectDicList();
		userResBean.setCode(Constants.CODE_SUCCESS).setMessage(Constants.MESSAGE_SUCCESS_SELECT).setDics(dics);
		return userResBean;
	}

}
