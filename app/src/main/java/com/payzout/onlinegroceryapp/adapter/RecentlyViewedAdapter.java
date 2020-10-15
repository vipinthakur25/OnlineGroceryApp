package com.payzout.onlinegroceryapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.payzout.onlinegroceryapp.ProductDetailsActivity;
import com.payzout.onlinegroceryapp.R;
import com.payzout.onlinegroceryapp.model.RecentlyViewd;

import java.util.List;

public class RecentlyViewedAdapter extends RecyclerView.Adapter<RecentlyViewedAdapter.RecentlyViewHolder> {
    private Context context;
    private List<RecentlyViewd> recentlyViewdList;

    public RecentlyViewedAdapter(Context context, List<RecentlyViewd> recentlyViewdList) {
        this.context = context;
        this.recentlyViewdList = recentlyViewdList;

    }

    @NonNull
    @Override
    public RecentlyViewedAdapter.RecentlyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recently_viewed_item, parent, false);
        return new RecentlyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentlyViewedAdapter.RecentlyViewHolder holder, final int position) {
        holder.product_name.setText(recentlyViewdList.get(position).getName());
        holder.description.setText(recentlyViewdList.get(position).getDescription());
        holder.price.setText(recentlyViewdList.get(position).getPrice());
        holder.qty.setText(recentlyViewdList.get(position).getQuantity());
        holder.unit.setText(recentlyViewdList.get(position).getUnit());
        holder.recently_layout.setBackgroundResource(recentlyViewdList.get(position).getImageUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductDetailsActivity.class);
                intent.putExtra("name", recentlyViewdList.get(position).getName());
                intent.putExtra("image", recentlyViewdList.get(position).getBigImageUrl());
                intent.putExtra("price", recentlyViewdList.get(position).getPrice());
                intent.putExtra("desc", recentlyViewdList.get(position).getDescription());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recentlyViewdList.size();
    }

    public class RecentlyViewHolder extends RecyclerView.ViewHolder {
        private TextView product_name;
        private TextView description;
        private TextView price;
        private TextView qty;
        private TextView unit;
        private ConstraintLayout recently_layout;

        public RecentlyViewHolder(@NonNull View itemView) {
            super(itemView);

            product_name = itemView.findViewById(R.id.product_name);
            description = itemView.findViewById(R.id.description);
            price = itemView.findViewById(R.id.price);
            qty = itemView.findViewById(R.id.tvQTY);
            unit = itemView.findViewById(R.id.unit);
            recently_layout = itemView.findViewById(R.id.recently_layout);
        }
    }
}
