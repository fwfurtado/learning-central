package me.github.fwfurtado.lc.graphql.instructor;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import me.github.fwfurtado.lc.domain.models.Instructor;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.Optional;

@Component
@AllArgsConstructor
public class InstructorMutationResolver implements GraphQLMutationResolver {

    private final InstructorService service;

    public Instructor addInstructor(@Valid AddInstructorForm form) {
        var instructor = service.register(form);

        return instructor;
    }

}
