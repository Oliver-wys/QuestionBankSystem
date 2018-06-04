package qbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import qbs.domain.User;
import qbs.service.IUserService;

@RestController
@RequestMapping("/main")
public class UserController {

	@Autowired
	IUserService userService;

	@RequestMapping(method = RequestMethod.GET, value = "/manager/allusers")
	@ResponseBody
	public List<User> allUsers() {
		return userService.findAllUser();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/manager/adduser", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addUser(@RequestBody User user) {
		System.out.println("插入的用户信息：" + user);
		userService.addUser(user);
	}
	
	/*
	 * 删除单个用户
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/manager/deluser")
	public void delUser(@RequestParam("id") Long id) {
		System.out.println("接收的id：" + id);
		userService.delUser(id);
	}
	
	/*
	 * 批量删除用户
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/manager/delusers", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delUsers(@RequestBody List<Long> ids) {
		System.out.println("接收的id：" + ids);
		userService.delUsers(ids);
	}
	
	/*
	 * 用户修改个人信息
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/user/changeinf", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateInf(@RequestBody User user) {
		System.out.println("插入的用户信息：" + user);
		userService.updateInf(user);
	}

}
