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

import qbs.domain.Single;
import qbs.service.ISingleService;

@RestController
@RequestMapping("/main/user")
public class SingleController {

	@Autowired
	ISingleService singleService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/allsingle")
	@ResponseBody
	public List<Single> allChapter(){
		return singleService.findAll();
	}
	
	/*
	 * 靠科目名来查找单选题
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/singlebysubject")
	@ResponseBody
	public List<Single> singleBySubject(@RequestParam("subjectname") String subjectName){
		System.out.println("单选题的科目：" + subjectName);
		return singleService.findBySubject(subjectName);
	}
	
	/*
	 * 添加单选题信息
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/addsingle", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addSingle(@RequestBody Single single) {
		System.out.println("接收的单选题：" + single);
		singleService.addSingle(single);
	}
	
	
	/*
	 * 删除单个单选题信息
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/delsingle")
	public void delSingle(@RequestParam("id") Long id) {
		System.out.println("删除的单选题id：" + id);
		singleService.delSingle(id);
	}
	
	/*
	 * 批量删除
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/delsingles", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delSingles(@RequestBody List<Long> ids) {
		System.out.println("接收的id：" + ids);
		singleService.delSingles(ids);
	}
	
	/*
	 * 修改信息
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/updatesingle", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateSingle(@RequestBody Single Single) {
		System.out.println("修改的章节信息：" + Single);
		singleService.updateSingle(Single);
	}
}
