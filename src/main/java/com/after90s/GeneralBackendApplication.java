package com.after90s;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * 
 * <p>TODO </p>
 *
 * @author LJW
 * @version 2019年7月19日
 */
@SpringBootApplication
@EnableTransactionManagement
//@MapperScan("com.ruoyi.project.*.*.mapper")
@MapperScan("com.after90s.core.*.*.*")
public class GeneralBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeneralBackendApplication.class, args);
	}

}
