package me.github.fwfurtado.lc.graphql.students;

import me.github.fwfurtado.lc.domain.models.Student;
import me.github.fwfurtado.lc.infra.Mapper;
import org.springframework.stereotype.Component;

@Component
public class AddStudentMapper implements Mapper<StudentsMutationResolver.StudentInput, Student> {
    @Override
    public Student map(StudentsMutationResolver.StudentInput input) {
        return new Student(input.getName(), input.getEmail());
    }
}
