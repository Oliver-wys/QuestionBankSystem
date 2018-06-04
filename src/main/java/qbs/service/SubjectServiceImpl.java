package qbs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qbs.domain.Subject;
import qbs.mapper.SubjectMapper;

@Service
@Transactional
public class SubjectServiceImpl implements ISubjectService {

	@Autowired
	SubjectMapper subjectMapper;
	
	@Override
	public List<Subject> findAll() {
		// TODO Auto-generated method stub
		return subjectMapper.findAll();
	}

	/*
	 * 添加一个科目
	 * @see qbs.service.ISubjectService#addSubject(qbs.domain.Subject)
	 */
	@Override
	public void addSubject(Subject subject) {
		// TODO Auto-generated method stub
		subjectMapper.addSubject(subject);
		
	}

	@Override
	public void delSubject(Long id) {
		// TODO Auto-generated method stub
		subjectMapper.delSubject(id);
	}

	/*
	 * 通过院系名来查找科目
	 * @see qbs.service.ISubjectService#findByAcademyName(java.lang.String)
	 */
	@Override
	public List<Subject> findByAcademyName(String academyName) {
		// TODO Auto-generated method stub
		return subjectMapper.findByAcademyName(academyName);
	}

	/*
	 * 批量删除
	 * @see qbs.service.ISubjectService#delSubjects(java.util.List)
	 */
	@Override
	public void delSubjects(List<Long> ids) {
		// TODO Auto-generated method stub
		subjectMapper.delSubjects(ids);
	}
	
	

}
