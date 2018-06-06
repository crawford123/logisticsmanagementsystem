package com.paul.logisticsmanagementsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//禁用spring自动配置数据库
@EnableAutoConfiguration
@EnableTransactionManagement
@EntityScan
@MapperScan("com.paul.logisticsmanagementsystem.mapper")//扫描mapper
@SpringBootApplication
/*@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})*/
@ComponentScan
@EnableScheduling//设定定时器
public class LogisticsmanagementsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogisticsmanagementsystemApplication.class, args);
	}
}
