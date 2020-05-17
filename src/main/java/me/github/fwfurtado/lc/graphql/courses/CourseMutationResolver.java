package me.github.fwfurtado.lc.graphql.courses;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import lombok.Data;
import me.github.fwfurtado.lc.domain.models.Course;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@AllArgsConstructor
public class CourseMutationResolver implements GraphQLMutationResolver {

    private final CourseService service;

    public Course addCourse(CourseInput form) {
        return service.createCourseBy(form);
    }

    @Data
    static class CourseInput {
        private String code;
        private String name;
        private String description;
        private Duration workload;
    }
}
