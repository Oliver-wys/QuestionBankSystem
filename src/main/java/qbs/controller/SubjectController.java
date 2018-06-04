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

import qbs.domain.Subject;
import qbs.service.ISubjectService;

@RestController
@RequestMapping("/main")
public class SubjectController {
	
	@Autowired
	ISubjectService subjectService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/manager/allsubject")
	@ResponseBody
	public List<Subject> allSubject(){
		System.out.println("全部科目：" + subjectService.findAll());
		return subjectService.findAll();
	}
	
	/*
	 * 根据院系找科目
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/user/subjectbyacademy")
	@ResponseBody
	public List<Subject> findSubjectByAcademy(@RequestParam("academyname") String academyName){
		System.out.println("全部科目：" + subjectService.findByAcademyName(academyName));
		return subjectService.findByAcademyName(academyName);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/manager/addsubject", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addSubject(@RequestBody Subject subject){
		System.out.println("新添加的科目：" + subject);
		subjectService.addSubject(subject);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/manager/delsubject")
	public void delSubject(@RequestParam("id") Long id){
		System.out.println("删除科目的id：" + id);
		subjectService.delSubject(id);
	}
	
	/*
	 * 批量删除科目
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/manager/delsubjects", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delSubjects(@RequestBody List<Long> ids) {
		System.out.println("接收的id：" + ids);
		subjectService.delSubjects(ids);
	}

}
