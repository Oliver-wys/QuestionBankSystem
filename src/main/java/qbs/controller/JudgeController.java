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
import qbs.service.IJudgeService;

@RestController
@RequestMapping("/main/user")
public class JudgeController {

	@Autowired
	IJudgeService judgeService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/alljudge")
	@ResponseBody
	public List<Other> allJudge(){
		return judgeService.findAll();
	}

	/*
	 * 通过科目名来查找判断题
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/judgebysubject")
	@ResponseBody
	public List<Other> judgeBySubject(@RequestParam("subjectname") String subjectName){
		return judgeService.findBySubject(subjectName);
	}

	/*
	 * 添加判断题信息
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/addjudge", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addJudge(@RequestBody Other other) {
		System.out.println("接收的判断题：" + other);
		judgeService.addJudge(other);
	}
	
	
	/*
	 * 删除单个判断题信息
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/deljudge")
	public void delJudge(@RequestParam("id") Long id) {
		System.out.println("删除的判断题id：" + id);
		judgeService.delJudge(id);
	}
	

	/*
	 * 批量删除
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/deljudges", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delJudges(@RequestBody List<Long> ids) {
		System.out.println("接收的id：" + ids);
		judgeService.delJudges(ids);
	}
	
	/*
	 * 修改信息
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/updatejudge", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateJudge(@RequestBody Other judge) {
		System.out.println("修改的章节信息：" + judge);
		judgeService.updateJudge(judge);
	}
}
