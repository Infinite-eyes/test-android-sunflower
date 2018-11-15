package com.google.samples.apps.sunflower.data;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;
import java.util.List;

import androidx.lifecycle.LiveData;


/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/3 3:39 PM
 **/
public final class GardenPlantingRepository {

    private final GardenPlantingDao gardenPlantingDao;
    private static volatile GardenPlantingRepository instance;
    public static final GardenPlantingRepository.Companion Companion = new GardenPlantingRepository.Companion();

    private GardenPlantingRepository(GardenPlantingDao gardenPlantingDao) {
        this.gardenPlantingDao = gardenPlantingDao;
    }

    public final void createGardenPlanting(@NotNull String plantId) {
        AppExecutors.runOnIoThread(() -> GardenPlantingRepository.this.gardenPlantingDao.insertGardenPlanting(new GardenPlanting(plantId, Calendar.getInstance(), Calendar.getInstance())));
    }

    public final void removeGardenPlanting(@NotNull GardenPlanting gardenPlanting) {
        AppExecutors.runOnIoThread(new Runnable() {
            @Override
            public void run() {
                GardenPlantingRepository.this.gardenPlantingDao.deleteGardenPlanting(gardenPlanting);
            }
        });
    }

    @NotNull
    public final LiveData<GardenPlanting> getGardenPlantingForPlant(@NotNull String plantId) {
        return this.gardenPlantingDao.getGardenPlantingForPlant(plantId);
    }

    @NotNull
    public final LiveData<List<GardenPlanting>> getGardenPlantings() {
        return this.gardenPlantingDao.getGardenPlantings();
    }

    @NotNull
    public final LiveData<List<PlantAndGardenPlantings>> getPlantAndGardenPlantings() {
        return this.gardenPlantingDao.getPlantAndGardenPlantings();
    }


    public static final class Companion {

        @NotNull
        public final GardenPlantingRepository getInstance(@NotNull GardenPlantingDao gardenPlantingDao) {
            if (GardenPlantingRepository.instance == null) {
                synchronized (this) {
                    if (GardenPlantingRepository.instance == null) {
                        GardenPlantingRepository.instance = new GardenPlantingRepository(gardenPlantingDao);
                    }
                }
            }
            return GardenPlantingRepository.instance;
        }

    }

}
