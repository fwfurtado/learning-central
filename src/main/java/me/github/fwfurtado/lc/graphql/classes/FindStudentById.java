package me.github.fwfurtado.lc.graphql.classes;

import me.github.fwfurtado.lc.domain.models.Student;

import java.util.Optional;
import java.util.UUID;

public interface FindStudentById {
    Optional<Student> findById(UUID studentId);
}
