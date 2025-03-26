package com.teamname.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication  /* 스프링부트 실행해주는 어노테이션 */
@EnableJpaAuditing      /* JPA 감사 활성화 (날짜 자동생성) */
public class Demo2Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);
    }

}
