package com.ljq.springcloud.client;

import com.ljq.personapi.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author LJQ
 * @date 2020/11/8 4:47 PM
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(clients = PersonService.class)
public class PersonClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(PersonClientApplication.class,args);
    }
}
