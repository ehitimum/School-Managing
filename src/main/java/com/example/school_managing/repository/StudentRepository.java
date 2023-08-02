package com.example.school_managing.repository;

import com.example.school_managing.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String name);

    public List<Student> findByLastNameNotNull();

    public List<Student> findByGuadianName(String guardianName);

    public Student findByFirstNameAndLastName(String firstName, String lastName);

    @Query("select s from Student s where s.emailId = ?1")
    public Student getStudentsByEmailAddress(String emailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    public String getStudentFirstNameByEmailAddress(String emailId);

    @Query(
            value = "SELECT * FROM student s WHERE s.email_id = ?1",
            nativeQuery = true
    )
    public Student getStudenByEmailAddressNative(String emailId);

    @Query(
            value = "SELECT * FROM student s WHERE s.email_id = :emailId",
            nativeQuery = true
    )
    public Student getStudenByEmailAddressNativeNamedParam(
            @Param("emailId") String emailId
    );

    @Modifying
    @Transactional
    @Query(
            value = "update student set first_name=?1 where email_id=?2",
            nativeQuery = true
    )
    public int updateStudentNameByEmailId(String firstName, String emailId);

}