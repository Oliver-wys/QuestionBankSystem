package qbs.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import qbs.domain.Other;
import qbs.domain.PaperForm;
import qbs.mapper.CompletionMapper;
import qbs.tool.RandomTool;

@Controller
@Transactional
public class CompletionServiceImpl implements ICompletionService {

	@Autowired
	CompletionMapper completionMapper;
	
	@Override
	public List<Other> findAll() {
		// TODO Auto-generated method stub
		return completionMapper.findAll();
	}

	
	/*
	 * 通过科目来查找填空题
	 * @see qbs.service.ICompletionService#findBySubject(java.lang.String)
	 */
	@Override
	public List<Other> findBySubject(String subjectName) {
		// TODO Auto-generated method stub
		return completionMapper.findBySubject(subjectName);
	}

	/*
	 * 添加一个填空题信息
	 * @see qbs.service.ICompletionService#addCompletion(qbs.domain.Other)
	 */
	@Override
	public void addCompletion(Other other) {
		// TODO Auto-generated method stub
		completionMapper.addCompletion(other);
	}

	/*
	 * 删除一个填空题信息
	 * @see qbs.service.ICompletionService#delCompletion(java.lang.Long)
	 */
	@Override
	public void delCompletion(Long id) {
		// TODO Auto-generated method stub
		completionMapper.delCompletion(id);
	}


	/*
	 * 批量删除
	 * @see qbs.service.ICompletionService#delCompletions(java.util.List)
	 */
	@Override
	public void delCompletions(List<Long> ids) {
		// TODO Auto-generated method stub
		completionMapper.delCompletions(ids);
	}


	/*
	 * 更新信息
	 * @see qbs.service.ICompletionService#updateCompletion(qbs.domain.Other)
	 */
	@Override
	public void updateCompletion(Other other) {
		// TODO Auto-generated method stub
		completionMapper.updateCompletion(other);
	}


	/*
	 * 通过模板查找
	 * @see qbs.service.ICompletionService#findByPaperForm(qbs.domain.PaperForm)
	 */
	@Override
	public List<Other> findByPaperForm(PaperForm paperForm) {
		// TODO Auto-generated method stub
		List<Other> completions = completionMapper.findByPaperForm(paperForm);
		List<Other> selCompletions = new ArrayList<>();
		if(paperForm.getCompletionNum() < completions.size()){
			int[] number = RandomTool.randomCommon(1, completions.size(), paperForm.getCompletionNum().intValue());
			for(int i = 0; i < number.length; i++){
				selCompletions.add(completions.get(number[i]));
			}
		}else{
			selCompletions = completions;
		}
		System.out.println("筛选的填空题：" + selCompletions);
		return selCompletions;
	}

}
