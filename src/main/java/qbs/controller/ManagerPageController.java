package qbs.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import qbs.config.User;
import qbs.service.IUserService;

@Controller
@RequestMapping("/main")
public class ManagerPageController {

	@Autowired
	IUserService userService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/manager")
	public String managerLogin(Model model){
		System.out.println("管理员");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User secuser = (User)auth.getPrincipal();
		model.addAttribute("curuser",userService.findUserByAccount(secuser.getUsername()));
		return "manager";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/manager/changepassword", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public int changePassword(@RequestBody Map<String, String> password){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User)auth.getPrincipal();
//		password.put("userpassword", user.getPassword());
		password.put("useraccount", user.getUsername());
		System.out.println("password:" + password);
		int inf = userService.changePassword(password);
		System.out.println("返回的数据：" + inf);
		return inf;
	}
	
	
	
//	@RequestMapping(method = RequestMethod.GET, value = "/manager/allusers")
//	@ResponseBody
//	public List<User> allUsers(/*int limit, int offset*/){
////		System.out.println("分页查找");
//		
////	    System.out.println(offset+" "+limit);
////		System.out.println("查找结果" + userService.findPage(offset, limit));
////		Map<String, Object> map = new HashMap<String, Object>();
////		map.put("total", 10);
////		map.put("rows", userService.findPage(0, 5));
////		return userService.findPage(offset, limit);
//		return userService.findAllUser();
//	}
	
}
