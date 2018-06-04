package qbs.service;

import java.util.List;

import qbs.domain.Academy;

public interface IAcademyService {

	
	/*
	 * 查找所有的学院信息
	 */
	
	List<Academy> findAll();
	
	/*
	 * 根据名字插入院系信息
	 */
	void addAcademy(Academy academy);
	
	void delAcademy(Long id);
	
	void delAcademys(List<Long> ids);
	
	void updateAcademy(Academy academy);
}
