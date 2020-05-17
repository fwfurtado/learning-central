package me.github.fwfurtado.lc.graphql.students;

import me.github.fwfurtado.lc.domain.models.Student;
import me.github.fwfurtado.lc.graphql.classes.FindStudentById;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface StudentRepository extends Repository<Student, UUID>, FindStudentById {
    void save(Student student);
}
