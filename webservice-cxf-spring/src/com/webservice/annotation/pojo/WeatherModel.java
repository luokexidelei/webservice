package com.webservice.annotation.pojo;

import java.util.Date;

public class WeatherModel {
	private String detail;
	
	private Date date;
	
	private int max_tem;
	
	private int min_tem;
	
	//天气图片
	private String img;

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getMax_tem() {
		return max_tem;
	}

	public void setMax_tem(int max_tem) {
		this.max_tem = max_tem;
	}

	public int getMin_tem() {
		return min_tem;
	}

	public void setMin_tem(int min_tem) {
		this.min_tem = min_tem;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	
}
