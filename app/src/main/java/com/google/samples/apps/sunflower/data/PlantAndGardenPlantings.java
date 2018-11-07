package com.google.samples.apps.sunflower.data;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import androidx.room.Embedded;
import androidx.room.Relation;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/2 2:00 PM
 **/
public class PlantAndGardenPlantings {

    @Embedded
    @Nullable
    private Plant plant;


    @Relation(parentColumn = "id", entityColumn = "plant_id")
    @NotNull
    private List gardenPlantings;

    @Nullable
    public final Plant getPlant() {
        return this.plant;
    }

    public final void setPlant(@Nullable Plant plant) {
        this.plant = plant;
    }

    @NotNull
    public final List getGardenPlantings() {
        return this.gardenPlantings;
    }

    public final void setGardenPlantings(@NotNull List gardenPlantings) {
        this.gardenPlantings = gardenPlantings;
    }

    public PlantAndGardenPlantings() {
        ArrayList gardenPlantings = new ArrayList();
        this.gardenPlantings = (List) gardenPlantings;
    }




}
