package cn.happain.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;


/**
 * @author happain
 */
@SpringBootApplication
@ComponentScans({
    @ComponentScan(value = "cn.happain.common.**"),
    @ComponentScan(value = "cn.happain.system.**")
})
@MapperScan("cn.happain.system.**.mapper")
public class XzgSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(XzgSystemApplication.class, args);
    }

}
