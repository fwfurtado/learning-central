package me.github.fwfurtado.lc.graphql.instructor;

import me.github.fwfurtado.lc.domain.models.Instructor;
import me.github.fwfurtado.lc.infra.Mapper;
import org.springframework.stereotype.Component;

@Component
public class AddInstructorMapper implements Mapper<AddInstructorForm, Instructor> {

    public Instructor map(AddInstructorForm form) {
        return new Instructor(form.getName(), form.getEmail());
    }
}
