package qbs.mapper;

import java.util.List;

import qbs.domain.Other;
import qbs.domain.PaperForm;

public interface ShortMapper {

	List<Other> findAll();

	List<Other> findBySubject(String subjectName);
	
	void addShort(Other other);
	
	void delShort(Long id);
	
	void delShorts(List<Long> ids);
	
	void updateShort(Other other);
	
	List<Other> findByPaperForm(PaperForm paperForm);
}
