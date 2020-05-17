package me.github.fwfurtado.lc.graphql.classes;

import me.github.fwfurtado.lc.domain.models.Course;

import java.util.Optional;
import java.util.UUID;

public interface FindCourseById {
    Optional<Course> findById(UUID courseId);
}
