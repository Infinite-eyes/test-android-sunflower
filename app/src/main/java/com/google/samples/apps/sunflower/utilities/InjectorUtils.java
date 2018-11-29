package com.google.samples.apps.sunflower.utilities;

import android.content.Context;

import com.google.samples.apps.sunflower.data.AppDatabase;
import com.google.samples.apps.sunflower.data.GardenPlantingRepository;
import com.google.samples.apps.sunflower.data.PlantRepository;
import com.google.samples.apps.sunflower.viewmodels.GardenPlantingListViewModelFactory;
import com.google.samples.apps.sunflower.viewmodels.PlantDetailViewModel;
import com.google.samples.apps.sunflower.viewmodels.PlantDetailViewModelFactory;
import com.google.samples.apps.sunflower.viewmodels.PlantListViewModelFactory;

import org.jetbrains.annotations.NotNull;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/5 1:51 PM
 **/
public final class InjectorUtils {

    public static final InjectorUtils INSTANCE = new InjectorUtils();

    private final GardenPlantingRepository getGardenPlantingRepository(Context context) {
        return GardenPlantingRepository.Companion.getInstance(AppDatabase.Companion.getInstance(context).gardenPlantingDao());
    }

    public final GardenPlantingListViewModelFactory provideGardenPlantingListViewModelFactory(Context context) {
        GardenPlantingRepository repository = this.getGardenPlantingRepository(context);
        return new GardenPlantingListViewModelFactory(repository);
    }

    private final PlantRepository getPlantRepository(Context context) {
        return PlantRepository.Companion.getInstance(AppDatabase.Companion.getInstance(context).plantDao());
    }

    public final PlantListViewModelFactory providePlantListViewModelFactory(Context context) {
        return new PlantListViewModelFactory(getPlantRepository(context));
    }


    public final PlantDetailViewModelFactory providePlantDetailViewModelFactory(@NotNull Context context, @NotNull String plantId) {
        return new PlantDetailViewModelFactory(getPlantRepository(context), getGardenPlantingRepository(context), plantId);
    }


}
