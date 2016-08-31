package com.zhangying.oa.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.zhangying.oa.dao.FormTemplateDao;
import com.zhangying.oa.domain.FormTemplate;
import com.zhangying.oa.service.FormTemplateService;
import com.zhangying.oa.utils.UploadUtils;

@Service("formTemplateService")
public class FormTemplateServiceImpl implements FormTemplateService {
	@Resource(name="formTemplateDao")
	private FormTemplateDao formTemplateDao;

	@Override
	public Collection<FormTemplate> getFormTemplate() {
		// TODO Auto-generated method stub
		return this.formTemplateDao.getAllEntry();
	}

	@Override
	@Transactional(readOnly=false)
	public void saveFormTemplate(FormTemplate formTemplate, File source) {
		// TODO Auto-generated method stub
		/**
		 * 1、文件上传
		 * 2、保存数据到formtemplate表中
		 */
		String url = UploadUtils.saveUploadFile(source);
		formTemplate.setUrl(url);
		this.formTemplateDao.saveEntry(formTemplate);
	}

	@Override
	public InputStream download(Long ftid) throws Exception {
		// TODO Auto-generated method stub
		FormTemplate formTemplate = this.formTemplateDao.getEntryById(ftid);
		String fileName = URLEncoder.encode(formTemplate.getFtname(),"UTF-8");
		ActionContext.getContext().put("fileName", fileName);
		return new FileInputStream(new File(formTemplate.getUrl()));
	}
	
}
