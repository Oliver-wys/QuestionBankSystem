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

import qbs.domain.Academy;
import qbs.service.IAcademyService;

@RestController
@RequestMapping("/main/manager")
public class AcademyController {

	@Autowired
	IAcademyService academyService;

	@RequestMapping(method = RequestMethod.GET, value = "/allacademy")
	@ResponseBody
	public List<Academy> allAcademy() {
		System.out.println("全部院系：" + academyService.findAll());
		return academyService.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addacademy", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addAcademy(@RequestBody Academy academy) {
		System.out.println("接收的学院：" + academy);
		academyService.addAcademy(academy);
	}
	
	/*
	 * 删除单个学院
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/delacademy")
	public void delAcademy(@RequestParam("id") Long id) {
		System.out.println("接收的id：" + id);
		academyService.delAcademy(id);
	}
	 
	/*
	 * 批量删除学院
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/delacademys", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delAcademys(@RequestBody List<Long> ids) {
		System.out.println("接收的id：" + ids);
		academyService.delAcademys(ids);
	}
	
	/*
	 * 修改章节信息
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/updateacademy", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateAcademy(@RequestBody Academy academy) {
		System.out.println("修改的章节信息：" + academy);
		academyService.updateAcademy(academy);
	}

}
