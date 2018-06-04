package qbs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import qbs.config.User;

@Controller
public class LoginController {

//	@Autowired
//	private IUserService UserService;

	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public String login(@RequestParam(required = false) String error, @RequestParam(required = false) String logout) {
		System.out.println("---error:"+error);
		System.out.println("---logout:"+logout);
		if(error != null){
			System.out.println("这是登录失败！");
		}else if(logout != null){
			System.out.println("这是退出系统");
		}
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "main/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
	    if (auth != null){      
	        new SecurityContextLogoutHandler().logout(request, response, auth);  
	    }  
	    return "redirect:/login?logout";
	}

	/*
	 * 接收页面传回的登陆信息,判断用户类型，重定向到对应的路径
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/main")
	@ResponseBody
	public ModelAndView Load(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User secuser = (User)auth.getPrincipal();
		if(secuser.getUsername().equals("180101")){
			return new ModelAndView("redirect:main/manager");
		}else{
			return new ModelAndView("redirect:main/user");
		}
	}
}
