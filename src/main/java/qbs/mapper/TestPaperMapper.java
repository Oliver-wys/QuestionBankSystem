package qbs.mapper;

import java.util.List;

import qbs.domain.TestPaper;

public interface TestPaperMapper {

	List<TestPaper> findAll();

	TestPaper findByTestInf(Long id);
	
	void addTestPaper(TestPaper testPaper);
	
	void delTestPaper(Long id);
	
	void delTestPapers(List<Long> ids);
}
