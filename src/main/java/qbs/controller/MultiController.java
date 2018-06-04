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

import qbs.domain.Multi;
import qbs.service.IMultiService;

@RestController
@RequestMapping("/main/user")
public class MultiController {

	@Autowired
	IMultiService multiService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/allmulti")
	@ResponseBody
	public List<Multi> allMulti(){
		return multiService.findAll();
	}
	
	/*
	 * 根据科目名来查找多选题
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/multibysubject")
	@ResponseBody
	public List<Multi> findBySubject(@RequestParam("subjectname") String subjectName){
		System.out.println("多选题的科目：" + subjectName);
		return multiService.findBySubject(subjectName);
	}
	
	/*
	 * 添加多选题信息
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/addmulti", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addMult(@RequestBody Multi multi) {
		System.out.println("接收的多选题：" + multi);
		multiService.addMulti(multi);
	}
	
	
	/*
	 * 删除单个多选题信息
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/delmulti")
	public void delMulti(@RequestParam("id") Long id) {
		System.out.println("删除的多选题id：" + id);
		multiService.delMulti(id);
	}
	
	/*
	 * 批量删除
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/delmultis", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delMultis(@RequestBody List<Long> ids) {
		System.out.println("接收的id：" + ids);
		multiService.delMultis(ids);
	}
	
	/*
	 * 修改信息
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/updatemulti", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateMulti(@RequestBody Multi multi) {
		System.out.println("修改的章节信息：" + multi);
		multiService.updateMulti(multi);
	}
}
