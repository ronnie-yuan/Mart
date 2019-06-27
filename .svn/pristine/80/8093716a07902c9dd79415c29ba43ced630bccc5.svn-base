package com.Mart.po;

import java.util.Date;

public class User {
	private Integer	 userId;//用户id  主键
	private String	 userName;//用户账号,唯一
	private String	 userPwd;//用户密码
	private Integer	 userSex;//用户性别   男为1,女为2,默认为2
	private String 	 userMail;//用户邮箱,唯一	可为空
	private String 	 userMobile;//用户手机号码,唯一	可为空
	private String 	 userHead;//用户头像在服务器中的地址,默认为MyStatic/img/11.jpg	可为空
	private Integer  userBalance;//用户金额,默认为0,不允许为空
	private Integer  userStatus;//用户状态,0注销,1正常用户,2管理员用户 默认为1
	private String 	 userCreateTime;//用户账号创建时间	可为空
	private String 	 userAnswer;//忘记密码,找回密码答案	可为空
	private String   userQuestion;//忘记密码,找回密码的问题	可为空
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public Integer getUserSex() {
		return userSex;
	}
	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public String getUserHead() {
		return userHead;
	}
	public void setUserHead(String userHead) {
		this.userHead = userHead;
	}
	public Integer getUserBalance() {
		return userBalance;
	}
	public void setUserBalance(Integer userBalance) {
		this.userBalance = userBalance;
	}
	public Integer getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}
	public String getUserCreateTime() {
		return userCreateTime;
	}
	public void setUserCreateTime(String userCreateTime) {
		this.userCreateTime = userCreateTime;
	}
	public String getUserAnswer() {
		return userAnswer;
	}
	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}
	public String getUserQuestion() {
		return userQuestion;
	}
	public void setUserQuestion(String userQuestion) {
		this.userQuestion = userQuestion;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", userSex=" + userSex
				+ ", userMail=" + userMail + ", userMobile=" + userMobile + ", userHead=" + userHead + ", userBalance="
				+ userBalance + ", userStatus=" + userStatus + ", userCreateTime=" + userCreateTime + ", userAnswer="
				+ userAnswer + ", userQuestion=" + userQuestion + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userAnswer == null) ? 0 : userAnswer.hashCode());
		result = prime * result + ((userBalance == null) ? 0 : userBalance.hashCode());
		result = prime * result + ((userCreateTime == null) ? 0 : userCreateTime.hashCode());
		result = prime * result + ((userHead == null) ? 0 : userHead.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userMail == null) ? 0 : userMail.hashCode());
		result = prime * result + ((userMobile == null) ? 0 : userMobile.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userPwd == null) ? 0 : userPwd.hashCode());
		result = prime * result + ((userQuestion == null) ? 0 : userQuestion.hashCode());
		result = prime * result + ((userSex == null) ? 0 : userSex.hashCode());
		result = prime * result + ((userStatus == null) ? 0 : userStatus.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userAnswer == null) {
			if (other.userAnswer != null)
				return false;
		} else if (!userAnswer.equals(other.userAnswer))
			return false;
		if (userBalance == null) {
			if (other.userBalance != null)
				return false;
		} else if (!userBalance.equals(other.userBalance))
			return false;
		if (userCreateTime == null) {
			if (other.userCreateTime != null)
				return false;
		} else if (!userCreateTime.equals(other.userCreateTime))
			return false;
		if (userHead == null) {
			if (other.userHead != null)
				return false;
		} else if (!userHead.equals(other.userHead))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userMail == null) {
			if (other.userMail != null)
				return false;
		} else if (!userMail.equals(other.userMail))
			return false;
		if (userMobile == null) {
			if (other.userMobile != null)
				return false;
		} else if (!userMobile.equals(other.userMobile))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPwd == null) {
			if (other.userPwd != null)
				return false;
		} else if (!userPwd.equals(other.userPwd))
			return false;
		if (userQuestion == null) {
			if (other.userQuestion != null)
				return false;
		} else if (!userQuestion.equals(other.userQuestion))
			return false;
		if (userSex == null) {
			if (other.userSex != null)
				return false;
		} else if (!userSex.equals(other.userSex))
			return false;
		if (userStatus == null) {
			if (other.userStatus != null)
				return false;
		} else if (!userStatus.equals(other.userStatus))
			return false;
		return true;
	}

	
	
}
