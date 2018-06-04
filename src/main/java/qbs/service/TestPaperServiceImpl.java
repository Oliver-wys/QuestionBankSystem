package qbs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import qbs.domain.PaperForm;
import qbs.domain.TestInf;
import qbs.mapper.PaperFormMapper;
import qbs.mapper.TestInfMapper;
import qbs.mapper.TestPaperMapper;

/**
 * 试卷的三个实体需要共同作用，使用一个service接口
 * @author Oliver
 *试卷信息展示的只有试卷头部信息和模板信息
 *
 */
@Controller
@Transactional
public class TestPaperServiceImpl implements ITestPaperService {

	@Autowired
	TestInfMapper testInfMapper;
	
	@Autowired
	PaperFormMapper paperFormMapper;
	
	@Autowired
	TestPaperMapper testPaperMapper;
	
	@Autowired
	ISingleService singleService;
	
	@Autowired
	IMultiService multiService;
	
	@Autowired
	IJudgeService judgeService;
	
	@Autowired
	ICompletionService completionService;
	
	@Autowired
	IShortService shortService;
	
	/*
	 * 查找所有的试卷头部信息
	 * @see qbs.service.ITestPaperService#findAllTestInf()
	 */
	@Override
	public List<TestInf> findAllTestInf() {
		// TODO Auto-generated method stub
		return testInfMapper.findAll();
	}

	/*
	 * 查找所有的试卷模板信息
	 * @see qbs.service.ITestPaperService#findAllPaperForm()
	 */
	@Override
	public List<PaperForm> findAllPaperForm() {
		// TODO Auto-generated method stub
		return paperFormMapper.findAll();
	}

	
	/*
	 * 通过科目名来查找试卷信息
	 * @see qbs.service.ITestPaperService#findTestPaperBySubject(java.lang.String)
	 */
	@Override
	public List<TestInf> findTestInfBySubject(String subjectName) {
		// TODO Auto-generated method stub
		return testInfMapper.findBySubject(subjectName);
	}

	/*
	 * 通过科目来查找试卷模板
	 * @see qbs.service.ITestPaperService#findPaperFormBySubject(java.lang.String)
	 */
	@Override
	public List<PaperForm> findPaperFormBySubject(String subjectName) {
		// TODO Auto-generated method stub
		return paperFormMapper.findBySubject(subjectName);
	}

	/*
	 * 删除试卷头部信息
	 * @see qbs.service.ITestPaperService#delTestInf(java.lang.Long)
	 */
	@Override
	public void delTestInf(Long id) {
		// TODO Auto-generated method stub
		testInfMapper.delTestInf(id);
	}

	/*
	 * 批量删除试卷头部
	 * @see qbs.service.ITestPaperService#delTestInfs(java.util.List)
	 */
	@Override
	public void delTestInfs(List<Long> ids) {
		// TODO Auto-generated method stub
		testInfMapper.delTestInfs(ids);
	}

	/*
	 * 通过试卷头部查找试卷主体信息
	 * @see qbs.service.ITestPaperService#findByTesetInf(java.lang.Long)
	 */
//	@Override
//	public TestPaper findByTesetInf(Long id) {
//		// TODO Auto-generated method stub
//		return testPaperMapper.findByTestInf(id);
//	}

	/*
	 * 添加试卷主体
	 * @see qbs.service.ITestPaperService#addTestPaper(qbs.domain.TestPaper)
	 */
//	@Override
//	public void addTestPaper(TestPaper testPaper) {
//		// TODO Auto-generated method stub
//		testPaperMapper.addTestPaper(testPaper);
//	}

	/*
	 * 删除试卷体
	 * @see qbs.service.ITestPaperService#delTestPaper(java.lang.Long)
	 */
//	@Override
//	public void delTestPaper(Long id) {
//		// TODO Auto-generated method stub
//		testPaperMapper.delTestPaper(id);
//	}

	/*
	 * 批量删除试卷体
	 * @see qbs.service.ITestPaperService#delTestPapers(java.util.List)
	 */
//	@Override
//	public void delTestPapers(List<Long> ids) {
//		// TODO Auto-generated method stub
//		testPaperMapper.delTestPapers(ids);
//	}

	/*
	 * 删除试卷模板
	 * @see qbs.service.ITestPaperService#delPaperForm(java.lang.Long)
	 */
	@Override
	public void delPaperForm(Long id) {
		// TODO Auto-generated method stub
		paperFormMapper.delPaperForm(id);
	}

	/*
	 * 批量删除试卷模板
	 * @see qbs.service.ITestPaperService#delPaperForm(java.util.List)
	 */
	@Override
	public void delPaperForms(List<Long> ids) {
		// TODO Auto-generated method stub
		paperFormMapper.delPaperForms(ids);
	}

	/*
	 * 更新试卷模板
	 * @see qbs.service.ITestPaperService#updatePaperForm(qbs.domain.PaperForm)
	 */
	@Override
	public void updatePaperForm(PaperForm paperForm) {
		// TODO Auto-generated method stub
		paperFormMapper.updatePaperForm(paperForm);
	}

	/*
	 * 人工组卷
	 * @see qbs.service.ITestPaperService#manualPaper(java.util.Map)
	 */
	@Override
	public Map<String, Object> manualPaper(Map<String, Object> map) {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		PaperForm paperForm = mapper.convertValue(map.get("paperForm"), PaperForm.class) ;
		TestInf testInf = mapper.convertValue(map.get("testInf"), TestInf.class);
		Map<String, Object> selMap = new TreeMap<>();
		selMap.put("testInf", testInf);
		selMap.put("paperForm", paperForm);
		paperForm.setChapterList();
		if(null != paperForm.getShortNum()){
			selMap.put("shorts", shortService.findByPaperForm(paperForm));
		}
		if(null != paperForm.getSingleNum()){
			selMap.put("singles", singleService.findByPaperForm(paperForm));
		}
		if(null != paperForm.getMultiNum()){
			selMap.put("multis", multiService.findByPaperForm(paperForm));
		}
		if(null != paperForm.getJudgeNum()){
			selMap.put("judges", judgeService.findByPaperForm(paperForm));
		}
		if(null != paperForm.getCompletionNum()){
			selMap.put("completions", completionService.findByPaperForm(paperForm));
		}
		
		System.out.println("筛选的消息：" + selMap);
		System.out.println("接收的头部信息：" + testInf);
		System.out.println("接收的模板信息：" + paperForm);
		return selMap;
	}

	/*
	 * 添加试卷头部信息
	 * @see qbs.service.ITestPaperService#addTestInf(qbs.domain.TestInf)
	 */
	@Override
	public void addTestInf(TestInf testInf) {
		// TODO Auto-generated method stub
		testInfMapper.addTestInf(testInf);
	}

}
