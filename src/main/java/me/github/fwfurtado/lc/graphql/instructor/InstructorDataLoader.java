package me.github.fwfurtado.lc.graphql.instructor;

import lombok.AllArgsConstructor;
import me.github.fwfurtado.lc.domain.models.Course;
import me.github.fwfurtado.lc.domain.models.Instructor;
import me.github.fwfurtado.lc.graphql.configuration.DataLoaderWrapper;
import org.dataloader.BatchLoader;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Configuration
@AllArgsConstructor
public class InstructorDataLoader implements DataLoaderWrapper<UUID, Instructor> {
    public static final String NAME = "instructor_data_loader";

    private final InstructorRepository repository;

    @Override
    public BatchLoader<UUID, Instructor> supplyBatchLoader() {
        return keys -> CompletableFuture.supplyAsync( () -> repository.findAllByIdIn(keys) );
    }

    @Override
    public String getName() {
        return NAME;
    }
}
