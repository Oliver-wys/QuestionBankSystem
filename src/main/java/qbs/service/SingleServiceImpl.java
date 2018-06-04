package qbs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import qbs.domain.PaperForm;
import qbs.domain.Single;
import qbs.mapper.SingleMapper;
import qbs.tool.RandomTool;

@Controller
@Transactional
public class SingleServiceImpl implements ISingleService {

	@Autowired
	SingleMapper singleMapper;
	
	@Override
	public List<Single> findAll() {
		// TODO Auto-generated method stub
		return singleMapper.findAll();
	}

	/*
	 * 根据科目来找单选题
	 * @see qbs.service.ISingleService#findBySubject(java.lang.String)
	 */
	@Override
	public List<Single> findBySubject(String subjectName) {
		// TODO Auto-generated method stub
		return singleMapper.findBySubject(subjectName);
	}

	/*
	 * 添加一个单选题
	 * @see qbs.service.ISingleService#addSingle(qbs.domain.Single)
	 */
	@Override
	public void addSingle(Single single) {
		// TODO Auto-generated method stub
		singleMapper.addSingle(single);
	}

	
	/*
	 * 删除单个单选题信息
	 * @see qbs.service.ISingleService#delSingle(java.lang.Long)
	 */
	@Override
	public void delSingle(Long id) {
		// TODO Auto-generated method stub
		singleMapper.delSingle(id);
	}

	/*
	 * 批量删除
	 * @see qbs.service.ISingleService#delSingles(java.util.List)
	 */
	@Override
	public void delSingles(List<Long> ids) {
		// TODO Auto-generated method stub
		singleMapper.delSingles(ids);
	}

	/*
	 * 更新
	 * @see qbs.service.ISingleService#updateSingle(qbs.domain.Single)
	 */
	@Override
	public void updateSingle(Single single) {
		// TODO Auto-generated method stub
		singleMapper.updateSingle(single);
	}

	@Override
	public List<Single> findByPaperForm(PaperForm paperForm) {
		// TODO Auto-generated method stub
		List<Single> singles = singleMapper.findByPaperForm(paperForm);
		List<Single> selSingles = new ArrayList<Single>();
		if(paperForm.getSingleNum() < singles.size()){
			int[] number = RandomTool.randomCommon(1, singles.size(), paperForm.getSingleNum().intValue());
			for(int i = 0; i < number.length; i++){
				selSingles.add(singles.get(number[i]));
			}
		}else{
			selSingles = singles;
		}
		System.out.println("筛选的单选题：" + selSingles);
		return selSingles;
	}

}
