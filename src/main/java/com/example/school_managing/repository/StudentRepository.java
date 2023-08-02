package com.example.school_managing.repository;

import com.example.school_managing.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByFirstName (String firstName);

    public List<Student> findByFirstNameContaining (String name);
    public List<Student> findByLastNameNotNull();
    public List<Student> findByGuadianName(String guardianName);

    public  Student findByFirstNameAndLastName(String firstName, String lastName);

    @Query("select s from Student s where s.emailId = ?1")
    public Student getStudentsByEmailAddress(String emailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    public Student getStudentFirstNameByEmailAddress(String emailId);


}