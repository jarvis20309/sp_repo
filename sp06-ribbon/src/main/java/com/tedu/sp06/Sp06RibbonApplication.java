package com.tedu.sp06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
@EnableEurekaClient
@SpringBootApplication
public class Sp06RibbonApplication {
	//创建 RestTemplate 实例，并存入 spring 容器
	@LoadBalanced	//负载均衡注解
	@Bean
	public RestTemplate getRestTempate() {
		SimpleClientHttpRequestFactory f = new SimpleClientHttpRequestFactory();
		f.setConnectTimeout(1000);
		f.setReadTimeout(1000);
		return new RestTemplate(f);
	}
	public static void main(String[] args) {
		SpringApplication.run(Sp06RibbonApplication.class, args);
	}

}
