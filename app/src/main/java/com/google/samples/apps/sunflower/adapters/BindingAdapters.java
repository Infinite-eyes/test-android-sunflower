package com.google.samples.apps.sunflower.adapters;

import android.view.View;

import org.jetbrains.annotations.NotNull;

import androidx.databinding.BindingAdapter;
import kotlin.jvm.internal.Intrinsics;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/15 4:58 PM
 **/
public class BindingAdapters {
    @BindingAdapter({"isGone"})
    public static final void bindIsGone(@NotNull View view, boolean isGone) {
        view.setVisibility(isGone ? View.GONE : View.VISIBLE);
    }
}
