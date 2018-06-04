package qbs.mapper;

import java.util.List;

import qbs.domain.Subject;

public interface SubjectMapper {

	/*
	 * 查询一个科目
	 */
	Subject findSubject(String info);
	
	/*
	 * 查询所有的科目
	 */
	List<Subject> findAll();
	
	/*
	 * 根据院系查找科目
	 */ 
	List<Subject> findByAcademyName(String academyName);
	
	/*
	 * 删除指定的科目,通过科目的id
	 */
	Boolean delSubject(Long id);
	
	/*
	 * 批量删除
	 */
	void delSubjects(List<Long> ids);
	
	/*
	 * 添加新的科目
	 */
	Boolean addSubject(Subject subject);
	
	/*
	 * 修改指定的科目信息
	 * 按照id匹配
	 */
	Boolean updateSubject(Subject subject);
}
