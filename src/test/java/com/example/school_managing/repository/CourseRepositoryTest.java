package com.example.school_managing.repository;

import com.example.school_managing.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courseList = courseRepository.findAll();

        System.out.println("courseList = " + courseList);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Priyanka")
                .lastName("Chopra")
                .build();
        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void saveCoursesWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Roy")
                .lastName("Albart")
                .build();
        List<Course> courses = new ArrayList<>();
        courses.add(Course.builder()
                .title("Elcetronics")
                .credit(6)
                .teacher(teacher)
                .build());
        courses.add(Course.builder()
                .title("Bangla")
                .credit(6)
                .teacher(teacher)
                .build());
        courses.add(Course.builder()
                .title("English")
                .credit(6)
                .teacher(teacher)
                .build());
        courseRepository.saveAll(courses);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPagewithThreeRecords =
                PageRequest.of(0, 3);

        Pageable secondPagewithThreeRecords =
                PageRequest.of(1, 3);
        
        List<Course> allcourses = courseRepository
                .findAll(firstPagewithThreeRecords)
                .getContent();
        Long totalElements = courseRepository
                        .findAll(firstPagewithThreeRecords)
                        .getTotalElements();

        int totalPages =  courseRepository
                .findAll(firstPagewithThreeRecords)
                .getTotalPages();
        System.out.println("allCourses = " + allcourses);
        System.out.println("totalElements = " + totalElements);
        System.out.println("totalPages = " + totalPages);

    }
    
    @Test
    public void findAllSorting(){
        Pageable sortByTitle = 
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                        
                );
        Pageable sortByCredit =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("credit").descending()
                );
        Pageable sortByTitleAndCredit =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                                .descending()
                                .and(Sort.by("credit"))
                );
        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    public void printFindByTitleContainig(){
        Pageable firstPageTenRecords = PageRequest.of(0,10);

        List<Course> sortCourses = courseRepository.findByTitleContaining(
                "D",
                firstPageTenRecords).getContent();
        System.out.println("courses = " + sortCourses);
    }

    @Test
    public void saveCoursesWithStudentAndTeacher(){
//        Guardian guardian = Guardian.builder()
//                .email("abul@gmail.com")
//                .name("Abul")
//                .mobile("765318631")
//                .build();

        Student student = Student.builder()
                .firstName("Abida")
                .lastName("Khan")
                .emailId("abida@gmail.com")
//                .guadian(guardian)
                .build();
//        CourseMaterial courseMaterial = CourseMaterial.builder()
//                .url(".ip.net")
//                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Abtahi")
                .lastName("Chowdhury")
                .build();
        Course course = Course.builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
//                .courseMaterial(courseMaterial)
                .build();
        course.addStudents(student);

        courseRepository.save(course);
    }

}