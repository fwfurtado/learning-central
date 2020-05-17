package me.github.fwfurtado.lc.graphql.classes;

import me.github.fwfurtado.lc.domain.models.CourseClass;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseClassRepository extends Repository<CourseClass, UUID> {

    @Query("select c.id as id, c.start as start, c.course.id as courseId, c.instructor.id as instructorId from CourseClass c join c.course join c.instructor")
    List<ClassView> loadAllClasses();

    @Query("select c from CourseClass c where c.id = :id")
    Optional<ClassView> readCourseClassById(UUID id);

    void save(CourseClass courseClass);

    Optional<CourseClass> findById(UUID id);
}
