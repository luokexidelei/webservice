package com.zhangying.oa.struts2.action;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;

import javax.annotation.Resource;

import org.jbpm.api.ProcessDefinition;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.zhangying.oa.domain.FormTemplate;
import com.zhangying.oa.service.FormTemplateService;
import com.zhangying.oa.service.PDManger;
import com.zhangying.oa.struts2.action.base.BaseAction;

@Controller("formTemplateAction")
@Scope("prototype")
public class FormTemplateAction extends BaseAction<FormTemplate> {
	
	@Resource(name="formTemplateService")
	private FormTemplateService formTemplateService;
	@Resource(name="pdManager")
	private PDManger pdManager;
	
	private File resource;
	private InputStream inputStream;
	
	public String getAllForTemplate() {
		Collection<FormTemplate> formTemplates = this.formTemplateService.getFormTemplate();
		ActionContext.getContext().put("ftList", formTemplates);
		return listAction;
	}
	
	public String addUI() {
		Collection<ProcessDefinition> pdList = this.pdManager.getLastestVersion();
		ActionContext.getContext().put("pdList", pdList);
		return addUI;
	}
	public String add() {
		FormTemplate formTemplate = new FormTemplate();
		BeanUtils.copyProperties(this.getModel(), formTemplate);
		//BeanUtils.copyProperties(this.getModel(), formTemplate);
		this.formTemplateService.saveFormTemplate(formTemplate, resource);
		return action2action;
	}
	
	public  String download() throws Exception{
		this.inputStream = this.formTemplateService.download(this.getModel().getFtid());
		return SUCCESS;
	}

	public File getResource() {
		return resource;
	}

	public void setResource(File resource) {
		this.resource = resource;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	
}
