package com.ljq.feign.person.service.provider.controller;

import com.ljq.personapi.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author LJQ
 * @date 2020/11/8 9:51 PM
 */
@RestController
public class PersonServiceProviderController {
    private Map<Long,Person> persons=new ConcurrentHashMap<>();


    @PostMapping("/person/save")
    public boolean save(@RequestBody Person person){
        return persons.put(person.getId(),person)==null;
    }

    @GetMapping("/person/find/all")
    public Collection<Person> findAll(){
        return persons.values();
    }
}
