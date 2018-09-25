package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 默认扫描同包名下的package
@SpringBootApplication(scanBasePackages = { "com.demo.*", "my.lover,controller" })
public class GirlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GirlApplication.class, args);
	}
}
