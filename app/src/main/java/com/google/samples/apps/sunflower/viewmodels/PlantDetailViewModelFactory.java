package com.google.samples.apps.sunflower.viewmodels;

import com.google.samples.apps.sunflower.data.GardenPlantingRepository;
import com.google.samples.apps.sunflower.data.PlantRepository;

import org.jetbrains.annotations.NotNull;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/29 4:07 PM
 **/
public class PlantDetailViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final GardenPlantingRepository gardenPlantingRepository;
    private final String plantId;
    private final PlantRepository plantRepository;

    public PlantDetailViewModelFactory(@NotNull PlantRepository plantRepository, @NotNull GardenPlantingRepository gardenPlantingRepository, @NotNull String plantId) {
        this.plantRepository = plantRepository;
        this.gardenPlantingRepository = gardenPlantingRepository;
        this.plantId = plantId;
    }


    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new PlantDetailViewModel(this.plantRepository, this.gardenPlantingRepository, this.plantId);
    }


}
