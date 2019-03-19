package com.example.demo.controller;

import com.example.demo.dao.StuDao;
import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Sam
 * @date 2019/3/11 15:26
 */
@RestController
public class TestController {

    @Autowired
    private StuDao stuDao;

//    @GetMapping(value = "test")
//    public String test(){
//        String test = JsonUtil.EntityToString("test");
//        System.out.println(test);
//        return test;
//    }

    @GetMapping(value = "getStu")
    public Student getStuList(){
        Student stuDaoAllById = stuDao.findAllById(1);
        System.out.println(stuDaoAllById);
        return stuDaoAllById;
    }
}
