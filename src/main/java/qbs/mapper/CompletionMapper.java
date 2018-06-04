package qbs.mapper;

import java.util.List;

import qbs.domain.Other;
import qbs.domain.PaperForm;

public interface CompletionMapper {

	List<Other> findAll();

	List<Other> findBySubject(String subjectName);
	
	void addCompletion(Other other);
	
	void delCompletion(Long id);
	
	void delCompletions(List<Long> ids);
	
	void updateCompletion(Other other);
	
	List<Other> findByPaperForm(PaperForm paperForm);
}
