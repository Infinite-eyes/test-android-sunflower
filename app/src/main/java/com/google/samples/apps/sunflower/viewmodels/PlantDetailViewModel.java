package com.google.samples.apps.sunflower.viewmodels;

import com.google.samples.apps.sunflower.data.GardenPlanting;
import com.google.samples.apps.sunflower.data.GardenPlantingRepository;
import com.google.samples.apps.sunflower.data.Plant;
import com.google.samples.apps.sunflower.data.PlantRepository;

import org.jetbrains.annotations.NotNull;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/29 2:46 PM
 **/
public class PlantDetailViewModel extends ViewModel {

    private final GardenPlantingRepository gardenPlantingRepository;

    private final LiveData<Boolean> isPlanted;

    private final LiveData<Plant> plant;

    private final String plantId;

    public PlantDetailViewModel(@NotNull PlantRepository plantRepository,
                                @NotNull GardenPlantingRepository gardenPlantingRepository,
                                @NotNull String plantId) {
        this.gardenPlantingRepository = gardenPlantingRepository;
        this.plantId = plantId;
        this.isPlanted = Transformations.map(this.gardenPlantingRepository.getGardenPlantingForPlant(this.plantId), new Function<GardenPlanting, Boolean>() {
            @Override
            public Boolean apply(GardenPlanting input) {
                if (input != null) {
                    return true;
                }
                return false;
            }
        });
        this.plant = plantRepository.getPlant(this.plantId);
    }

    @NotNull
    public final LiveData<Boolean> isPlanted() {
        return this.isPlanted;
    }

    @NotNull
    public final LiveData<Plant> getPlant() {
        return this.plant;
    }

    public final void addPlantToGarden() {
        this.gardenPlantingRepository.createGardenPlanting(this.plantId);
    }

}
