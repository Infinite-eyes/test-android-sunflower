package com.google.samples.apps.sunflower;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;
import com.google.samples.apps.sunflower.data.Plant;
import com.google.samples.apps.sunflower.utilities.InjectorUtils;
import com.google.samples.apps.sunflower.viewmodels.PlantDetailViewModel;
import com.google.samples.apps.sunflower.viewmodels.PlantDetailViewModelFactory;
import com.google.samples.apps.sunflower.databinding.FragmentPlantDetailBinding;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ShareCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/29 2:29 PM
 **/
public class PlantDetailFragment extends Fragment {

    private String shareText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        String plantId = PlantDetailFragmentArgs.fromBundle(getArguments()).getPlantId();

        PlantDetailViewModelFactory factory = InjectorUtils.INSTANCE.providePlantDetailViewModelFactory(requireContext(), plantId);
        PlantDetailViewModel plantDetailViewModel = ViewModelProviders.of(this, factory).get(PlantDetailViewModel.class);

        FragmentPlantDetailBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_plant_detail, container, false);
        binding.setViewModel(plantDetailViewModel);
        binding.setLifecycleOwner(this);
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plantDetailViewModel.addPlantToGarden();
                Snackbar.make(v, R.string.added_plant_to_garden, Snackbar.LENGTH_LONG).show();
            }
        });


        plantDetailViewModel.getPlant().observe(this, new Observer<Plant>() {
            @Override
            public void onChanged(Plant plant) {
                if (plant == null) {
                    shareText = "";
                } else {
                    shareText = getString(R.string.share_text_plant, plant.getName());
                }
            }
        });
        setHasOptionsMenu(true);

        return binding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        if (inflater != null) {
            inflater.inflate(R.menu.menu_plant_detail, menu);
        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Integer valueOf = item != null ? Integer.valueOf(item.getItemId()) : null;
        if (valueOf == null || valueOf.intValue() != R.id.action_share) {
            return super.onOptionsItemSelected(item);
        }

        Intent shareIntent = ShareCompat.IntentBuilder.from(getActivity())
                .setText(this.shareText)
                .setType("text/plain")
                .createChooserIntent();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            shareIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        } else {
            shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        }

        startActivity(shareIntent);
        return true;
    }
}
