package com.google.samples.apps.sunflower.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.samples.apps.sunflower.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import androidx.databinding.BindingAdapter;
import kotlin.jvm.internal.Intrinsics;

import static android.graphics.Typeface.BOLD;
import static android.graphics.Typeface.ITALIC;

/**
 * @author chenweiming
 * @version 1.0
 * @mail cwm930215@gmail.com
 * @since 2018/11/15 4:59 PM
 **/
public final class PlantDetailBindingAdapters {

    @BindingAdapter({"imageFromUrl"})
    public static final void bindImageFromUrl(@NotNull ImageView view, @Nullable String imageUrl) {
        if (!TextUtils.isEmpty(imageUrl)) {
            Glide.with(view.getContext())
                    .load(imageUrl)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(view);
        }
    }

    @BindingAdapter({"isGone"})
    public static final void bindIsGone(@NotNull FloatingActionButton view, @Nullable Boolean isGone) {
        if (isGone != null && !isGone) {
            view.show();
        } else {
            view.hide();
        }

    }

    @BindingAdapter({"wateringText"})
    public static final void bindWateringText(@NotNull TextView textView, int wateringInterval) {

        String resources = textView.getContext().getResources().getQuantityString(R.plurals.watering_needs_suffix, wateringInterval, wateringInterval);

        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(textView.getContext().getResources().getString(R.string.watering_needs_prefix));
        spannableStringBuilder.setSpan(new StyleSpan(BOLD), spannableStringBuilder.length(), spannableStringBuilder.length(), spannableStringBuilder.length());

        spannableStringBuilder = spannableStringBuilder.append(" ");
        spannableStringBuilder.append(resources);
        spannableStringBuilder.setSpan(new StyleSpan(ITALIC), spannableStringBuilder.length(), spannableStringBuilder.length(), spannableStringBuilder.length());
        textView.setText(spannableStringBuilder);
    }
}
