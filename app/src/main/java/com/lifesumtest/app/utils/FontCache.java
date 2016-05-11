package com.lifesumtest.app.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import com.lifesumtest.app.R;

import static com.common.android.utils.ContextHelper.getContext;

/**
 * Created by jan.rabe on 01/02/16.
 */
public enum FontCache {

    UiBold(R.string.ui_text_bold),
    UiLight(R.string.ui_text_light),
    UiLightItalic(R.string.ui_text_light_italic),
    UiRegular(R.string.ui_text_regular);

    private final int resourcePath;
    private Typeface font;

    FontCache(final int assetPathToFont) {
        resourcePath = assetPathToFont;
    }

    /**
     * Using main activity.
     *
     * @return font
     */
    @NonNull
    public Typeface getFont() {
        if (font == null)
            font = Typeface.createFromAsset(getContext().getAssets(), getContext().getString(resourcePath));
        return font;
    }

    public String getResourcePath(@NonNull final Context context) {
        return context.getString(resourcePath);
    }
}