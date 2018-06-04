package qbs.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import qbs.domain.Multi;
import qbs.domain.PaperForm;
import qbs.domain.Single;
import qbs.mapper.MultiMapper;
import qbs.tool.RandomTool;

@Controller
@Transactional
public class MultiServiceImpl implements IMultiService {

	
	@Autowired
	MultiMapper multiMapper;
	
	@Override
	public List<Multi> findAll() {
		// TODO Auto-generated method stub
		return multiMapper.findAll();
	}

	/*
	 * 根据科目名来查找多选题
	 * @see qbs.service.IMultiService#findBySubject(java.lang.String)
	 */
	@Override
	public List<Multi> findBySubject(String subjectName) {
		// TODO Auto-generated method stub
		return multiMapper.findBySubject(subjectName);
	}

	
	/*
	 * 添加一个新的多选题信息
	 * @see qbs.service.IMultiService#addMulti(qbs.domain.Multi)
	 */
	@Override
	public void addMulti(Multi multi) {
		// TODO Auto-generated method stub
		multiMapper.addMulti(multi);
	}

	/*
	 * 删除单个多选题信息
	 * @see qbs.service.IMultiService#delMulti(java.lang.Long)
	 */
	@Override
	public void delMulti(Long id) {
		// TODO Auto-generated method stub
		multiMapper.delMulti(id);
	}


	/*
	 * 批量删除
	 * @see qbs.service.IMultiService#delMultis(java.util.List)
	 */
	@Override
	public void delMultis(List<Long> ids) {
		// TODO Auto-generated method stub
		multiMapper.delMultis(ids);
	}

	/*
	 * 更新
	 * @see qbs.service.IMultiService#updateMulti(qbs.domain.Multi)
	 */
	@Override
	public void updateMulti(Multi multi) {
		// TODO Auto-generated method stub
		multiMapper.updateMulti(multi);
	}

	/*
	 * 通过paperForm查题
	 * @see qbs.service.IMultiService#findByPaperForm(qbs.domain.PaperForm)
	 */
	@Override
	public List<Multi> findByPaperForm(PaperForm paperForm) {
		// TODO Auto-generated method stub
		List<Multi> multis = multiMapper.findByPaperForm(paperForm);
		List<Multi> selMultis = new ArrayList<>();
		if(paperForm.getMultiNum() < multis.size()){
			int[] number = RandomTool.randomCommon(1, multis.size(), paperForm.getMultiNum().intValue());
			for(int i = 0; i < number.length; i++){
				selMultis.add(multis.get(number[i]));
			}
		}else{
			selMultis = multis;
		}
		System.out.println("筛选的多选题题：" + selMultis);
		return selMultis;
	}

}
