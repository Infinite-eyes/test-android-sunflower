package com.google.samples.apps.sunflower.workers;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.samples.apps.sunflower.data.AppDatabase;
import com.google.samples.apps.sunflower.data.Plant;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import kotlin.text.Charsets;

import static com.google.samples.apps.sunflower.utilities.Constants.PLANT_DATA_FILENAME;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/5 2:08 PM
 **/
public final class SeedDatabaseWorker extends Worker {

    public SeedDatabaseWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Type plantType = new TypeToken<List<Plant>>(){}.getType();
        JsonReader jsonReader = null;
        Result result;
        try {
            InputStream inputStream = this.getApplicationContext().getAssets().open(PLANT_DATA_FILENAME);
            jsonReader = new JsonReader(new InputStreamReader(inputStream, Charsets.UTF_8));
            List plantList = (new Gson()).fromJson(jsonReader, plantType);
            AppDatabase database = AppDatabase.Companion.getInstance(this.getApplicationContext());
            database.plantDao().insertAll(plantList);
            result = Result.SUCCESS;
        } catch (Exception exception) {
            result = Result.FAILURE;
        } finally {
            if (jsonReader != null) {
                try {
                    jsonReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }
}
