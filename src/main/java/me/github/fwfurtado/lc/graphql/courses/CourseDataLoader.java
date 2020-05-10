package me.github.fwfurtado.lc.graphql.courses;

import lombok.AllArgsConstructor;
import me.github.fwfurtado.lc.domain.models.Course;
import me.github.fwfurtado.lc.graphql.configuration.DataLoaderWrapper;
import org.dataloader.BatchLoader;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Configuration
@AllArgsConstructor
public class CourseDataLoader  implements DataLoaderWrapper<UUID, Course> {
    public static final String NAME = "course_data_loader";

    private final CourseRepository repository;

    @Override
    public BatchLoader<UUID, Course> supplyBatchLoader() {
        return keys -> CompletableFuture.supplyAsync( () -> repository.findAllByIdIn(keys) );
    }

    @Override
    public String getName() {
        return NAME;
    }
}
