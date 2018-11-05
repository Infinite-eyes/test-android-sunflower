package com.google.samples.apps.sunflower.data;

import androidx.lifecycle.LiveData;


/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/3 3:39 PM
 **/
public final class GardenPlantingRepository {

    private final GardenPlantingDao gardenPlantingDao;
    private static volatile GardenPlantingRepository instance;
    public static final GardenPlantingRepository.Companion Companion = new GardenPlantingRepository.Companion();


    public final GardenPlantingRepository getInstance( GardenPlantingDao gardenPlantingDao) {
//        GardenPlantingRepository var10000 = GardenPlantingRepository.instance;
//        if (var10000 == null) {
//            synchronized (this) {
//            }
//
//            GardenPlantingRepository var4;
//            try {
//                var10000 = GardenPlantingReposi0tory.instance;
//                if (var10000 == null) {
//                    GardenPlantingRepository var3 = new GardenPlantingRepository(gardenPlantingDao, (DefaultConstructorMarker) null);
//                    GardenPlantingRepository.instance = var3;
//                    var10000 = var3;
//                }
//
//                var4 = var10000;
//            } finally {
//                ;
//            }
//
//            var10000 = var4;
//        }

        return null;
    }

    public final void createGardenPlanting( final String plantId) {

//        AppExecutorsKt.runOnIoThread((Function0)(new Function0() {
//            // $FF: synthetic method
//            // $FF: bridge method
//            public Object invoke() {
//                this.invoke();
//                return Unit.INSTANCE;
//            }
//
//            public final void invoke() {
//                GardenPlanting gardenPlanting = new GardenPlanting(plantId, (Calendar)null, (Calendar)null, 6, (DefaultConstructorMarker)null);
//                GardenPlantingRepository.this.gardenPlantingDao.insertGardenPlanting(gardenPlanting);
//            }
//        }));
    }


    public final LiveData getGardenPlantingForPlant( String plantId) {
        return this.gardenPlantingDao.getGardenPlantingForPlant(plantId);
    }

    public final LiveData getGardenPlantings() {
        return this.gardenPlantingDao.getGardenPlantings();
    }

    public final LiveData getPlantAndGardenPlantings() {
        return this.gardenPlantingDao.getPlantAndGardenPlantings();
    }

    private GardenPlantingRepository(GardenPlantingDao gardenPlantingDao) {
        this.gardenPlantingDao = gardenPlantingDao;
    }

    public static final class Companion {
        
        public final GardenPlantingRepository getInstance( GardenPlantingDao gardenPlantingDao) {
            GardenPlantingRepository gardenPlantingRepository = GardenPlantingRepository.instance;
            if (gardenPlantingRepository == null) {
                gardenPlantingRepository = GardenPlantingRepository.instance;
                if (gardenPlantingRepository == null) {
                    GardenPlantingRepository var3 = new GardenPlantingRepository(gardenPlantingDao);
                    GardenPlantingRepository.instance = var3;
                    gardenPlantingRepository = var3;
                }
            }

            return gardenPlantingRepository;
        }


    }

}
