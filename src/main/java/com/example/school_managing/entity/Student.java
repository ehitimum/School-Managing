package com.example.school_managing.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(
        uniqueConstraints = @UniqueConstraint(
                name = "emailid_unique",
                columnNames = "emailId"
        )
)
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence")

    private Long studentId;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column(nullable = false)
    private String emailId;
    @Embedded
    private Guardian guadian;

}
