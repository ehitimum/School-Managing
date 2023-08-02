package com.example.school_managing.repository;

import com.example.school_managing.entity.Guardian;
import com.example.school_managing.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("shabbir@gmail.com")
                .firstName("Shabbir")
                .lastName("Dawoodi")
//                .guardianName("Nikhil")
//                .guardianEmail("nikil@gmail.com")
//                .guardianMobile("999999999999")
                .build();

        studentRepository.save(student);
    }
    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .email("nikil@gmail.com")
                .name("Nikhil")
                .mobile("999999999")
                .build();
        Student student = Student.builder()
                .firstName("Aaron")
                .lastName("Redeemer")
                .emailId("aaron@gmail.com")
                .guadian(guardian)
                .build();

        studentRepository.save(student);

    }
    @Test
    public void getStudent(){
        List<Student> student = studentRepository.findAll();

        System.out.println("student = " + student);

    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> student = studentRepository.findByFirstNameContaining("Aa");
        System.out.println("studentRepository = " + student);

    }

    @Test
    public void printStudentByGuardianName(){
        List<Student> student = studentRepository.findByGuadianName("Nikhil");
        System.out.println("studentRepository = " + student);

    }
    @Test
    public void printStudentByEmailAddress(){
        Student student = studentRepository.getStudentsByEmailAddress("aaron@gmail.com");

        System.out.println("student = " + student);
    }
    @Test
    public void printStudentFirstNameByEmailAddress(){
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("aaron@gmail.com");

        System.out.println("firstName = " + firstName);
    }

    @Test
    public void printStudentByEmailAddressNative(){
        Student student = studentRepository.getStudenByEmailAddressNative("aaron@gmail.com");
        System.out.println("student = " + student);
    }
    
    @Test
    public void printStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudenByEmailAddressNativeNamedParam("aaron@gmail.com");
        System.out.println("student = " + student);
    }
    @Test
    public void updateStudentNameByEmaidAddress(){
        studentRepository.updateStudentNameByEmailId("Magnus Rackham","shabbir@gmail.com");
    }


}