package lv.luhmirin.sampleapp;

import android.support.design.widget.TextInputLayout;

/**
 */
public class ViewExtenstions {
    public static void removeError(TextInputLayout layout) {
        layout.setError(null);
    }
}
