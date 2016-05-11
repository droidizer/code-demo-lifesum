package com.lifesumtest.app.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import butterknife.Bind;
import com.common.android.utils.ContextHelper;
import com.common.android.utils.interfaces.ICallback;
import com.common.android.utils.ui.recyclerView.DataBindAdapter;
import com.lifesumtest.app.MainActivity;
import com.lifesumtest.app.R;
import com.lifesumtest.app.adapters.FoodBinder;
import com.lifesumtest.app.models.Food;
import com.lifesumtest.app.models.ResponseModel;
import com.lifesumtest.app.network.RequestProvider;
import com.lifesumtest.app.utils.ItemDivider;
import org.jetbrains.annotations.NotNull;

public class FoodFragment extends BaseFragment{
    @NonNull
    @Bind(R.id.recyclerView)
    RecyclerView countriesList;

    DataBindAdapter<Food> foodAdapter;

    @Override
    protected void onViewCreated(Bundle savedInstanceState) {
        setupRecyclerView();

        Bundle bundle = getArguments();
        String searchInput;
        searchInput =  bundle.getString("SEARCH");

        if(TextUtils.isEmpty(searchInput))
            return;

        RequestProvider.searchFoodItems(searchInput, new ICallback<ResponseModel>() {
            @Override
            public void onSuccess(ResponseModel responseModel) {
                if (responseModel==null)
                    return;
                for (Food item: responseModel.food){
                    foodAdapter.add(item, FoodBinder.class);
                }
            }
        });
    }

    private void setupRecyclerView() {
        countriesList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        countriesList.addItemDecoration(new ItemDivider(ContextHelper.getContext(), R.drawable.item_divider));
        foodAdapter = new DataBindAdapter<>();
        countriesList.setHasFixedSize(true);
        countriesList.setAdapter(foodAdapter);
    }
    @Override
    public int getLayout() {
        return R.layout.fragment_food;
    }

    @NotNull
    @Override
    public String tag() {
        return null;
    }
}
