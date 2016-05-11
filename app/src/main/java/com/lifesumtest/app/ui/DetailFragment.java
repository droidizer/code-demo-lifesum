package com.lifesumtest.app.ui;

import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.widget.TextView;
import butterknife.Bind;
import com.lifesumtest.app.models.Food;
import org.jetbrains.annotations.NotNull;
import com.lifesumtest.app.R;
import org.parceler.Parcels;

/**
 * Created by greymatter on 10/05/16.
 */
public class DetailFragment extends BaseFragment {

    @NonNull
    @Bind(R.id.carbs)
    TextView carbs;
      @NonNull
    @Bind(R.id.sugar)
    TextView sugar;

    @Override
    protected void onViewCreated(Bundle savedInstanceState) {
    Bundle bundle = getArguments();
       Food food = Parcels.unwrap(bundle.getParcelable("FOOD"));

    if(food==null)
        return;

        carbs.setText(String.valueOf(food.carbohydrates));
        sugar.setText(String.valueOf(food.sugar));
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_detail;
    }

    @NotNull
    @Override
    public String tag() {
        return getClass().getSimpleName();
    }
}
