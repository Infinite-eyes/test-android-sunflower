package com.google.samples.apps.sunflower.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.google.samples.apps.sunflower.R;
import com.google.samples.apps.sunflower.data.Plant;
import com.google.samples.apps.sunflower.databinding.ListItemPlantBinding;

import org.jetbrains.annotations.NotNull;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/28 11:41 AM
 **/
public class PlantAdapter extends ListAdapter<Plant, PlantAdapter.ViewHolder> {

    public PlantAdapter() {
        super(new PlantDiffCallback());
    }


    protected PlantAdapter(@NonNull DiffUtil.ItemCallback<Plant> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_item_plant, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Plant plant = getItem(position);
        holder.bind(createOnClickListener(plant.getPlantId()), plant);
        holder.itemView.setTag(plant);
    }

    public static final class ViewHolder extends RecyclerView.ViewHolder {

        private final ListItemPlantBinding binding;

        public final void bind(@NotNull View.OnClickListener listener, @NotNull Plant item) {
            binding.setClickListener(listener);
            binding.setPlant(item);
            binding.executePendingBindings();
        }

        public ViewHolder(@NonNull ListItemPlantBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


    private final View.OnClickListener createOnClickListener(String plantId) {

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ActionPlantListFragmentToPlantDetailFragment direction = PlantListFragmentDirections.ActionPlantListFragmentToPlantDetailFragment(plantId)
//                ViewKt.findNavController(it).navigate((NavDirections) direction);
            }
        };

    }


}
