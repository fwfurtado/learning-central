package me.github.fwfurtado.lc.graphql.courses;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import me.github.fwfurtado.lc.domain.models.Course;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static java.util.Objects.nonNull;

@Component
@AllArgsConstructor
public class CourseQueryResolver implements GraphQLQueryResolver {

    private final CourseRepository repository;

    List<Course> courses(UUID id) {

        if (nonNull(id)) {
            return repository.findById(id).map(List::of).orElseGet(Collections::emptyList);
        }

        return repository.findAll();
    }
}
