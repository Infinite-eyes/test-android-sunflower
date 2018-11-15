package com.google.samples.apps.sunflower.data;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

import androidx.room.TypeConverter;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/15 11:36 AM
 **/
public final class Converters {

    @TypeConverter
    public final long calendarToDatestamp(@NotNull Calendar calendar) {
        return calendar.getTimeInMillis();
    }

    @TypeConverter
    public final Calendar datestampToCalendar(long value) {
        return Calendar.getInstance();
    }


}
