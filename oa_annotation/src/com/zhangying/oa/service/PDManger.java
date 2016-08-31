package com.zhangying.oa.service;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;

import org.jbpm.api.ProcessDefinition;

public interface PDManger {
	public Collection<ProcessDefinition> getLastestVersion();
	
	public void deploy(File resource);
	
	public void deletePDKEY(String pdkey);
	
	public InputStream showImage(String deploymentID);
}
