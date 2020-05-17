package me.github.fwfurtado.lc.graphql.classes;

import me.github.fwfurtado.lc.domain.models.Instructor;

import java.util.Optional;
import java.util.UUID;

public interface FindInstructorById {
    Optional<Instructor> findById(UUID id);
}
