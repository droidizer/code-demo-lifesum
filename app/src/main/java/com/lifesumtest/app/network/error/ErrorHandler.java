package com.lifesumtest.app.network.error;

import com.orhanobut.wasp.WaspError;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

import static com.common.android.utils.ContextHelper.getContext;

final public class ErrorHandler {

    private ErrorHandler() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static void handleWaspError(WaspError waspError) {
        showError(waspError);
    }

    public static void showError(WaspError error) {
        Crouton.makeText(getContext(), "Network error" , Style.ALERT).show();
    }
}
