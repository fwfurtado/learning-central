package me.github.fwfurtado.lc.graphql.configuration;

import graphql.schema.GraphQLScalarType;
import me.github.fwfurtado.lc.graphql.types.DateTimeCoercing;
import me.github.fwfurtado.lc.graphql.types.DurationCoercing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Configuration
public class ScalarTypesConfiguration {

    @Bean
    GraphQLScalarType durationScalar(DurationCoercing durationCoercing) {

        return GraphQLScalarType.newScalar()
                .name("Duration")
                .coercing(durationCoercing)
                .build();
    }

    @Bean
    GraphQLScalarType dateTimeScalar(DateTimeCoercing dateTimeCoercing) {
        return GraphQLScalarType.newScalar()
                .name("DateTime")
                .coercing(dateTimeCoercing)
                .build();
    }

}
