package com.google.samples.apps.sunflower.viewmodels;

import android.content.Context;

import com.google.samples.apps.sunflower.R;
import com.google.samples.apps.sunflower.data.GardenPlanting;
import com.google.samples.apps.sunflower.data.Plant;
import com.google.samples.apps.sunflower.data.PlantAndGardenPlantings;

import java.text.SimpleDateFormat;
import java.util.Locale;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/2 2:42 PM
 **/
public class PlantAndGardenPlantingsViewModel extends ViewModel {

    private final Plant plant;
    private final GardenPlanting gardenPlanting;
    private SimpleDateFormat dateFormat;
    private String plantDateString;
    private String waterDateString;
    private String wateringPrefix;
    private String wateringSuffix;
    private ObservableField<String> imageUrl;
    private ObservableField<String> plantDate;
    private ObservableField<String> waterDate;

    public PlantAndGardenPlantingsViewModel( final Context context,  PlantAndGardenPlantings plantings) {
        this.plant = plantings.getPlant();
        this.gardenPlanting = (GardenPlanting) plantings.getGardenPlantings().get(0);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy", Locale.US);
        plantDateString = dateFormat.format(gardenPlanting.getPlantDate().getTime());
        waterDateString = dateFormat.format(gardenPlanting.getLastWateringDate().getTime());
        wateringPrefix = context.getString(R.string.watering_next_prefix, waterDateString);
        wateringSuffix = context.getResources().getQuantityString(R.plurals.watering_next_suffix, plant.wateringInterval, plant.wateringInterval);
        imageUrl = new ObservableField<String>(plant.imageUrl);
        plantDate = new ObservableField<String>(context.getString(R.string.planted_date,plant.name,plantDateString));
        waterDate= new ObservableField<String>(wateringPrefix + " - " + wateringSuffix);
    }


    public Plant getPlant() {
        return plant;
    }

    public GardenPlanting getGardenPlanting() {
        return gardenPlanting;
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getPlantDateString() {
        return plantDateString;
    }

    public void setPlantDateString(String plantDateString) {
        this.plantDateString = plantDateString;
    }

    public String getWaterDateString() {
        return waterDateString;
    }

    public void setWaterDateString(String waterDateString) {
        this.waterDateString = waterDateString;
    }

    public String getWateringPrefix() {
        return wateringPrefix;
    }

    public void setWateringPrefix(String wateringPrefix) {
        this.wateringPrefix = wateringPrefix;
    }

    public String getWateringSuffix() {
        return wateringSuffix;
    }

    public void setWateringSuffix(String wateringSuffix) {
        this.wateringSuffix = wateringSuffix;
    }

    public ObservableField<String> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(ObservableField<String> imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ObservableField<String> getPlantDate() {
        return plantDate;
    }

    public void setPlantDate(ObservableField<String> plantDate) {
        this.plantDate = plantDate;
    }

    public ObservableField<String> getWaterDate() {
        return waterDate;
    }

    public void setWaterDate(ObservableField<String> waterDate) {
        this.waterDate = waterDate;
    }
}
