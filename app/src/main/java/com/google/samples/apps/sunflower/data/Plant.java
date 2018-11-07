package com.google.samples.apps.sunflower.data;


import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import static java.util.Calendar.DAY_OF_YEAR;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/2 2:01 PM
 **/
@Entity(tableName = "plants")
public class Plant {
    @PrimaryKey
    @ColumnInfo(name = "id")
    @NonNull
    public final String plantId;
    @NonNull
    public final String name;
    @NonNull
    public final String description;
    @NonNull
    public final int growZoneNumber;
    @NonNull
    public final int wateringInterval;
    @NonNull
    public final String imageUrl;

    public Plant(@NonNull String plantId, String name, String description, int growZoneNumber, int wateringInterval, String imageUrl) {
        super();
        this.plantId = plantId;
        this.name = name;
        this.description = description;
        this.growZoneNumber = growZoneNumber;
        this.wateringInterval = wateringInterval;
        this.imageUrl = imageUrl;
    }

    public final boolean shouldBeWatered(Calendar since, Calendar lastWateringDate) {
        lastWateringDate.add(DAY_OF_YEAR, this.wateringInterval);
        return since.compareTo(lastWateringDate) > 0;
    }


    public String toString() {
        return this.name;
    }

    @NonNull
    public String getPlantId() {
        return plantId;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    @NonNull
    public int getGrowZoneNumber() {
        return growZoneNumber;
    }

    @NonNull
    public int getWateringInterval() {
        return wateringInterval;
    }

    @NonNull
    public String getImageUrl() {
        return imageUrl;
    }






}
