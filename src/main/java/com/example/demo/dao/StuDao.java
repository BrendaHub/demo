package com.example.demo.dao;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author Sam
 * @date 2019/3/14 14:40
 */
public interface StuDao extends JpaRepository<Student, Integer> {

    public Student findAllById(Integer id);
}
