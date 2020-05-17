package me.github.fwfurtado.lc.graphql.instructor;

import lombok.AllArgsConstructor;
import me.github.fwfurtado.lc.domain.models.Instructor;
import org.springframework.stereotype.Service;

import java.net.http.HttpHeaders;
import java.util.Optional;

@Service
@AllArgsConstructor
public class InstructorService {

    private final InstructorRepository repository;
    private final AddInstructorMapper mapper;

    public Instructor register(AddInstructorForm form) {

        var instructor = mapper.map(form);

        repository.save(instructor);

        return instructor;
    }
}
