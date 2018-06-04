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

import qbs.domain.Other;
import qbs.service.IShortService;

@RestController
@RequestMapping("/main/user")
public class ShortController {

	@Autowired
	IShortService shortService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/allshort")
	@ResponseBody
	public List<Other> allShort(){
		return shortService.findAll();
	}
	
	/*
	 * 通过科目来查找简答题
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/shortbysubject")
	@ResponseBody
	public List<Other> shortBySubject(@RequestParam("subjectname") String subjectName){
		return shortService.findBySubject(subjectName);
	}
	
	/*
	 * 添加简答题信息
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/addshort", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addShort(@RequestBody Other other) {
		System.out.println("接收的简答题：" + other);
		shortService.addShort(other);
	}
	
	
	/*
	 * 删除单个判断题信息
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/delshort")
	public void delShort(@RequestParam("id") Long id) {
		System.out.println("删除的简答题id：" + id);
		shortService.delShort(id);
	}
	

	/*
	 * 批量删除
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/delshorts", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delShorts(@RequestBody List<Long> ids) {
		System.out.println("接收的id：" + ids);
		shortService.delShorts(ids);
	}
	
	/*
	 * 修改章节信息
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/updateshort", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateShort(@RequestBody Other other) {
		System.out.println("修改的章节信息：" + other);
		shortService.updateShort(other);
	}
}
