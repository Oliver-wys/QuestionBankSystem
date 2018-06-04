package qbs.domain;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String account;
	private String password;
	private String name;
	private Integer isManager;
	private String gender;
	private String phoneNum;
	private String academyName;
	
	public User() {
		super();
	}

	public User(Long id, String account, String password, String name, Integer isManager, String gender,
			String phoneNum, String academyName) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.name = name;
		this.isManager = isManager;
		this.gender = gender;
		this.phoneNum = phoneNum;
		this.academyName = academyName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * 数字1表示为管理员
	 * 数字2表示为老师
	 */
	public Integer getIsManager() {
		return isManager;
	}

	public void setIsManager(Integer isManager) {
		this.isManager = isManager;
	}

	public String getGender() {
		return gender;
	}

	
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAcademyName() {
		return academyName;
	}

	public void setAcademyName(String academyName) {
		this.academyName = academyName;
	}

	@Override
	public String toString() {
		return "User [" + (id != null ? "id=" + id + ", " : "") + (account != null ? "account=" + account + ", " : "")
				+ (password != null ? "password=" + password + ", " : "") + (name != null ? "name=" + name + ", " : "")
				+ (isManager != null ? "isManager=" + isManager + ", " : "")
				+ (gender != null ? "gender=" + gender + ", " : "")
				+ (phoneNum != null ? "phoneNum=" + phoneNum + ", " : "")
				+ (academyName != null ? "academyName=" + academyName : "") + "]";
	}

	
}
