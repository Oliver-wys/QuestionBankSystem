package qbs.domain;

import java.io.Serializable;

public class TestPaper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long testInfId;
	private String singleId;
	private String multiId;
	private String judgeId;
	private String shortId;
	private String completionId;
	
	public TestPaper() {
		super();
	}

	public TestPaper(Long id, Long testInfId, String singleId, String multiId, String judgeId, String shortId,
			String completionId) {
		super();
		this.id = id;
		this.testInfId = testInfId;
		this.singleId = singleId;
		this.multiId = multiId;
		this.judgeId = judgeId;
		this.shortId = shortId;
		this.completionId = completionId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTestInfId() {
		return testInfId;
	}

	public void setTestInfId(Long testInfId) {
		this.testInfId = testInfId;
	}

	public String getSingleId() {
		return singleId;
	}

	public void setSingleId(String singleId) {
		this.singleId = singleId;
	}

	public String getMultiId() {
		return multiId;
	}

	public void setMultiId(String multiId) {
		this.multiId = multiId;
	}

	public String getJudgeId() {
		return judgeId;
	}

	public void setJudgeId(String judgeId) {
		this.judgeId = judgeId;
	}

	public String getShortId() {
		return shortId;
	}

	public void setShortId(String shortId) {
		this.shortId = shortId;
	}

	public String getCompletionId() {
		return completionId;
	}

	public void setCompletionId(String completionId) {
		this.completionId = completionId;
	}

	@Override
	public String toString() {
		return "TestPaper [" + (id != null ? "id=" + id + ", " : "")
				+ (testInfId != null ? "testInfId=" + testInfId + ", " : "")
				+ (singleId != null ? "singleId=" + singleId + ", " : "")
				+ (multiId != null ? "multiId=" + multiId + ", " : "")
				+ (judgeId != null ? "judgeId=" + judgeId + ", " : "")
				+ (shortId != null ? "shortId=" + shortId + ", " : "")
				+ (completionId != null ? "completionId=" + completionId : "") + "]";
	}
	
	
}
