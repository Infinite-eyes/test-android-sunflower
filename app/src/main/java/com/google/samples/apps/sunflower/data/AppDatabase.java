package com.google.samples.apps.sunflower.data;

import android.content.Context;

import com.google.samples.apps.sunflower.workers.SeedDatabaseWorker;

import org.jetbrains.annotations.NotNull;

import androidx.databinding.adapters.Converters;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import static com.google.samples.apps.sunflower.utilities.Constants.DATABASE_NAME;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/5 1:56 PM
 **/

@Database(
        entities = {GardenPlanting.class, Plant.class},
        version = 1,
        exportSchema = false
)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase instance;
    public static final AppDatabase.Companion Companion = new AppDatabase.Companion();

    public abstract GardenPlantingDao gardenPlantingDao();

    public abstract PlantDao plantDao();

    public static final class Companion {

        public final AppDatabase getInstance(Context context) {
            if (AppDatabase.instance == null) {
                AppDatabase.instance = AppDatabase.Companion.buildDatabase(context);
            }
            return AppDatabase.instance;
        }


        private final AppDatabase buildDatabase(Context context) {
            RoomDatabase roomDatabase = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME).addCallback((new Callback() {
                public void onCreate(SupportSQLiteDatabase db) {
                    super.onCreate(db);
                    OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(SeedDatabaseWorker.class).build();
                    WorkManager.getInstance().enqueue(request);
                }
            })).build();
            return (AppDatabase) roomDatabase;
        }

    }


}
