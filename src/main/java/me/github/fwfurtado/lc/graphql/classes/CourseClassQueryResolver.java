package me.github.fwfurtado.lc.graphql.classes;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.github.fwfurtado.lc.domain.models.Course;
import me.github.fwfurtado.lc.domain.models.CourseClass;
import me.github.fwfurtado.lc.domain.models.Instructor;
import me.github.fwfurtado.lc.graphql.courses.CourseDataLoader;
import me.github.fwfurtado.lc.graphql.instructor.InstructorDataLoader;
import org.dataloader.DataLoader;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import static java.util.Objects.nonNull;

@Component
@AllArgsConstructor
@Slf4j
public class CourseClassQueryResolver {
    private final CourseClassRepository repository;

    @Component
    class RootQuery implements GraphQLQueryResolver {

        List<CourseClass> classes(UUID id) {
            if (nonNull(id)) {
                return repository.findById(id).map(List::of).orElseGet(Collections::emptyList);
            }

            return repository.findAll();
        }

    }

    @Component
    class Resolvers implements GraphQLResolver<CourseClass> {

        CompletableFuture<Course> course(CourseClass courseClass, DataFetchingEnvironment environment) {
            DataLoader<UUID, Course> dataLoader = environment.getDataLoader(CourseDataLoader.NAME);
            return dataLoader.load(courseClass.getCourseId());
        }

        CompletableFuture<Instructor> instructor(CourseClass courseClass, DataFetchingEnvironment environment) {
            DataLoader<UUID, Instructor> dataLoader = environment.getDataLoader(InstructorDataLoader.NAME);
            return dataLoader.load(courseClass.getInstructorId());
        }


    }
}