package me.github.fwfurtado.lc.graphql.configuration;

import org.dataloader.DataLoaderRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataLoaderRegistryConfiguration {

    @Bean
    DataLoaderRegistry dataLoaderRegistry(List<DataLoaderWrapper<?, ?>> wrappers) {
      var dataLoaderRegistry = new DataLoaderRegistry();

      wrappers.forEach(wrapper -> dataLoaderRegistry.register(wrapper.getName(), wrapper.getDataLoader()));

      return dataLoaderRegistry;
    }
}
