package me.github.fwfurtado.lc.graphql.classes;

import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import lombok.AllArgsConstructor;
import lombok.Getter;
import me.github.fwfurtado.lc.domain.models.Student;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@AllArgsConstructor
public class ClassSubscriptionResolver implements GraphQLSubscriptionResolver {

    private final Flux<StudentRegisteredEvent> newStudentRegisteredFlux;

    Publisher<StudentRegisteredEvent> listenerNewStudentsIn(UUID classId) {
        return newStudentRegisteredFlux
                    .filter( event -> classId.equals(event.getClassId()) );
    }

    @Getter
    @AllArgsConstructor
    static class StudentRegisteredEvent {
        private final LocalDateTime when = LocalDateTime.now();
        private UUID classId;
        private Student student;
    }
}
