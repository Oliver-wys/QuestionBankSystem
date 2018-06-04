package qbs.domain;

import java.io.Serializable;
import java.sql.Date;

public class TestInf implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String academyName;
	private String subjectName;
	private String userName;
	private Date createTime;
	private Long score;
	private String time;
	public TestInf() {
		super();
	}
	public TestInf(Long id, String name, String academyName, String subjectName, String userName, Date createTime,
			Long score, String time) {
		super();
		this.id = id;
		this.name = name;
		this.academyName = academyName;
		this.subjectName = subjectName;
		this.userName = userName;
		this.createTime = createTime;
		this.score = score;
		this.time = time;
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
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Long getScore() {
		return score;
	}
	public void setScore(Long score) {
		this.score = score;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "TestInf [" + (id != null ? "id=" + id + ", " : "") + (name != null ? "name=" + name + ", " : "")
				+ (academyName != null ? "academyName=" + academyName + ", " : "")
				+ (subjectName != null ? "subjectName=" + subjectName + ", " : "")
				+ (userName != null ? "userName=" + userName + ", " : "")
				+ (createTime != null ? "createTime=" + createTime + ", " : "")
				+ (score != null ? "score=" + score + ", " : "") + (time != null ? "time=" + time : "") + "]";
	}
	
}
