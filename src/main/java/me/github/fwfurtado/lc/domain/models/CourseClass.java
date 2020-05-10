package me.github.fwfurtado.lc.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PACKAGE;

@Entity
@Getter
@NoArgsConstructor(access = PACKAGE)
public class CourseClass {

    @Id
    @GeneratedValue(strategy = AUTO)
    private UUID id;

    private LocalDateTime start;

    private UUID courseId;

    private UUID instructorId;

}
