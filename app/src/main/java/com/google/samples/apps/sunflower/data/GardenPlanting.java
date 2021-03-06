package com.google.samples.apps.sunflower.data;


import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/2 2:53 PM
 **/
@Entity(
        tableName = "garden_plantings",
        foreignKeys = {@ForeignKey(
                entity = Plant.class,
                childColumns = {"plant_id"},
                parentColumns = {"id"}
        )},
        indices = {@Index({"plant_id"})}
)
public final class GardenPlanting {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @NonNull
    private long gardenPlantingId;

    @ColumnInfo(name = "plant_id")
    @NotNull
    private final String plantId;

    @ColumnInfo(name = "plant_date")
    @NotNull
    private final Calendar plantDate;

    @ColumnInfo(name = "last_watering_date")
    @NotNull
    private final Calendar lastWateringDate;

    public GardenPlanting(@NotNull String plantId, @NotNull Calendar plantDate, @NotNull Calendar lastWateringDate) {
        this.plantId = plantId;
        this.plantDate = plantDate;
        this.lastWateringDate = lastWateringDate;
    }

    public long getGardenPlantingId() {
        return gardenPlantingId;
    }

    public void setGardenPlantingId(long gardenPlantingId) {
        this.gardenPlantingId = gardenPlantingId;
    }

    @NotNull
    public String getPlantId() {
        return plantId;
    }

    @NotNull
    public Calendar getPlantDate() {
        return plantDate;
    }

    @NotNull
    public Calendar getLastWateringDate() {
        return lastWateringDate;
    }






}
