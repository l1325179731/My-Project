package com.ljq.springcloud.client;

import com.ljq.personapi.Person;
import com.ljq.personapi.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @author LJQ
 * @date 2020/11/8 4:49 PM
 */
@RestController
public class PersonClientController {
    @Autowired
    PersonService personService;


    @PostMapping("/person/save")
    public boolean save(@RequestBody Person person) {
        return personService.save(person);
    }

    @GetMapping("/person/find/all")
    public Collection<Person> findAll() {
        return personService.findAll();
    }
}
