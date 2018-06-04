package qbs.domain;

import java.io.Serializable;

public class Chapter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String academyName;
	private String subjectName;
	private String name;
	
	
	public Chapter() {
		super();
	}


	public Chapter(Long id, String academyName, String subjectName, String name) {
		super();
		this.id = id;
		this.academyName = academyName;
		this.subjectName = subjectName;
		this.name = name;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getAcademyName() {
		return academyName;
	}


	public void setAcademyName(String academyName) {
		this.academyName = academyName;
	}


	public String getSubjectName() {
		return subjectName;
	}


	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Chapter [" + (id != null ? "id=" + id + ", " : "")
				+ (academyName != null ? "academyName=" + academyName + ", " : "")
				+ (subjectName != null ? "subjectName=" + subjectName + ", " : "")
				+ (name != null ? "name=" + name : "") + "]";
	}
	
}
