package com.google.samples.apps.sunflower;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.samples.apps.sunflower.adapters.PlantAdapter;
import com.google.samples.apps.sunflower.data.Plant;
import com.google.samples.apps.sunflower.databinding.FragmentPlantListBinding;
import com.google.samples.apps.sunflower.utilities.InjectorUtils;
import com.google.samples.apps.sunflower.viewmodels.PlantListViewModel;
import com.google.samples.apps.sunflower.viewmodels.PlantListViewModelFactory;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/15 6:11  PM
 **/
public class PlantListFragment extends Fragment {

    private PlantListViewModel viewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentPlantListBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_plant_list, container, false);

        PlantListViewModelFactory factory = InjectorUtils.INSTANCE.providePlantListViewModelFactory(requireContext());
        viewModel = ViewModelProviders.of(this, factory).get(PlantListViewModel.class);

        PlantAdapter adapter = new PlantAdapter();
        binding.plantList.setAdapter(adapter);
        subscribeUi(adapter);
        setHasOptionsMenu(true);
        return binding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        if (inflater != null) {
            inflater.inflate(R.menu.menu_plant_list, menu);
        }
    }

    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        if (item.getItemId() != R.id.filter_zone) {
            return super.onOptionsItemSelected(item);
        }
        updateData();
        return true;
    }

    private void subscribeUi(PlantAdapter adapter) {

        viewModel.getPlants().observe(getViewLifecycleOwner(), new Observer<List<Plant>>() {
            @Override
            public void onChanged(List<Plant> plants) {
                if (plants != null) {
                    adapter.submitList(plants);
                }
            }
        });
    }

    private final void updateData() {

        if (viewModel.isFiltered()) {
            viewModel.clearGrowZoneNumber();
        } else {
            viewModel.setGrowZoneNumber(9);
        }


    }


}
