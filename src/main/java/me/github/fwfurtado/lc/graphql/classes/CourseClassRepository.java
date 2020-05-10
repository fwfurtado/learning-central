package me.github.fwfurtado.lc.graphql.classes;

import me.github.fwfurtado.lc.domain.models.CourseClass;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseClassRepository extends Repository<CourseClass, UUID> {
    List<CourseClass> findAll();
    Optional<CourseClass> findById(UUID id);
}
