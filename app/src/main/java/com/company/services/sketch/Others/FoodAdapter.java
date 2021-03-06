package com.company.services.sketch.Others;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.company.services.sketch.Modelos.Food;
import com.company.services.sketch.R;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {

    private Context mContext;
    private List<Food> foodList;
    private RecyclerView mRecyclerView;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, description;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            description = (TextView) view.findViewById(R.id.description);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            //overflow = (ImageView) view.findViewById(R.id.overflow);
        }
    }


    public FoodAdapter(Context mContext, List<Food> foodList, RecyclerView mRecyclerView) {
        this.mContext = mContext;
        this.foodList = foodList;
        this.mRecyclerView = mRecyclerView;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food_card, parent, false);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemPosition = mRecyclerView.getChildLayoutPosition(v);
                String item = foodList.get(itemPosition).getName();
                Toast.makeText(mContext, item, Toast.LENGTH_LONG).show();
            }
        });

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Food food = foodList.get(position);
        holder.name.setText(food.getName() + " - $" + round(food.getPrice(), 2));
        holder.description.setText(food.getDescription());

        // loading food cover using Glide library
        Glide.with(mContext).load(food.getThumbnail()).into(holder.thumbnail);

        /*holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow, foodList.get(holder.getAdapterPosition()));
                Toast.makeText(mContext, "Add to order " + foodList.get(holder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    /**
     * Showing popup menu when tapping on 3 dots
     *
    private void showPopupMenu(View view, Food food) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_food, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener(food));
        popup.show();
    }

    /**
     * Click listener for popup menu items
     *
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        Food food;
        public MyMenuItemClickListener() {
        }

        public  MyMenuItemClickListener(Food food) {
            this.food = food;
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_order:
                    Toast.makeText(mContext, "Add to order " + food.getName(), Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }*/

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
