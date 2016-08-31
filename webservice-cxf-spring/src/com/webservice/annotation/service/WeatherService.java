package com.webservice.annotation.service;

import java.util.List;

import javax.jws.WebService;

import com.webservice.annotation.pojo.WeatherModel;
@WebService(serviceName = "WeatherService", portName = "WeatherServiceSoap", name = "WeatherInterface", targetNamespace = "http://webservice.zhangying.com")
public interface WeatherService {
	//根据城市名称查询3的天气
	public List<WeatherModel> queryWeather(String cityName);
}
