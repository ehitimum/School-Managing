package com.example.school_managing.repository;

import com.example.school_managing.entity.Course;
import com.example.school_managing.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void SaveCourseMaterial(){
        Course course = Course.builder()
                .title("DSA")
                .credit(6)
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url(".net")
                .course(course)
                .build();
        repository.save(courseMaterial);
    }

    @Test
    public void printCourseMaterial(){
        List<CourseMaterial> courseMaterialList = repository.findAll();

        System.out.println("courseMaterialList = " + courseMaterialList);
    }

}