package com.example.school_managing.repository;

import com.example.school_managing.entity.Course;
import com.example.school_managing.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    private List<Course> createCourseList() {
        List<Course> courses = new ArrayList<>();
        courses.add(Course.builder()
                .title("DBA")
                .credit(5)
                .build());
        courses.add(Course.builder()
                .title("Algorithm")
                .credit(5)
                .build());
        courses.add(Course.builder()
                .title("MLP")
                .credit(5)
                .build());
        courses.add(Course.builder()
                .title("Microprocessor")
                .credit(5)
                .build());

        return courses;
    }


    @Test
    public void saveTeacher(){
        List<Course> courses = createCourseList();
        Teacher teacher = Teacher.builder()
                .firstName("Claire")
                .lastName("Darkwood")
                //.courseList(courses)
                .build();
        teacherRepository.save(teacher);
    }

}