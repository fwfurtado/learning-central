package me.github.fwfurtado.lc.graphql.classes;

import me.github.fwfurtado.lc.graphql.classes.ClassSubscriptionResolver.StudentRegisteredEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.FluxSink;

@Configuration
public class ClassSubscriptionConfiguration {

    @Bean
    DirectProcessor<StudentRegisteredEvent> directProcessor() {
        return DirectProcessor.create();
    }

    @Bean
    FluxSink<StudentRegisteredEvent> newStudentRegisteredFluxSink(DirectProcessor<StudentRegisteredEvent> processor) {
        return processor.sink();
    }

}

