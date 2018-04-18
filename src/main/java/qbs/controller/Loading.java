package qbs.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import qbs.domain.User;

@Controller
public class Loading {

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String init(){
		return "loading";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/Loading",
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public void Load(@RequestBody User user){
		System.out.println(user);
	}
}
