package qbs.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;

import qbs.domain.PaperForm;
import qbs.domain.TestInf;
import qbs.service.ITestPaperService;

@RestController
@RequestMapping("/main/user")
//@SessionAttributes("testpaper")
public class TestPaperController {

	@Autowired
	ITestPaperService testPaperService;
	

	/*
	 * 查找所有的试卷头部信息
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/alltestinf")
	@ResponseBody
	public List<TestInf> allTestInf() {
		return testPaperService.findAllTestInf();
	}
	
	/*
	 * 添加头部信息
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/addtestinf")
	public void addTestInf(HttpSession session){
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> testPaper = (Map<String, Object>)session.getAttribute("testpaper");
		System.out.println(testPaper);
		
		TestInf testInf = mapper.convertValue(testPaper.get("testInf"), TestInf.class);;
		testPaperService.addTestInf(testInf);
	}

	/*
	 * 查找所有的试卷模板信息
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/allpaperform")
	@ResponseBody
	public List<PaperForm> allPaperForm() {
		return testPaperService.findAllPaperForm();

	}

	/*
	 * 通过科目名查找试卷信息表数据
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/testinfbysubject")
	@ResponseBody
	public List<TestInf> testInfBySubject(@RequestParam("subjectname") String subjectName) {
		return testPaperService.findTestInfBySubject(subjectName);
	}


	/*
	 * 通过科目名查找试卷模板信息
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/paperformbysubject")
	@ResponseBody
	public List<PaperForm> paperFormBySubject(@RequestParam("subjectname") String subjectName) {
		return testPaperService.findPaperFormBySubject(subjectName);
	}
	

	/*
	 * 删除头部信息
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/deltestinf")
	public void delTestInf(@RequestParam("id") Long id) {
		System.out.println("删除的头部id：" + id);
		testPaperService.delTestInf(id);
	}
	

	/*
	 * 批量删除头部信息
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/deltestinfs", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delTestInfs(@RequestBody List<Long> ids) {
		System.out.println("接收的id：" + ids);
		testPaperService.delTestInfs(ids);
	}
	

	/*
	 * 删除模板信息
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/delpaperform")
	public void delpaperform(@RequestParam("id") Long id) {
		System.out.println("删除的模板id：" + id);
		testPaperService.delPaperForm(id);
	}
	

	/*
	 * 批量删除模板
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/delpaperforms", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delPaperForms(@RequestBody List<Long> ids) {
		System.out.println("接收的id：" + ids);
		testPaperService.delPaperForms(ids);
	}
	
	
	/*
	 * 更新模板
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/updatepaperform", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updatePaperform(@RequestBody PaperForm paperForm) {
		System.out.println("插入的用户信息：" + paperForm);
		testPaperService.updatePaperForm(paperForm);
	}
	
	/*
	 * 人工组卷
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/manualpaper", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delPaperForms(@RequestBody Map<String, Object> map, HttpSession session) {
		System.out.println("map: " + map);
		Map<String, Object> selMap = testPaperService.manualPaper(map);
		session.removeAttribute("testpaper");
		session.setAttribute("testpaper", selMap);
	}
	
	
}
