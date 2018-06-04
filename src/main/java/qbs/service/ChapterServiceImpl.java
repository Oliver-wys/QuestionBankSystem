package qbs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import qbs.domain.Chapter;
import qbs.mapper.ChapterMapper;

@Controller
@Transactional
public class ChapterServiceImpl implements IChapterService {

	@Autowired
	ChapterMapper chapterMapper;
	
	@Override
	public List<Chapter> findAll() {
		// TODO Auto-generated method stub
		return chapterMapper.findAll();
	}

	/*
	 * 根据院系和科目来查找章节
	 * @see qbs.service.IChapterService#findByAcademyName(java.lang.String)
	 */
	@Override
	public List<Chapter> findBySubject(String subjectName) {
		// TODO Auto-generated method stub
		List<Chapter> chapters = chapterMapper.findBySubject(subjectName);
		System.out.println("找到的章节列表：" + chapters);
		return chapters;
	}

	/*
	 * 添加一个新的章节信息
	 * @see qbs.service.IChapterService#addChapter(qbs.domain.Chapter)
	 */
	@Override
	public void addChapter(Chapter chapter) {
		// TODO Auto-generated method stub
		chapterMapper.addChapter(chapter);
	}

	/*
	 * 删除单个的章节信息
	 * @see qbs.service.IChapterService#delChapter(java.lang.Long)
	 */
	@Override
	public void delChapter(Long id) {
		// TODO Auto-generated method stub
		chapterMapper.delChapter(id);
	}

	/*
	 * 批量删除
	 * @see qbs.service.IChapterService#delChapters(java.util.List)
	 */
	@Override
	public void delChapters(List<Long> ids) {
		// TODO Auto-generated method stub
		chapterMapper.delChapters(ids);
	}

	@Override
	public void updateChapter(Chapter chapter) {
		// TODO Auto-generated method stub
		chapterMapper.updateChapter(chapter);
	}

}
