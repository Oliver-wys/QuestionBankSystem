package qbs.service;

import java.util.List;

import qbs.domain.PaperForm;
import qbs.domain.Single;

public interface ISingleService {

	List<Single> findAll();

	
	List<Single> findBySubject(String subjectName);
	
	void addSingle(Single single);
	
	void delSingle(Long id);
	
	void delSingles(List<Long> ids);
	
	void updateSingle(Single single);
	
	List<Single> findByPaperForm(PaperForm paperForm);
}
