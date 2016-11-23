package com.hyc.fas;

import com.hyc.fas.config.HycFasProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({HycFasProperties.class})
@MapperScan("com.hyc.fas.mapper")
public class HycFasApplication {
	public static void main(String[] args) {
		SpringApplication.run(HycFasApplication.class, args);
	}
}
