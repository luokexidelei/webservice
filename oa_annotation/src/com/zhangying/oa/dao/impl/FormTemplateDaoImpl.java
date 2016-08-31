package com.zhangying.oa.dao.impl;

import org.springframework.stereotype.Repository;

import com.zhangying.oa.dao.FormTemplateDao;
import com.zhangying.oa.dao.base.impl.BaseDaoImpl;
import com.zhangying.oa.domain.FormTemplate;

@Repository("formTemplateDao")
public class FormTemplateDaoImpl extends BaseDaoImpl<FormTemplate> implements FormTemplateDao {

}
