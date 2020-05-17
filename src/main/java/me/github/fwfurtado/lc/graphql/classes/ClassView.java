package me.github.fwfurtado.lc.graphql.classes;

import java.time.LocalDateTime;
import java.util.UUID;

public interface ClassView {
    UUID getId();

    LocalDateTime getStart();

    UUID getCourseId();

    UUID getInstructorId();
}
