package com.google.samples.apps.sunflower.viewmodels;

import com.google.samples.apps.sunflower.data.GardenPlanting;
import com.google.samples.apps.sunflower.data.GardenPlantingRepository;
import com.google.samples.apps.sunflower.data.PlantAndGardenPlantings;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/5 10:48 AM
 **/
public class GardenPlantingListViewModel extends ViewModel {

    @NotNull
    private final LiveData<List<GardenPlanting>> gardenPlantings;
    @NotNull
    private final LiveData<List<PlantAndGardenPlantings>> plantAndGardenPlantings;

    @NotNull
    public final LiveData<List<GardenPlanting>> getGardenPlantings() {
        return this.gardenPlantings;
    }

    @NotNull
    public final LiveData<List<PlantAndGardenPlantings>> getPlantAndGardenPlantings() {
        return this.plantAndGardenPlantings;
    }

    public GardenPlantingListViewModel(@NotNull GardenPlantingRepository gardenPlantingRepository) {
        this.gardenPlantings = gardenPlantingRepository.getGardenPlantings();

        LiveData map = Transformations.map(gardenPlantingRepository.getPlantAndGardenPlantings(), new Function<List<PlantAndGardenPlantings>, List<PlantAndGardenPlantings>>() {
            @Override
            public List<PlantAndGardenPlantings> apply(List<PlantAndGardenPlantings> plantings) {

                Collection collection = new ArrayList();
                for (PlantAndGardenPlantings element : plantings) {
                    if (!element.getGardenPlantings().isEmpty()) {
                        collection.add(element);
                    }
                }
                return (List<PlantAndGardenPlantings>) collection;
            }
        });
        this.plantAndGardenPlantings = map;
    }

}
