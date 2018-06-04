package qbs.mapper;

import java.util.List;

import qbs.domain.Multi;
import qbs.domain.PaperForm;
import qbs.domain.Single;

public interface MultiMapper {

	List<Multi> findAll();
	
	List<Multi> findBySubject(String subjectName);
	
	void addMulti(Multi multi);
	
	void delMulti(Long id);
	
	void delMultis(List<Long> ids);
	
	void updateMulti(Multi multi);
	
	List<Multi> findByPaperForm(PaperForm paperForm);
}
