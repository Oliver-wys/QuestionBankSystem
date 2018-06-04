package qbs.service;

import java.util.List;
import java.util.Map;

import qbs.domain.PaperForm;
import qbs.domain.TestInf;

public interface ITestPaperService {
	
	/*
	 * 试卷头部
	 */

	List<TestInf> findAllTestInf();
	
	List<TestInf> findTestInfBySubject(String subjectName);
	
	void delTestInf(Long id);
	
	void delTestInfs(List<Long> ids);
	
	void addTestInf(TestInf testInf);
	
	/*
	 * 试卷体
	 */
//	TestPaper findByTesetInf(Long id);
//	
//	void addTestPaper(TestPaper testPaper);
//	
//	void delTestPaper(Long id);
//	
//	void delTestPapers(List<Long> ids);
	
	
	
	/*
	 * 试卷模板
	 */
	
	List<PaperForm> findAllPaperForm();

	List<PaperForm> findPaperFormBySubject(String subjectName);
	
	void delPaperForm(Long id);
	
	void delPaperForms(List<Long> ids);
	
	void updatePaperForm(PaperForm paperForm);
	
	//人工组卷
	Map<String, Object> manualPaper(Map<String, Object> map);
	
}
