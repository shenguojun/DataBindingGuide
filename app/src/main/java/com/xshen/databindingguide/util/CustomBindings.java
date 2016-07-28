package com.xshen.databindingguide.util;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.databinding.InverseBindingAdapter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Spanned;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Custom bindings for XML attributes using data binding.
 * (http://developer.android.com/tools/data-binding/guide.html)
 */
public class CustomBindings {

    @BindingAdapter({"bind:font"})
    public static void setFont(TextView textView, String fontName) {
        textView.setTypeface(FontCache.getInstance().get(fontName));
    }

    @BindingAdapter({"bind:url", "bind:placeholder"})
    public static void loadImage(ImageView imageView, String url, Drawable drawable) {
        Glide.with(imageView.getContext()).load(url)
                .placeholder(drawable).crossFade().into(imageView);
    }

    @BindingConversion
    public static ColorDrawable convertColorToDrawable(int color) {
        return new ColorDrawable(color);
    }


    @BindingAdapter("app:text")
    public static void setText(TextView view, CharSequence text) {
        final CharSequence oldText = view.getText();
        if (text == oldText || (text == null && oldText.length() == 0)) {
            return;
        }
        if (text instanceof Spanned) {
            if (text.equals(oldText)) {
                return; // No change in the spans, so don't set anything.
            }
        } else if (!haveContentsChanged(text, oldText)) {
            return; // No content changes, so don't set anything.
        }
        view.setText(text);
    }

    @InverseBindingAdapter(attribute = "app:text", event = "android:textAttrChanged")
    public static String getTextString(TextView view) {
        return view.getText().toString();
    }

    private static boolean haveContentsChanged(CharSequence str1, CharSequence str2) {
        if ((str1 == null) != (str2 == null)) {
            return true;
        } else if (str1 == null) {
            return false;
        }
        final int length = str1.length();
        if (length != str2.length()) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}
