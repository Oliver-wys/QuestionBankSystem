package qbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import qbs.domain.User;

@Controller
public class TestController {
//	, consumes = MediaType.APPLICATION_JSON_VALUE
	@RequestMapping(method = RequestMethod.GET,value = "/User/getUser" )
	public String getUser(){
		return "test";
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/User")
	public String user(@RequestBody User user ){
//		User user = new User(name,password);
		System.out.println(user);
		return "main";
	}
}
