package qbs.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import qbs.domain.Multi;
import qbs.domain.Other;
import qbs.domain.PaperForm;
import qbs.mapper.JudgeMapper;
import qbs.tool.RandomTool;

@Controller
@Transactional
public class JudgeServiceImpl implements IJudgeService {

	@Autowired
	JudgeMapper judgeMapper;
	
	@Override
	public List<Other> findAll() {
		// TODO Auto-generated method stub
		return judgeMapper.findAll();
	}

	/*
	 * 通过科目名来查找判断题
	 * @see qbs.service.IJudgeService#findBySubject(java.lang.String)
	 */
	@Override
	public List<Other> findBySubject(String subjectName) {
		// TODO Auto-generated method stub
		return judgeMapper.findBySubject(subjectName);
	}

	/*
	 * 添加一个判断题
	 * @see qbs.service.IJudgeService#addJudge(qbs.domain.Other)
	 */
	@Override
	public void addJudge(Other other) {
		// TODO Auto-generated method stub
		judgeMapper.addJudge(other);
	}

	/*
	 * 删除一个判断题
	 * @see qbs.service.IJudgeService#delJudge(java.lang.Long)
	 */
	@Override
	public void delJudge(Long id) {
		// TODO Auto-generated method stub
		judgeMapper.delJudge(id);
	}

	/*
	 * 批量删除
	 * @see qbs.service.IJudgeService#delJudges(java.util.List)
	 */
	@Override
	public void delJudges(List<Long> ids) {
		// TODO Auto-generated method stub
		judgeMapper.delJudges(ids);
	}

	/*
	 * 更新信息
	 * @see qbs.service.IJudgeService#updateJudge(qbs.domain.Other)
	 */
	@Override
	public void updateJudge(Other judge) {
		// TODO Auto-generated method stub
		judgeMapper.updateJudges(judge);
	}

	/*
	 * 通过模板查题
	 * @see qbs.service.IJudgeService#findByPaperForm(qbs.domain.PaperForm)
	 */
	@Override
	public List<Other> findByPaperForm(PaperForm paperForm) {
		// TODO Auto-generated method stub
		List<Other> judges = judgeMapper.findByPaperForm(paperForm);
		List<Other> selJudges = new ArrayList<>();
		if(paperForm.getJudgeNum() < judges.size()){
			int[] number = RandomTool.randomCommon(1, judges.size(), paperForm.getJudgeNum().intValue());
			for(int i = 0; i < number.length; i++){
				selJudges.add(judges.get(number[i]));
			}
		}else{
			selJudges = judges;
		}
		System.out.println("筛选的判断题：" + selJudges);
		return selJudges;
	}

}
