package com.google.samples.apps.sunflower.adapters;

import com.google.samples.apps.sunflower.data.PlantAndGardenPlantings;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/2 1:54 PM
 **/
public class GardenPlantDiffCallback extends DiffUtil.ItemCallback<PlantAndGardenPlantings> {


    @Override
    public boolean areItemsTheSame(@NonNull PlantAndGardenPlantings oldItem, @NonNull PlantAndGardenPlantings newItem) {
        return oldItem.getPlant().plantId == newItem.getPlant().plantId;
    }

    @Override
    public boolean areContentsTheSame(@NonNull PlantAndGardenPlantings oldItem, @NonNull PlantAndGardenPlantings newItem) {
        return oldItem.getPlant() == newItem.getPlant();
    }
}
