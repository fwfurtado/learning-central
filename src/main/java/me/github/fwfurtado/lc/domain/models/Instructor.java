package me.github.fwfurtado.lc.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PACKAGE;

@Entity
@Getter
@NoArgsConstructor(access = PACKAGE)
public class Instructor {
    @Id
    @GeneratedValue(strategy = AUTO)
    private UUID id;
    private String name;
    private String email;

    public Instructor(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
