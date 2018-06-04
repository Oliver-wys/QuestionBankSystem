package qbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import qbs.domain.Academy;
import qbs.mapper.AcademyMapper;

@Service
@Transactional
public class AcademyServiceImpl implements IAcademyService{

	@Autowired
	AcademyMapper academyMapper;
	
	@Override
	public List<Academy> findAll() {
		// TODO Auto-generated method stub
		return academyMapper.findAll();
	}

	/*
	 * 添加院系
	 * @see qbs.service.IAcademyService#addAcademy(java.lang.String)
	 */
	@Override
	public void addAcademy(Academy academy) {
		// TODO Auto-generated method stub
		academyMapper.addAcademy(academy);
	}

	/*
	 * 删除单个学院
	 * @see qbs.service.IAcademyService#delAcademy(java.lang.Long)
	 */
	@Override
	public void delAcademy(Long id) {
		academyMapper.deleteAcademy(id);
	}

	/*
	 * 批量删除学院
	 * @see qbs.service.IAcademyService#delAcademys(java.util.List)
	 */
	@Override
	public void delAcademys(List<Long> ids) {
		// TODO Auto-generated method stub
		academyMapper.delAcademys(ids);
	}

	/*
	 * 修改院系信息
	 * @see qbs.service.IAcademyService#updateAcademy(qbs.domain.Academy)
	 */
	@Override
	public void updateAcademy(Academy academy) {
		// TODO Auto-generated method stub
		academyMapper.updateAcademy(academy);
	}

}
