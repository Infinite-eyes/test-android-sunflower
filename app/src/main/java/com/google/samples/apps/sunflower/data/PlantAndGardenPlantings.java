package com.google.samples.apps.sunflower.data;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.annotation.Retention;
import java.util.ArrayList;
import java.util.List;

import androidx.room.Embedded;
import androidx.room.Relation;
import kotlin.jvm.internal.Intrinsics;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/2 2:00 PM
 **/
public class PlantAndGardenPlantings {

    @Embedded
    private Plant plant;


    @Relation(parentColumn = "id", entityColumn = "plant_id")
    private List gardenPlantings;

    public final Plant getPlant() {
        return this.plant;
    }

    public final void setPlant(Plant var1) {
        this.plant = var1;
    }

    public final List getGardenPlantings() {
        return this.gardenPlantings;
    }

    public final void setGardenPlantings(List gardenPlantings) {
        this.gardenPlantings = gardenPlantings;
    }

    public PlantAndGardenPlantings() {
        ArrayList gardenPlantings = new ArrayList();
        this.gardenPlantings = (List)gardenPlantings;
    }
}
