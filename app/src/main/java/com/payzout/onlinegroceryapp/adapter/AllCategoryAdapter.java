package com.payzout.onlinegroceryapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.payzout.onlinegroceryapp.R;
import com.payzout.onlinegroceryapp.model.AllCategory;
import com.payzout.onlinegroceryapp.model.Category;

import java.util.List;

public class AllCategoryAdapter extends RecyclerView.Adapter<AllCategoryAdapter.AllCategoryViewHolder> {

    private Context context;
    private List<AllCategory> categoryList;

    public AllCategoryAdapter(Context context, List<AllCategory> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public AllCategoryAdapter.AllCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.all_category_row_item, parent, false);
        return new AllCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllCategoryAdapter.AllCategoryViewHolder holder, int position) {
        holder.categoryImage.setImageResource(categoryList.get(position).getImageUrl());
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class AllCategoryViewHolder extends RecyclerView.ViewHolder {
        private ImageView categoryImage;

        public AllCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryImage = itemView.findViewById(R.id.categoryImage);
        }
    }
}
