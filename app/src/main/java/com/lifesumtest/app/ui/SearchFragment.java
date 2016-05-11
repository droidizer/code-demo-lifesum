package com.lifesumtest.app.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.EditText;
import butterknife.Bind;
import butterknife.OnClick;
import com.lifesumtest.app.R;
import org.jetbrains.annotations.NotNull;

import static com.lifesumtest.app.utils.FragmentProvider.showFoodFragment;

public class SearchFragment extends BaseFragment{

    @NonNull
    @Bind(R.id.search)
    EditText search;

    @Override
    protected void onViewCreated(Bundle savedInstanceState) {
    }

    @OnClick(R.id.search_now)
    public void searchClicked(){
        String searchInput = String.valueOf(search.getText());
        if(!TextUtils.isEmpty(searchInput)){
            showFoodFragment(searchInput);
        }
    }

    @Override
    public int getLayout() {
        return R.layout.search_fragment;
    }

    @NotNull
    @Override
    public String tag() {
        return getClass().getSimpleName();
    }
}
