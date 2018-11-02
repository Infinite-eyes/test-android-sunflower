package com.google.samples.apps.sunflower.adapters;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/2 1:54 PM
 **/
public class GardenPlantDiffCallback extends DiffUtil.ItemCallback {


    @Override
    public boolean areItemsTheSame(@NonNull Object oldItem, @NonNull Object newItem) {
//        oldItem.getP


        return false;
    }

    @Override
    public boolean areContentsTheSame(@NonNull Object oldItem, @NonNull Object newItem) {
        return false;
    }
}
