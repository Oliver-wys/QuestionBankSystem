package qbs.service;

import java.util.List;

import qbs.domain.Subject;


public interface ISubjectService {

	List<Subject> findAll();
	
	List<Subject> findByAcademyName(String academyName);
	
	void addSubject(Subject subject);
	
	void delSubject(Long id);
	
	void delSubjects(List<Long> ids);
	
	
}
