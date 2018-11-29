package com.google.samples.apps.sunflower.viewmodels;

import com.google.samples.apps.sunflower.data.PlantRepository;

import org.jetbrains.annotations.NotNull;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/15 6:22 PM
 **/
public final class PlantListViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final PlantRepository repository;

    public PlantListViewModelFactory(@NotNull PlantRepository repository) {
        this.repository = repository;
    }

    public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
        return (T) new PlantListViewModel(this.repository);
    }


}
