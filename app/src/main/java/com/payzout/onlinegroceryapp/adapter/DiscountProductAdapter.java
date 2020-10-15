package com.payzout.onlinegroceryapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.payzout.onlinegroceryapp.R;
import com.payzout.onlinegroceryapp.model.DiscountedProducts;

import java.util.List;

public class DiscountProductAdapter extends RecyclerView.Adapter<DiscountProductAdapter.DiscountViewHolder> {
    private Context context;
    private List<DiscountedProducts> discountedProductsList;


    public DiscountProductAdapter(Context context, List<DiscountedProducts> discountedProductsList) {
        this.context = context;
        this.discountedProductsList = discountedProductsList;
    }

    @NonNull
    @Override
    public DiscountProductAdapter.DiscountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.discounted_row_items, parent, false);
        return new DiscountViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscountProductAdapter.DiscountViewHolder holder, int position) {
        holder.discountImage.setImageResource(Integer.parseInt(String.valueOf(discountedProductsList.get(position).getImageUrl())));

    }

    @Override
    public int getItemCount() {
        return discountedProductsList.size();
    }

    public static class DiscountViewHolder extends RecyclerView.ViewHolder {
        private ImageView discountImage;

        public DiscountViewHolder(@NonNull View itemView) {
            super(itemView);
            discountImage = itemView.findViewById(R.id.discountImage);
        }
    }
}
