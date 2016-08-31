package com.zhangying.webservice.cxf.spring.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.zhangying.webservice.WeatherInterface;
import com.zhangying.webservice.WeatherModel;

public class Client {
	public static void main(String[] args) throws MalformedURLException {

		// 创建webservice的url
		// 可以指定说明书的地址，也可以指定webservice的地址
		URL url = new URL("http://localhost:8080/webservice-cxf-spring/ws/weather?wsdl");

		// 为了监视webservice请求的内容，需要修改地址
		// URL url = new URL("http://127.0.0.1:54321/weather?wsdl");

		// 第一个参数是命名空间的地址，第二个参数是命名空间下服务视图的名字
		QName name = new QName("http://webservice.zhangying.com", "WeatherService");

		// 1.创建一个服务视图对象
		Service service = Service.create(url, name);

		// 2.通过服务视图对象创建portType
		WeatherInterface weatherInterfaceImpl = service.getPort(WeatherInterface.class);

		// 3.通过portType调用服务方法
		String cithName = "北京";
		List<WeatherModel> results = weatherInterfaceImpl.queryWeather(cithName);

		for (WeatherModel weatherModel : results) {
			//Date date = weatherModel.getDate().toGregorianCalendar().getTime();
			//SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
			//		"yyyy-MM-dd");
			//System.out.println(simpleDateFormat.format(date));
			System.out.println("天气状况：" + weatherModel.getDetail());
			System.out.println(weatherModel.getImg());
		}
	}
}
