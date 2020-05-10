package me.github.fwfurtado.lc.graphql.configuration;

import org.dataloader.BatchLoader;
import org.dataloader.DataLoader;

public interface DataLoaderWrapper<K, V> {
    BatchLoader<K, V> supplyBatchLoader();

    String getName();

    default DataLoader<K, V> getDataLoader() {
        return DataLoader.newDataLoader(supplyBatchLoader());
    }
}
