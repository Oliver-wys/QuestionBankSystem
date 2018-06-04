package qbs.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class PaperForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String academyName;
	private String subjectName;
	private String chapterName;
	private Long singleNum;
	private Integer singleScore;
	private Long multiNum;
	private Integer multiScore;
	private Long judgeNum;
	private Integer judgeScore;
	private Long completionNum;
	private Integer completionScore;
	private Long shortNum;
	private Integer shortScore;
	private Long score;
	private String time;
	private String dif_coefficient;
	private String[] chapterList;
	public PaperForm() {
		super();
	}
	public PaperForm(Long id, String name, String academyName, String subjectName, String chapterName, Long singleNum,
			Integer singleScore, Long multiNum, Integer multiScore, Long judgeNum, Integer judgeScore,
			Long completionNum, Integer completionScore, Long shortNum, Integer shortScore, Long score, String time,
			String dif_coefficient, String[] chapterList) {
		super();
		this.id = id;
		this.name = name;
		this.academyName = academyName;
		this.subjectName = subjectName;
		this.chapterName = chapterName;
		this.singleNum = singleNum;
		this.singleScore = singleScore;
		this.multiNum = multiNum;
		this.multiScore = multiScore;
		this.judgeNum = judgeNum;
		this.judgeScore = judgeScore;
		this.completionNum = completionNum;
		this.completionScore = completionScore;
		this.shortNum = shortNum;
		this.shortScore = shortScore;
		this.score = score;
		this.time = time;
		this.dif_coefficient = dif_coefficient;
		this.chapterList = chapterName.split("\\|");
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
	public String getChapterName() {
		return chapterName;
	}
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}
	public Long getSingleNum() {
		return singleNum;
	}
	public void setSingleNum(Long singleNum) {
		this.singleNum = singleNum;
	}
	public Integer getSingleScore() {
		return singleScore;
	}
	public void setSingleScore(Integer singleScore) {
		this.singleScore = singleScore;
	}
	public Long getMultiNum() {
		return multiNum;
	}
	public void setMultiNum(Long multiNum) {
		this.multiNum = multiNum;
	}
	public Integer getMultiScore() {
		return multiScore;
	}
	public void setMultiScore(Integer multiScore) {
		this.multiScore = multiScore;
	}
	public Long getJudgeNum() {
		return judgeNum;
	}
	public void setJudgeNum(Long judgeNum) {
		this.judgeNum = judgeNum;
	}
	public Integer getJudgeScore() {
		return judgeScore;
	}
	public void setJudgeScore(Integer judgeScore) {
		this.judgeScore = judgeScore;
	}
	public Long getCompletionNum() {
		return completionNum;
	}
	public void setCompletionNum(Long completionNum) {
		this.completionNum = completionNum;
	}
	public Integer getCompletionScore() {
		return completionScore;
	}
	public void setCompletionScore(Integer completionScore) {
		this.completionScore = completionScore;
	}
	public Long getShortNum() {
		return shortNum;
	}
	public void setShortNum(Long shortNum) {
		this.shortNum = shortNum;
	}
	public Integer getShortScore() {
		return shortScore;
	}
	public void setShortScore(Integer shortScore) {
		this.shortScore = shortScore;
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
	public String getDif_coefficient() {
		return dif_coefficient;
	}
	public void setDif_coefficient(String dif_coefficient) {
		this.dif_coefficient = dif_coefficient;
	}
	public String[] getChapterList() {
		return chapterList;
	}
	public void setChapterList() {
		this.chapterList = chapterName.split("\\|");
	}
	@Override
	public String toString() {
		return "PaperForm [" + (id != null ? "id=" + id + ", " : "") + (name != null ? "name=" + name + ", " : "")
				+ (academyName != null ? "academyName=" + academyName + ", " : "")
				+ (subjectName != null ? "subjectName=" + subjectName + ", " : "")
				+ (chapterName != null ? "chapterName=" + chapterName + ", " : "")
				+ (singleNum != null ? "singleNum=" + singleNum + ", " : "")
				+ (singleScore != null ? "singleScore=" + singleScore + ", " : "")
				+ (multiNum != null ? "multiNum=" + multiNum + ", " : "")
				+ (multiScore != null ? "multiScore=" + multiScore + ", " : "")
				+ (judgeNum != null ? "judgeNum=" + judgeNum + ", " : "")
				+ (judgeScore != null ? "judgeScore=" + judgeScore + ", " : "")
				+ (completionNum != null ? "completionNum=" + completionNum + ", " : "")
				+ (completionScore != null ? "completionScore=" + completionScore + ", " : "")
				+ (shortNum != null ? "shortNum=" + shortNum + ", " : "")
				+ (shortScore != null ? "shortScore=" + shortScore + ", " : "")
				+ (score != null ? "score=" + score + ", " : "") + (time != null ? "time=" + time + ", " : "")
				+ (dif_coefficient != null ? "dif_coefficient=" + dif_coefficient + ", " : "")
				+ (chapterList != null ? "chapterList=" + Arrays.toString(chapterList) : "") + "]";
	}

	
	
}
