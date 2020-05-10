package me.github.fwfurtado.lc.graphql.instructor;

import me.github.fwfurtado.lc.domain.models.Instructor;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InstructorRepository extends Repository<Instructor, UUID> {
    List<Instructor> findAll();

    Optional<Instructor> findById(UUID id);

    List<Instructor> findAllByIdIn(List<UUID> keys);
}
