package qbs.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import qbs.domain.Other;
import qbs.domain.PaperForm;
import qbs.domain.Single;
import qbs.mapper.ShortMapper;
import qbs.tool.RandomTool;

@Controller
@Transactional
public class ShortServiceImpl implements IShortService {

	@Autowired
	ShortMapper shortMapper;
	
	@Override
	public List<Other> findAll() {
		// TODO Auto-generated method stub
		return shortMapper.findAll();
	}

	
	/*
	 * 通过科目查找简答题
	 * @see qbs.service.IShortService#findBySubject(java.lang.String)
	 */
	@Override
	public List<Other> findBySubject(String subjectName) {
		// TODO Auto-generated method stub
		return shortMapper.findBySubject(subjectName);
	}

	/*
	 * 添加一个简答题
	 * @see qbs.service.IShortService#addShort(qbs.domain.Other)
	 */
	@Override
	public void addShort(Other other) {
		// TODO Auto-generated method stub
		shortMapper.addShort(other);
	}

	/*
	 * 删除一个简答题
	 * @see qbs.service.IShortService#delShort(java.lang.Long)
	 */
	@Override
	public void delShort(Long id) {
		// TODO Auto-generated method stub
		shortMapper.delShort(id);
	}


	/*
	 * 批量删除
	 * @see qbs.service.IShortService#delShorts(java.util.List)
	 */
	@Override
	public void delShorts(List<Long> ids) {
		// TODO Auto-generated method stub
		shortMapper.delShorts(ids);
	}


	/*
	 * 更新
	 * @see qbs.service.IShortService#updateShort(qbs.domain.Other)
	 */
	@Override
	public void updateShort(Other other) {
		// TODO Auto-generated method stub
		shortMapper.updateShort(other);
	}


	/*
	 * 通过模板查题
	 * @see qbs.service.IShortService#findByPaperForm(qbs.domain.PaperForm)
	 */
	@Override
	public List<Other> findByPaperForm(PaperForm paperForm) {
		// TODO Auto-generated method stub
		List<Other> shorts = shortMapper.findByPaperForm(paperForm);
		List<Other> selShorts = new ArrayList<Other>();
		if(paperForm.getShortNum() < shorts.size()){
			int[] number = RandomTool.randomCommon(1, shorts.size(), paperForm.getShortNum().intValue());
			for(int i = 0; i < number.length; i++){
				selShorts.add(shorts.get(number[i]));
			}
		}else{
			selShorts = shorts;
		}
		System.out.println("筛选的简答题：" + selShorts);
		return selShorts;
	}

}
