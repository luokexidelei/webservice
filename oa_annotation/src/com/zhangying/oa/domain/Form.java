package com.zhangying.oa.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Form implements Serializable{
	private Long fid;
	private String title;
	private String applicator;
	private Date applicateTime;
	private String applicateState;
	
	private FormTemplate formTemplate;
	private Set<Approve> approves;
	
	
	public FormTemplate getFormTemplate() {
		return formTemplate;
	}
	public void setFormTemplate(FormTemplate formTemplate) {
		this.formTemplate = formTemplate;
	}
	public Set<Approve> getApproves() {
		return approves;
	}
	public void setApproves(Set<Approve> approves) {
		this.approves = approves;
	}
	public Long getFid() {
		return fid;
	}
	public void setFid(Long fid) {
		this.fid = fid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getApplicator() {
		return applicator;
	}
	public void setApplicator(String applicator) {
		this.applicator = applicator;
	}
	public Date getApplicateTime() {
		return applicateTime;
	}
	public void setApplicateTime(Date applicateTime) {
		this.applicateTime = applicateTime;
	}
	public String getApplicateState() {
		return applicateState;
	}
	public void setApplicateState(String applicateState) {
		this.applicateState = applicateState;
	}
	
	
}
