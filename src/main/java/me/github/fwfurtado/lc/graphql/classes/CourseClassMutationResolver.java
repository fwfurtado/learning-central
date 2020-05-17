package me.github.fwfurtado.lc.graphql.classes;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@AllArgsConstructor
public class CourseClassMutationResolver implements GraphQLMutationResolver {

    private final CourseClassService service;

    public ClassView addClass(ClassInput form) {
        return service.createClassBy(form);
    }

    public ClassView registerStudent(StudentRegistrationInput form) {
        return service.registerStudentBy(form);
    }

    @Data
    static class ClassInput {
        private LocalDateTime startDate;
        private UUID courseId;
        private UUID instructorId;
    }

    @Data
    static class StudentRegistrationInput {
        private UUID classId;
        private UUID studentId;
    }
}
