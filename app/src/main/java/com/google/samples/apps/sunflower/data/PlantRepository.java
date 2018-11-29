package com.google.samples.apps.sunflower.data;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.lifecycle.LiveData;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/15 6:24 PM
 **/
public final class PlantRepository {

    public static final PlantRepository.Companion Companion = new PlantRepository.Companion();
    private static volatile PlantRepository instance;
    private final PlantDao plantDao;

    private PlantRepository(PlantDao plantDao) {
        this.plantDao = plantDao;
    }


    public static final class Companion {
        public final PlantRepository getInstance(@NotNull PlantDao plantDao) {
            if (PlantRepository.instance == null) {
                synchronized (this) {
                    if (PlantRepository.instance == null) {
                        PlantRepository.instance = new PlantRepository(plantDao);
                    }
                }
            }
            return PlantRepository.instance;
        }
    }


    public final LiveData<List<Plant>> getPlants() {
        return this.plantDao.getPlants();
    }

    public final LiveData<Plant> getPlant(@NotNull String plantId) {
        return this.plantDao.getPlant(plantId);
    }

    public final LiveData<List<Plant>> getPlantsWithGrowZoneNumber(int growZoneNumber) {
        return this.plantDao.getPlantsWithGrowZoneNumber(growZoneNumber);
    }


}
