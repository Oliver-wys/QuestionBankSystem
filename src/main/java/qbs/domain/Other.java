package qbs.domain;

import java.io.Serializable;

public class Other implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String academyName;
	private String subjectName;
	private String chapterName;
	private String dif_coefficient;
	private String body;
	private String answer;
	public Other() {
		super();
	}
	public Other(Long id, String academyName, String subjectName, String chapterName, String dif_coefficient,
			String body, String answer) {
		super();
		this.id = id;
		this.academyName = academyName;
		this.subjectName = subjectName;
		this.chapterName = chapterName;
		this.dif_coefficient = dif_coefficient;
		this.body = body;
		this.answer = answer;
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
	public String getChapterName() {
		return chapterName;
	}
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}
	public String getDif_coefficient() {
		return dif_coefficient;
	}
	public void setDif_coefficient(String dif_coefficient) {
		this.dif_coefficient = dif_coefficient;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "Other [" + (id != null ? "id=" + id + ", " : "")
				+ (academyName != null ? "academyName=" + academyName + ", " : "")
				+ (subjectName != null ? "subjectName=" + subjectName + ", " : "")
				+ (chapterName != null ? "chapterName=" + chapterName + ", " : "")
				+ (dif_coefficient != null ? "dif_coefficient=" + dif_coefficient + ", " : "")
				+ (body != null ? "body=" + body + ", " : "") + (answer != null ? "answer=" + answer : "") + "]";
	}
	
}
