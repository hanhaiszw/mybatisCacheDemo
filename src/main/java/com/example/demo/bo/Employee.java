package com.example.demo.bo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * create by sunzhongwei on 2019/07/26
 * Desc:
 **/
@Getter
@Setter
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String loginname;
    private String password;
    private String name;
    private String sex;
    private String age;
    private String phone;
    private Double sal;
    private String state;

}
