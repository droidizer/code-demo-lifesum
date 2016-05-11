package com.lifesumtest.app.utils;

import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.lifesumtest.app.R;
import com.lifesumtest.app.models.Food;
import com.lifesumtest.app.ui.BaseFragment;
import com.lifesumtest.app.ui.DetailFragment;
import com.lifesumtest.app.ui.FoodFragment;
import com.lifesumtest.app.ui.SearchFragment;
import org.parceler.Parcels;

import static com.common.android.utils.ContextHelper.getContext;
import static com.common.android.utils.extensions.FragmentExtensions.newInstance;

public class FragmentProvider {

    private static final String FOOD = "FOOD";
    private static final String SEARCH_INPUT = "SEARCH";

    public static void showSearchFragment() {
        final FragmentManager fm = getContext().getSupportFragmentManager();
        final Bundle bundle = new Bundle();
        final BaseFragment fragment = newInstance(SearchFragment.class, bundle);
        final FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, fragment, fragment.tag());
        ft.addToBackStack(fragment.tag());
        ft.commit();
    }

    public static void showFoodFragment(@NonNull final String input) {
        final FragmentManager fm = getContext().getSupportFragmentManager();
        final Bundle bundle = new Bundle();
        bundle.putString(SEARCH_INPUT, input);
        final BaseFragment fragment = newInstance(FoodFragment.class, bundle);
        final FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, fragment, fragment.tag());
        ft.addToBackStack(fragment.tag());
        ft.commit();
    }

    public static void showFoodDetailFragment(@NonNull final Food food) {
        final FragmentManager fm = getContext().getSupportFragmentManager();
        final Bundle bundle = new Bundle();
        bundle.putParcelable(FOOD, Parcels.wrap(food));
        final BaseFragment fragment = newInstance(DetailFragment.class, bundle);
        final FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, fragment, fragment.tag());
        ft.addToBackStack(fragment.tag());
        ft.commit();
    }
}
