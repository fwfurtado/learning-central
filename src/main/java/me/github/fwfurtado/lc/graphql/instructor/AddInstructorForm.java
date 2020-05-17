package me.github.fwfurtado.lc.graphql.instructor;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class AddInstructorForm {
    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;
}
