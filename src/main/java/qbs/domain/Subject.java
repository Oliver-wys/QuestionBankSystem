package qbs.domain;

import java.io.Serializable;


/**
 * 科目类
 * @author Oliver
 *
 */
public class Subject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String academyName;

	public Subject() {
		super();
	}
	public Subject(Long id, String name, String academyName) {
		super();
		this.id = id;
		this.name = name;
		this.academyName = academyName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAcademyName() {
		return academyName;
	}
	public void setAcademyName(String academyName) {
		this.academyName = academyName;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", academyName=" + academyName
				+ "]";
	}
	
	

}
