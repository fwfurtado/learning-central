package me.github.fwfurtado.lc.graphql.students;

import lombok.AllArgsConstructor;
import me.github.fwfurtado.lc.domain.models.Student;
import org.springframework.stereotype.Service;

import static me.github.fwfurtado.lc.graphql.students.StudentsMutationResolver.StudentInput;

@Service
@AllArgsConstructor
public class StudentService {

    private final AddStudentMapper mapper;
    private final StudentRepository repository;

    public Student createStudentBy(StudentInput form) {
        var student = mapper.map(form);

        repository.save(student);

        return student;
    }
}
