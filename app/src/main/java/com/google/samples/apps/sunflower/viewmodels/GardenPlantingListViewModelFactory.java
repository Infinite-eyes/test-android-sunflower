package com.google.samples.apps.sunflower.viewmodels;

import com.google.samples.apps.sunflower.data.GardenPlantingRepository;

import org.jetbrains.annotations.NotNull;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/3 3:37 PM
 **/
public class GardenPlantingListViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final GardenPlantingRepository repository;

    @NotNull
    public ViewModel create(@NotNull Class modelClass) {
        return new GardenPlantingListViewModel(this.repository);
    }

    public GardenPlantingListViewModelFactory(@NotNull GardenPlantingRepository repository) {
        this.repository = repository;
    }

}
