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

import qbs.domain.Chapter;
import qbs.service.IChapterService;

@RestController
@RequestMapping("/main/user")
public class ChapterController {

	@Autowired
	IChapterService chapterService;

	@RequestMapping(method = RequestMethod.GET, value = "/allchapter")
	@ResponseBody
	public List<Chapter> allChapter() {
		return chapterService.findAll();
	}

	/*
	 * 通过院系和科目来查找章节
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/chapterbysubject")
	@ResponseBody
	public List<Chapter> chapterBySubject(@RequestParam("subjectname") String subjectName) {
		System.out.println("章节的科目名:" + subjectName);
		return chapterService.findBySubject(subjectName);
	}

	/*
	 * 添加新章节信息
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/addchapter", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addChapter(@RequestBody Chapter chapter) {
		System.out.println("接收的章节：" + chapter);
		chapterService.addChapter(chapter);
	}

	/*
	 * 删除单个章节信息
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/delchapter")
	public void delChapter(@RequestParam("id") Long id) {
		System.out.println("接收的id：" + id);
		chapterService.delChapter(id);
	}

	/*
	 * 批量删除章节
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/delchapters", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delChapters(@RequestBody List<Long> ids) {
		System.out.println("接收的id：" + ids);
		chapterService.delChapters(ids);
	}
	
	/*
	 * 修改章节信息
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/updatechapter", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateInf(@RequestBody Chapter chapter) {
		System.out.println("修改的章节信息：" + chapter);
		chapterService.updateChapter(chapter);
	}

}
