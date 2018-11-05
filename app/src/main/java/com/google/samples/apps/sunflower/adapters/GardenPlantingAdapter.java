package com.google.samples.apps.sunflower.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.google.samples.apps.sunflower.R;
import com.google.samples.apps.sunflower.data.PlantAndGardenPlantings;
import com.google.samples.apps.sunflower.databinding.ListItemGardenPlantingBinding;
import com.google.samples.apps.sunflower.viewmodels.PlantAndGardenPlantingsViewModel;


import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/2 1:50 PM
 **/
public class GardenPlantingAdapter extends ListAdapter<PlantAndGardenPlantings, GardenPlantingAdapter.ViewHolder> {

    private final Context context;


    public GardenPlantingAdapter( Context context) {
        super(new GardenPlantDiffCallback());
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_item_garden_planting, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PlantAndGardenPlantings plantings = getItem(position);
        holder.itemView.setTag(plantings);
        holder.bind(plantings);
    }

    public static final class ViewHolder extends RecyclerView.ViewHolder {

        private final ListItemGardenPlantingBinding binding;

        private final void bind( PlantAndGardenPlantings plantings) {
            this.binding.setViewModel(new PlantAndGardenPlantingsViewModel(this.itemView.getContext(), plantings));
            this.binding.executePendingBindings();
        }


        public ViewHolder( ListItemGardenPlantingBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
