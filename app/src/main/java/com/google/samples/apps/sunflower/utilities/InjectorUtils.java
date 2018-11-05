package com.google.samples.apps.sunflower.utilities;

import android.content.Context;

import com.google.samples.apps.sunflower.data.AppDatabase;
import com.google.samples.apps.sunflower.data.GardenPlantingRepository;
import com.google.samples.apps.sunflower.viewmodels.GardenPlantingListViewModelFactory;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/5 1:51 PM
 **/
public final class InjectorUtils {

    static {
        InjectorUtils injectorUtils = new InjectorUtils();
        INSTANCE = injectorUtils;
    }

    public static final InjectorUtils INSTANCE;

    private final GardenPlantingRepository getGardenPlantingRepository(Context context) {
        return GardenPlantingRepository.Companion.getInstance(AppDatabase.Companion.getInstance(context).gardenPlantingDao());
    }

    public final GardenPlantingListViewModelFactory provideGardenPlantingListViewModelFactory(Context context) {
        GardenPlantingRepository repository = this.getGardenPlantingRepository(context);
        return new GardenPlantingListViewModelFactory(repository);
    }


}
