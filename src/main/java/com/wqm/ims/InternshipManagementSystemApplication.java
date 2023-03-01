package com.wqm.ims;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.wqm.ims.dao")
public class InternshipManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternshipManagementSystemApplication.class, args);
	}

}
