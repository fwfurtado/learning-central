package me.github.fwfurtado.lc.graphql.courses;

import me.github.fwfurtado.lc.domain.models.Course;
import me.github.fwfurtado.lc.graphql.classes.FindCourseById;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseRepository extends Repository<Course, UUID>, FindCourseById {

    List<Course> findAll();
    Optional<Course> findById(UUID id);

    List<Course> findAllByIdIn(List<UUID> keys);

    void save(Course course);
}
