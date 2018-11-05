package com.google.samples.apps.sunflower.data;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.lifecycle.LiveData;
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
public interface GardenPlantingDao {


    @Query("SELECT * FROM garden_plantings")
    LiveData getGardenPlantings();

    @Query("SELECT * FROM garden_plantings WHERE id = :gardenPlantingId")
    LiveData<GardenPlanting> getGardenPlanting(long gardenPlantingId);

    @Query("SELECT * FROM garden_plantings WHERE plant_id = :plantId")
    LiveData<GardenPlanting> getGardenPlantingForPlant(String plantId);

    @Transaction
    @Query("SELECT * FROM plants")
    LiveData<List<PlantAndGardenPlantings>> getPlantAndGardenPlantings();

    @Insert
    Long insertGardenPlanting(GardenPlanting gardenPlanting);

    @Delete
    void deleteGardenPlanting(GardenPlanting gardenPlanting);

}
