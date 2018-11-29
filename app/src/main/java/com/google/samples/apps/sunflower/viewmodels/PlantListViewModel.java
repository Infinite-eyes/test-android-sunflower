package com.google.samples.apps.sunflower.viewmodels;

import com.google.samples.apps.sunflower.data.Plant;
import com.google.samples.apps.sunflower.data.PlantRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/26 10:09 AM
 **/
public class PlantListViewModel extends ViewModel {

    private static final int NO_GROW_ZONE = -1;

    private final MutableLiveData<Integer> growZoneNumber = new MutableLiveData<>();
    private final MediatorLiveData<List<Plant>> plantList = new MediatorLiveData<>();
    public final PlantRepository plantRepository;


    public PlantListViewModel(@NotNull PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
        this.growZoneNumber.setValue(NO_GROW_ZONE);
        this.plantList.addSource(Transformations.switchMap(this.growZoneNumber, new Function<Integer, LiveData<List<Plant>>>() {
            @Override
            public LiveData<List<Plant>> apply(Integer integer) {
                if (integer != null && integer.intValue() == -1) {
                    return plantRepository.getPlants();
                } else {
                    return plantRepository.getPlantsWithGrowZoneNumber(integer);
                }
            }
        }), list -> plantList.setValue(list));
    }


    public final MediatorLiveData<List<Plant>> getPlants() {
        return this.plantList;
    }

    public final void setGrowZoneNumber(int num) {
        this.growZoneNumber.setValue(Integer.valueOf(num));
    }

    public final void clearGrowZoneNumber() {
        this.growZoneNumber.setValue(Integer.valueOf(NO_GROW_ZONE));
    }

    public final boolean isFiltered() {
        Integer num = this.growZoneNumber.getValue();
        return num == null || num.intValue() != -1;
    }


}
