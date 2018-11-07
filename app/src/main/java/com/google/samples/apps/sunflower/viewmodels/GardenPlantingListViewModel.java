package com.google.samples.apps.sunflower.viewmodels;

import com.google.samples.apps.sunflower.data.GardenPlantingRepository;

import org.jetbrains.annotations.NotNull;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/5 10:48 AM
 **/
public class GardenPlantingListViewModel extends ViewModel {

    @NotNull
    private final LiveData gardenPlantings;
    @NotNull
    private final LiveData plantAndGardenPlantings;

    @NotNull
    public final LiveData getGardenPlantings() {
        return this.gardenPlantings;
    }

    @NotNull
    public final LiveData getPlantAndGardenPlantings() {
        return this.plantAndGardenPlantings;
    }


    public GardenPlantingListViewModel(@NotNull GardenPlantingRepository gardenPlantingRepository) {
        this.gardenPlantings = gardenPlantingRepository.getGardenPlantings();
//        LiveData liveData = Transformations.map(gardenPlantingRepository.getPlantAndGardenPlantings(), { plantings ->{
//        }});

        LiveData liveData = gardenPlantingRepository.getPlantAndGardenPlantings();

        this.plantAndGardenPlantings = liveData;
    }

}
