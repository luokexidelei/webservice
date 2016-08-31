package com.webservice.annotation.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import cn.com.webxml.ArrayOfString;
import cn.com.webxml.WeatherWebServiceSoap;

import com.webservice.annotation.pojo.WeatherModel;

public class WeatherServiceImpl implements WeatherService {
	// 注入公网查询的portType
	private WeatherWebServiceSoap weatherWebServiceSoap;

	@Override
	public List<WeatherModel> queryWeather(String cityName) {
		List<WeatherModel> list = new ArrayList<WeatherModel>();

		// 调用公网天气数据

		ArrayOfString arrayOfString = weatherWebServiceSoap.getWeatherbyCityName(cityName);
		List<String> results = arrayOfString.getString();

		// 解析从公网查询的信息

		// 查询数据
		for (String string : results) {
			System.out.println(string);
		}

		// 第一天
		WeatherModel model1 = new WeatherModel();
		// 天气概况
		model1.setDetail(results.get(6));
		// 天气图片
		model1.setImg(results.get(8));
		list.add(model1);
		
		// 第2天
		WeatherModel model2 = new WeatherModel();
		// 天气概况
		model2.setDetail(results.get(13));
		// 天气图片
		model2.setImg(results.get(15));
		list.add(model2);
		
		// 第3天
		WeatherModel model3 = new WeatherModel();
		// 天气概况
		model3.setDetail(results.get(18));
		// 天气图片
		model3.setImg(results.get(20));
		list.add(model3);

		return list;
	}

	public WeatherWebServiceSoap getWeatherWebServiceSoap() {
		return weatherWebServiceSoap;
	}

	public void setWeatherWebServiceSoap(
			WeatherWebServiceSoap weatherWebServiceSoap) {
		this.weatherWebServiceSoap = weatherWebServiceSoap;
	}

}
