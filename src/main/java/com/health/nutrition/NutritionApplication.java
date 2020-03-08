package com.health.nutrition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NutritionApplication {

	public static void main(String[] args) {
		//开启热部署
		System.setProperty("spring.devtools.restart.enabled", "true");
		//IDEA配置SpringBoot热启动
		/*
		第一步 File-Settings-Compiler-Build Project automatically
		第二部 ctrl + shift + alt + /,选择Registry,勾上 Compiler autoMake allow when app running
		fasdfsdfasdfasfas132312
		 */
		SpringApplication.run(NutritionApplication.class, args);
	}

}
