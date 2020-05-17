package me.github.fwfurtado.lc.graphql.students;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import lombok.Data;
import me.github.fwfurtado.lc.domain.models.Student;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StudentsMutationResolver implements GraphQLMutationResolver {

    private final StudentService service;

    Student addStudent(StudentInput form) {
        return service.createStudentBy(form);
    }

    @Data
    static class StudentInput {
        private String name;
        private String email;
    }
}
