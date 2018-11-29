package com.google.samples.apps.sunflower.adapters;

import com.google.samples.apps.sunflower.data.Plant;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/28 6:09 PM
 **/
public class PlantDiffCallback extends DiffUtil.ItemCallback<Plant> {


    @Override
    public boolean areItemsTheSame(@NonNull Plant oldItem, @NonNull Plant newItem) {
        return oldItem.getPlantId() == newItem.getPlantId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull Plant oldItem, @NonNull Plant newItem) {
        return oldItem == newItem;
    }
}
