package com.google.samples.apps.sunflower.data;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/5 2:13 PM
 **/
@Dao
public interface PlantDao {

    @Query("SELECT * FROM plants ORDER BY name")
    @NotNull
    LiveData<List<Plant>> getPlants();

    @Query("SELECT * FROM plants WHERE growZoneNumber = :growZoneNumber ORDER BY name")
    @NotNull
    LiveData<List<Plant>> getPlantsWithGrowZoneNumber(int growZoneNumber);

    @Query("SELECT * FROM plants WHERE id = :plantId")
    @NotNull
    LiveData<Plant> getPlant(@NotNull String plantId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     void insertAll(@NotNull List<Plant> plants);

}
