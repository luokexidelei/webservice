package com.zhangying.oa.struts2.action;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;

import javax.annotation.Resource;

import org.jbpm.api.ProcessDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhangying.oa.service.PDManger;
import com.zhangying.oa.struts2.action.base.BaseAction;

@Controller("pdManagerAction")
@Scope("prototype")
public class PDManagerAction extends ActionSupport {
	@Resource(name="pdManager")
	private PDManger pdManager;
	
	private File resource;
	private String pdkey;
	private InputStream inputStream;
	private String deploymentId;
	
	public String getLasterVersion() {
		Collection<ProcessDefinition> pdlist = this.pdManager.getLastestVersion();
		
		ActionContext.getContext().put("pdlist", pdlist);
		return "listAction";
	}
	/**
	 * 转向到部署页面
	 * @return
	 */
	public String deployUI() {
		return "deployUI";
	}
	//部署
	public String deploy() {
		this.pdManager.deploy(this.resource);
		return "action2action";
	}
	
	//删除
	public String delete() {
		this.pdManager.deletePDKEY(this.pdkey);
		return "action2action";
	}
	//查看流程图
	public String showImage() {
		this.inputStream = this.pdManager.showImage(deploymentId);
		return SUCCESS;
	}
	
	public File getResource() {
		return resource;
	}
	public void setResource(File resource) {
		this.resource = resource;
	}
	public String getPdkey() {
		return pdkey;
	}
	public void setPdkey(String pdkey) {
		this.pdkey = pdkey;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getDeploymentId() {
		return deploymentId;
	}
	public void setDeploymentId(String deploymentId) {
		this.deploymentId = deploymentId;
	}
	
}
