package com.ljq.personapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.Collections;

/**
 * @author LJQ
 * @date 2020/11/8 4:27 PM
 */
@FeignClient(value = "person-service")  //服务提供方应用名称
public interface PersonService {

    @PostMapping("/person/save")
    boolean save(Person person);

    @GetMapping("/person/find/all")
    Collection<Person> findAll();
}
