package qbs.service;

import java.util.List;

import qbs.domain.Other;
import qbs.domain.PaperForm;

public interface IJudgeService {

	List<Other> findAll();

	List<Other> findBySubject(String subjectName);
	
	void addJudge(Other other);
	
	void delJudge(Long id);
	
	void delJudges(List<Long> ids);
	
	void updateJudge(Other judge);
	
	List<Other> findByPaperForm(PaperForm paperForm);
}
