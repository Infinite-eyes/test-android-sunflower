package com.google.samples.apps.sunflower;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.samples.apps.sunflower.adapters.GardenPlantingAdapter;
import com.google.samples.apps.sunflower.databinding.FragmentGardenBinding;
import com.google.samples.apps.sunflower.utilities.InjectorUtils;
import com.google.samples.apps.sunflower.viewmodels.GardenPlantingListViewModel;
import com.google.samples.apps.sunflower.viewmodels.GardenPlantingListViewModelFactory;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/1 2:03 PM
 **/
public class GardenFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentGardenBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_garden, container, false);
        GardenPlantingAdapter adapter = new GardenPlantingAdapter(binding.getRoot().getContext());

        binding.gardenList.setAdapter(adapter);
        subscribeUi(adapter, binding);


        return binding.getRoot();
    }

    private final void subscribeUi(final GardenPlantingAdapter adapter, final FragmentGardenBinding binding) {
        GardenPlantingListViewModelFactory factory = InjectorUtils.INSTANCE.provideGardenPlantingListViewModelFactory(requireContext());
        GardenPlantingListViewModel viewModel = ViewModelProviders.of(this, factory).get(GardenPlantingListViewModel.class);

        viewModel.getGardenPlantings().observe(getViewLifecycleOwner(), plantings -> {

            boolean hasPlantings = false;
            if (plantings != null) {
                hasPlantings = !(((List) plantings).isEmpty());
            }
            binding.setHasPlantings(hasPlantings);
        });

        viewModel.getPlantAndGardenPlantings().observe(getViewLifecycleOwner(), result -> {
            if (result != null) {
                if (!(result.isEmpty())) {
                    adapter.submitList(result);
                }
            }
        });

    }


}
