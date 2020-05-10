package me.github.fwfurtado.lc.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.Duration;
import java.util.UUID;

import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PACKAGE;

@Entity
@Getter
@NoArgsConstructor(access = PACKAGE)
public class Course {

    @Id
    @GeneratedValue(strategy = AUTO)
    private UUID id;

    private String code;
    private String name;
    private String description;
    private Duration workload;

    public Course(String code, String name, String description, Duration workload) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.workload = workload;
    }
}
