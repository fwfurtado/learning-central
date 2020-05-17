package me.github.fwfurtado.lc.graphql.classes;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.GraphQLResolver;
import graphql.relay.Connection;
import graphql.relay.SimpleListConnection;
import graphql.schema.DataFetchingEnvironment;
import javassist.Loader;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.github.fwfurtado.lc.domain.models.Course;
import me.github.fwfurtado.lc.domain.models.Instructor;
import me.github.fwfurtado.lc.graphql.courses.CourseDataLoader;
import me.github.fwfurtado.lc.graphql.instructor.InstructorDataLoader;
import org.dataloader.DataLoader;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Component
@AllArgsConstructor
@Slf4j
public class CourseClassQueryResolver {
    private final CourseClassRepository repository;

    @Component
    class RootQuery implements GraphQLQueryResolver {

        Connection<ClassView> classes(UUID id, int first, String after, DataFetchingEnvironment environment) {
            if (nonNull(id)) {
                var singletonList = repository.readCourseClassById(id).map(Collections::singletonList).orElseGet(Collections::emptyList);
                return new SimpleListConnection<>(singletonList).get(environment);
            }

            List<ClassView> allClasses;

            if (first > 0)
                allClasses = repository.loadAllClasses().stream().limit(first).collect(Collectors.toList());
            else
                allClasses = repository.loadAllClasses();

            return new SimpleListConnection<>(allClasses).get(environment);
        }

    }

    @Component
    class Resolvers implements GraphQLResolver<ClassView> {

        CompletableFuture<Course> course(ClassView courseClass, DataFetchingEnvironment environment) {
            DataLoader<UUID, Course> dataLoader = environment.getDataLoader(CourseDataLoader.NAME);
            return dataLoader.load(courseClass.getCourseId());
        }

        CompletableFuture<Instructor> instructor(ClassView courseClass, DataFetchingEnvironment environment) {
            DataLoader<UUID, Instructor> dataLoader = environment.getDataLoader(InstructorDataLoader.NAME);
            return dataLoader.load(courseClass.getInstructorId());
        }


    }
}