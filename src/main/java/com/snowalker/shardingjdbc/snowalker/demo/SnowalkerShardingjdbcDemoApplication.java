package com.snowalker.shardingjdbc.snowalker.demo;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@ImportResource({"classpath*:/spring-*.xml"})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan(basePackages = {"com.snowalker.shardingjdbc.snowalker.demo.mapper"}
)
@EnableEncryptableProperties
public class SnowalkerShardingjdbcDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SnowalkerShardingjdbcDemoApplication.class, args);
    }

}
