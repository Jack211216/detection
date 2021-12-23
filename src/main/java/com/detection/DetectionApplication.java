package com.detection;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@MapperScan("com.detection.mapper")
public class DetectionApplication {

    public static void main(String[] args) {

        SpringApplication.run(DetectionApplication.class, args);
        System.out.println("启动成功！\n");
    }

}
