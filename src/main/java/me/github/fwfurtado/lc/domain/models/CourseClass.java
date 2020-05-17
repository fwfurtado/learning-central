package me.github.fwfurtado.lc.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PACKAGE;

@Entity
@Getter
@NoArgsConstructor(access = PACKAGE)
public class CourseClass {

    @Id
    @GeneratedValue(strategy = AUTO)
    private UUID id;

    private LocalDateTime start;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Instructor instructor;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Student> students = new HashSet<>();

    public CourseClass(LocalDateTime start, Course course, Instructor instructor) {
        this.start = start;
        this.course = course;
        this.instructor = instructor;
    }

    public void registerStudent(Student student) {
        students.add(student);
    }
}
