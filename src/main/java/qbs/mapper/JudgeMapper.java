package qbs.mapper;

import java.util.List;

import qbs.domain.Other;
import qbs.domain.PaperForm;

public interface JudgeMapper {

	List<Other> findAll();

	List<Other> findBySubject(String subjectName);
	
	void addJudge(Other other);
	
	void delJudge(Long id);
	
	void delJudges(List<Long> ids);
	
	void updateJudges(Other other);
	
	List<Other> findByPaperForm(PaperForm paperForm);
}
