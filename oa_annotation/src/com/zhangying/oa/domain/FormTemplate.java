package com.zhangying.oa.domain;

import java.io.Serializable;
import java.util.Set;
//表单模板表
public class FormTemplate implements Serializable{
	private Long ftid;
	private String ftname;//表单模板名称
	private String processKey;//jbpm中的pdkey;
	private String url;//表单模板的存储路径
	
	
	private Set<Form> forms;
	
	public Set<Form> getForms() {
		return forms;
	}
	public void setForms(Set<Form> forms) {
		this.forms = forms;
	}
	public Long getFtid() {
		return ftid;
	}
	public void setFtid(Long ftid) {
		this.ftid = ftid;
	}
	public String getFtname() {
		return ftname;
	}
	public void setFtname(String ftname) {
		this.ftname = ftname;
	}
	public String getProcessKey() {
		return processKey;
	}
	public void setProcessKey(String processKey) {
		this.processKey = processKey;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
