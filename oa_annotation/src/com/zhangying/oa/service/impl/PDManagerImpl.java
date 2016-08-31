package com.zhangying.oa.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import javax.annotation.Resource;

import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessDefinitionQuery;
import org.jbpm.api.ProcessEngine;
import org.springframework.stereotype.Service;

import com.zhangying.oa.service.PDManger;

@Service("pdManager")
public class PDManagerImpl implements PDManger{
	@Resource(name="processEngine")
	private ProcessEngine processEngine;

	@Override
	public Collection<ProcessDefinition> getLastestVersion() {
		// TODO Auto-generated method stub
		List<ProcessDefinition> pdlist = this.processEngine.getRepositoryService()
		.createProcessDefinitionQuery().orderAsc(ProcessDefinitionQuery.PROPERTY_VERSION)
		.list();
		
		
		Map<String, ProcessDefinition> maps = new HashMap<String, ProcessDefinition>();
		for (ProcessDefinition processDefinition : pdlist) {
			maps.put(processDefinition.getKey(), processDefinition);
		}
		return maps.values();
	}

	@Override
	public void deploy(File resource) {
		InputStream inputStream = null;
		ZipInputStream zipInputStream = null;
		try {
			inputStream = new FileInputStream(resource);
			zipInputStream = new ZipInputStream(inputStream);
			this.processEngine.getRepositoryService()
			.createDeployment()
			.addResourcesFromZipInputStream(zipInputStream)
			.deploy();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally{
			if(inputStream != null)
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(zipInputStream != null )
				try {
					zipInputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}

	@Override
	public void deletePDKEY(String pdkey) {
		// TODO 不管部署多少次pdkey不变
		List<ProcessDefinition> pdList = this.processEngine.getRepositoryService()
		.createProcessDefinitionQuery()
		.processDefinitionKey(pdkey)
		.list();
		
		for (ProcessDefinition processDefinition : pdList) {
			this.processEngine.getRepositoryService()
			.deleteDeploymentCascade(processDefinition.getDeploymentId());
		}
	}

	@Override
	public InputStream showImage(String deploymentID) {
		// TODO Auto-generated method stub
		ProcessDefinition ps = this.processEngine.getRepositoryService()
		.createProcessDefinitionQuery()
		.deploymentId(deploymentID)
		.uniqueResult();
		
		
		return this.processEngine.getRepositoryService()
				.getResourceAsStream(deploymentID, ps.getImageResourceName());
	}

}
