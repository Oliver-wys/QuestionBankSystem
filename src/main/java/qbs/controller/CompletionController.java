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
import qbs.service.ICompletionService;

@RestController
@RequestMapping("/main/user")
public class CompletionController {

	@Autowired
	ICompletionService completionService;

	@RequestMapping(method = RequestMethod.GET, value = "/allcompletion")
	@ResponseBody
	public List<Other> allCompletion() {
		return completionService.findAll();
	}

	/*
	 * 通过科目查找填空题
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/completionbysubject")
	@ResponseBody
	public List<Other> completionBySubject(@RequestParam("subjectname") String subjectName) {
		return completionService.findBySubject(subjectName);
	}

	/*
	 * 添加填空题信息
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/addcompletion", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addCompletion(@RequestBody Other other) {
		System.out.println("接收的填空题：" + other);
		completionService.addCompletion(other);
	}

	/*
	 * 删除单个填空题信息
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/delcompletion")
	public void delJudge(@RequestParam("id") Long id) {
		System.out.println("删除的填空题id：" + id);
		completionService.delCompletion(id);
	}

	/*
	 * 批量删除
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/delcompletions", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delCompletions(@RequestBody List<Long> ids) {
		System.out.println("接收的id：" + ids);
		completionService.delCompletions(ids);
	}

	/*
	 * 修改信息
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/updatecompletion", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateCompletion(@RequestBody Other Other) {
		System.out.println("修改的信息：" + Other);
		completionService.updateCompletion(Other);
	}
}
