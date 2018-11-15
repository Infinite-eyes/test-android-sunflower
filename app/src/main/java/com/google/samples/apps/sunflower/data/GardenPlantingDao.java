package com.google.samples.apps.sunflower.data;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/3 3:40 PM
 **/
@Dao
public interface GardenPlantingDao {


    @Query("SELECT * FROM garden_plantings")
    @NotNull
    LiveData<List<GardenPlanting>> getGardenPlantings();

    @Query("SELECT * FROM garden_plantings WHERE id = :gardenPlantingId")
    @NotNull
    LiveData<GardenPlanting> getGardenPlanting(long gardenPlantingId);

    @Query("SELECT * FROM garden_plantings WHERE plant_id = :plantId")
    @NotNull
    LiveData<GardenPlanting> getGardenPlantingForPlant(@NotNull String plantId);

    @Transaction
    @Query("SELECT * FROM plants")
    @NotNull
    LiveData<List<PlantAndGardenPlantings>> getPlantAndGardenPlantings();

    @Insert
    Long insertGardenPlanting(@NotNull GardenPlanting gardenPlanting);

    @Delete
    void deleteGardenPlanting(@NotNull GardenPlanting gardenPlanting);


}
