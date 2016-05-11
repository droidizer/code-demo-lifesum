package com.lifesumtest.app.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.common.android.utils.ui.recyclerView.DataBindAdapter;
import com.common.android.utils.ui.recyclerView.DataBinder;
import com.lifesumtest.app.R;
import com.lifesumtest.app.models.Food;
import org.jetbrains.annotations.NotNull;

import static com.lifesumtest.app.utils.FragmentProvider.showFoodDetailFragment;

/**
 * Created by greymatter on 05/05/16.
 */
public class FoodBinder extends DataBinder<Food, FoodBinder.ViewHolder> {
    public FoodBinder(@NotNull DataBindAdapter<Food> dataBindAdapter) {
        super(dataBindAdapter);
    }

    @Override
    public void bindViewHolder(@NotNull ViewHolder viewHolder, int position) {

        final Food food = get(position);

        if(food==null)
            return;
        ColorGenerator generator = ColorGenerator.MATERIAL;
        int randomColor = generator.getRandomColor();
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(extractFirstLetter(food.title), randomColor);
        viewHolder.image.setImageDrawable(drawable);
        viewHolder.title.setText(food.title);
        viewHolder.calories.setText(String.valueOf(roundOff(kiloCalConversion(food.calories))));
        viewHolder.amount.setText(String.valueOf(food.gramsperserving));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFoodDetailFragment(food);
            }
        });
    }

    private int roundOff(double num) {
       return (int) (Math.round(num *100)/100);
    }

    private int kiloCalConversion(double num){
        if (((int) Math.log10(num) + 1) > 3)
        return (int) num;
    else return (int) (num/1000);
    }

    private String extractFirstLetter(String title) {
        return String.valueOf(title.charAt(0));
    }

    @Override
    public int getLayout() {
        return R.layout.food_item;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @NonNull
        @Bind(R.id.title)
        TextView title;
        @NonNull
        @Bind(R.id.calories)
        TextView calories;
        @NonNull
        @Bind(R.id.amount)
        TextView amount;
        @NonNull
        @Bind(R.id.image_view)
        ImageView image;
     /*   @NonNull
        @Bind(R.id.potassium)
        TextView potassium;
        @NonNull
        @Bind(R.id.fats)
        TextView fats;*/

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
