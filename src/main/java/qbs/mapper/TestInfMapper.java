package qbs.mapper;

import java.util.List;

import qbs.domain.TestInf;

public interface TestInfMapper {

	List<TestInf> findAll();

	List<TestInf> findBySubject(String subjectName);
	
	void addTestInf(TestInf testInf);
	
	void delTestInf(Long id);
	
	void delTestInfs(List<Long> ids);
	
	
}
