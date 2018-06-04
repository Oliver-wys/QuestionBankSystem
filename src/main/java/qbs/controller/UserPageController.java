package qbs.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import qbs.config.User;
import qbs.service.IUserService;

@Controller
@RequestMapping("/main")
public class UserPageController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/user")
	public String userLogin(Model model){
		System.out.println("用户");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User secuser = (User)auth.getPrincipal();
		System.out.println("111111111secuser:" + secuser);
		model.addAttribute("curuser",userService.findUserByAccount(secuser.getUsername()));
		return "user";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/changepassword", consumes = MediaType.APPLICATION_JSON_VALUE)
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
}
