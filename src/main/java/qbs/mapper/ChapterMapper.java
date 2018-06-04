package qbs.mapper;

import java.util.List;

import qbs.domain.Chapter;

public interface ChapterMapper {

	List<Chapter> findAll();
	
	List<Chapter> findBySubject(String subjectName);
	
	void addChapter(Chapter chapter);
	
	void delChapter(Long id);
	
	void delChapters(List<Long> ids);
	
	void updateChapter(Chapter chapter);
}
