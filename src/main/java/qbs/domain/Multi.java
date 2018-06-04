package qbs.domain;

import java.io.Serializable;

public class Multi implements Serializable {

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
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private String optionE;
	private String answer;
	public Multi() {
		super();
	}
	public Multi(Long id, String academyName, String subjectName, String chapterName, String dif_coefficient,
			String body, String optionA, String optionB, String optionC, String optionD, String optionE,
			String answer) {
		super();
		this.id = id;
		this.academyName = academyName;
		this.subjectName = subjectName;
		this.chapterName = chapterName;
		this.dif_coefficient = dif_coefficient;
		this.body = body;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.optionE = optionE;
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
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public String getOptionE() {
		return optionE;
	}
	public void setOptionE(String optionE) {
		this.optionE = optionE;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "Multi [" + (id != null ? "id=" + id + ", " : "")
				+ (academyName != null ? "academyName=" + academyName + ", " : "")
				+ (subjectName != null ? "subjectName=" + subjectName + ", " : "")
				+ (chapterName != null ? "chapterName=" + chapterName + ", " : "")
				+ (dif_coefficient != null ? "dif_coefficient=" + dif_coefficient + ", " : "")
				+ (body != null ? "body=" + body + ", " : "") + (optionA != null ? "optionA=" + optionA + ", " : "")
				+ (optionB != null ? "optionB=" + optionB + ", " : "")
				+ (optionC != null ? "optionC=" + optionC + ", " : "")
				+ (optionD != null ? "optionD=" + optionD + ", " : "")
				+ (optionE != null ? "optionE=" + optionE + ", " : "") + (answer != null ? "answer=" + answer : "")
				+ "]";
	}
	
}
