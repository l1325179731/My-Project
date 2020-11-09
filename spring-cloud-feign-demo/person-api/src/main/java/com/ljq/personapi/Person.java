package com.ljq.personapi;

import sun.rmi.runtime.Log;

/**
 * @author LJQ
 * @date 2020/11/8 4:26 PM
 */
public class Person {
    Long id;
    String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
