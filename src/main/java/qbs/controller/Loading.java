package qbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import qbs.domain.User;
import qbs.service.IUserService;

@Controller
public class Loading {

	@Autowired
	private IUserService UserService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String init() {
		return "loading";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/main")
	@ResponseBody
	public String Load(@RequestBody User user) {
		System.out.println(user);
		return "test";
	}
}
