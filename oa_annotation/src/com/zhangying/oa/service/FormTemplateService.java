package com.zhangying.oa.service;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;

import com.zhangying.oa.domain.FormTemplate;

public interface FormTemplateService {
	public Collection<FormTemplate> getFormTemplate();
	
	public void saveFormTemplate(FormTemplate formTemplate,File source);
	
	public InputStream download(Long ftid) throws Exception;
}
