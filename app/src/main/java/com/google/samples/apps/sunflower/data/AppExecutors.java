package com.google.samples.apps.sunflower.data;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/15 3:59 PM
 **/
public final class AppExecutors {

    private static final ExecutorService IO_EXECUTOR = Executors.newSingleThreadExecutor();

    public static final void runOnIoThread(Runnable runnable ) {
        IO_EXECUTOR.execute(runnable);
    }



}
