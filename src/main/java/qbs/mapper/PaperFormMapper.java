package qbs.mapper;

import java.util.List;

import qbs.domain.PaperForm;

public interface PaperFormMapper {

	List<PaperForm> findAll();

	List<PaperForm> findBySubject(String subjectName);
	
	void addPaperForm(PaperForm paperForm);
	
	void delPaperForm(Long id);
	
	void delPaperForms(List<Long> ids);
	
	void updatePaperForm(PaperForm paperForm);
}
