package qbs.mapper;

import java.util.List;

import qbs.domain.Academy;

public interface AcademyMapper {

	Academy findOne();
	
	/*
	 * 查找所有的学院信息
	 */
	List<Academy> findAll();
	
	/*
	 * 插入一个学院信息
	 * 由于学院只有两个字段，id由数据库的序列控制，所以只有name
	 */
	Boolean addAcademy(Academy academy);
	
	/*
	 * 删除单个的学院
	 */
	Boolean deleteAcademy(Long id);
	
	/*
	 * 批量删除
	 */
	void delAcademys(List<Long> ids);
	
	/*
	 * 修改学院名字
	 */
	Boolean updateAcademy(Academy academy);
}
