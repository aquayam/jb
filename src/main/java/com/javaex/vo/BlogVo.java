package com.javaex.vo;

public class BlogVo {
	
	private int userNo;
	private String blogTitle;
	private String blogFile;
	
	public BlogVo(int userNo, String blogTitle, String blogFile) {
		this.userNo = userNo;
		this.blogTitle = blogTitle;
		this.blogFile = blogFile;
	}

	public BlogVo() {
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogFile() {
		return blogFile;
	}

	public void setBlogFile(String blogFile) {
		this.blogFile = blogFile;
	}

	@Override
	public String toString() {
		return "BlogVo [userNo=" + userNo + ", blogTitle=" + blogTitle + ", blogFile=" + blogFile + "]";
	}
	
	
}
