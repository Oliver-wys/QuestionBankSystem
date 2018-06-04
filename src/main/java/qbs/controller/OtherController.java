package qbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import qbs.domain.Other;
import qbs.service.IOtherService;

@Controller
@RequestMapping("/main/user")
public class OtherController {

	@Autowired
	IOtherService otherService;
	
//	@RequestMapping(method = RequestMethod.GET, value = "/alljudge")
//	@ResponseBody
//	public List<Other> allJudge(){
//		return otherService.findAll();
//	}
//	
//	@RequestMapping(method = RequestMethod.GET, value = "/allcompletion")
//	@ResponseBody
//	public List<Other> allCompletion(){
//		return otherService.findAll();
//	}
//	
//	@RequestMapping(method = RequestMethod.GET, value = "/allshort")
//	@ResponseBody
//	public List<Other> allShort(){
//		return otherService.findAll();
//	}
}
