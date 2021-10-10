package org.aliu.springboot.model.second;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("org.aliu.springboot.model.second.mapper")
public class SpringbootModelSecondApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootModelSecondApplication.class, args);
    }

}
