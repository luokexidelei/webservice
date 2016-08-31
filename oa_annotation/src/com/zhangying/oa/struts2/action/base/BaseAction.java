package com.zhangying.oa.struts2.action.base;

import java.lang.reflect.ParameterizedType;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	private Class classt;
	private T t;
	public BaseAction() {
		try{
			ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
			this.classt = (Class) type.getActualTypeArguments()[0];
			this.t = (T)this.classt.newInstance();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static final String LISTACTION = "listAction";
	public static final String addUI = "addUI";
	public static final String UPDATEUI = "updateUI";
	public static final String ACTION2ACTION = "action2action";
	public String listAction = LISTACTION;
	public String AddUI = addUI;
	public String action2action = ACTION2ACTION;
	public String updateUI = UPDATEUI;
	@Override
	public T getModel() {
		
		return this.t;
	}
}
