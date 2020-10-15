package com.payzout.onlinegroceryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.payzout.onlinegroceryapp.adapter.CategoryAdapter;
import com.payzout.onlinegroceryapp.adapter.DiscountProductAdapter;
import com.payzout.onlinegroceryapp.adapter.RecentlyViewedAdapter;
import com.payzout.onlinegroceryapp.model.Category;
import com.payzout.onlinegroceryapp.model.DiscountedProducts;
import com.payzout.onlinegroceryapp.model.RecentlyViewd;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        ImageView allCategoryImages = findViewById(R.id.allCategoryImages);

        allCategoryImages.setOnClickListener(this);

        List<DiscountedProducts> discountedProductsList = new ArrayList<>();
        discountedProductsList.add(new DiscountedProducts(0, R.drawable.discountberry));
        discountedProductsList.add(new DiscountedProducts(1, R.drawable.discountbrocoli));
        discountedProductsList.add(new DiscountedProducts(2, R.drawable.discountmeat));
        discountedProductsList.add(new DiscountedProducts(3, R.drawable.discountberry));
        discountedProductsList.add(new DiscountedProducts(4, R.drawable.discountbrocoli));
        discountedProductsList.add(new DiscountedProducts(5, R.drawable.discountmeat));

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(0, R.drawable.ic_home_fruits));
        categoryList.add(new Category(0, R.drawable.ic_home_fish));
        categoryList.add(new Category(0, R.drawable.ic_home_meats));
        categoryList.add(new Category(0, R.drawable.ic_home_veggies));
        categoryList.add(new Category(0, R.drawable.ic_home_fruits));
        categoryList.add(new Category(0, R.drawable.ic_home_fish));
        categoryList.add(new Category(0, R.drawable.ic_home_meats));
        categoryList.add(new Category(0, R.drawable.ic_home_veggies));
        categoryList.add(new Category(0, R.drawable.ic_home_fruits));
        categoryList.add(new Category(0, R.drawable.ic_home_fish));
        categoryList.add(new Category(0, R.drawable.ic_home_meats));
        categoryList.add(new Category(0, R.drawable.ic_home_veggies));


        List<RecentlyViewd> recentlyViewdList = new ArrayList<>();
        recentlyViewdList.add(new RecentlyViewd("Watermelon", "Watermelon has high water content and also provides some fiber", "₹ 80", "2", "KG", R.drawable.card4, R.drawable.b4));
        recentlyViewdList.add(new RecentlyViewd("Papaya", "Watermelon has high water content and also provides some fiber", "₹ 85", "1", "KG", R.drawable.card3, R.drawable.b3));
        recentlyViewdList.add(new RecentlyViewd("Stawberry", "Watermelon has high water content and also provides some fiber", "₹ 240", "3", "KG", R.drawable.card2, R.drawable.b1));
        recentlyViewdList.add(new RecentlyViewd("Kiwi", "Watermelon has high water content and also provides some fiber", "₹ 300", "5", "KG", R.drawable.card1, R.drawable.b2));

        setRecentlyRecyclerView(recentlyViewdList);
        setDiscountedRecycler(discountedProductsList);
        setCategoryRecycler(categoryList);

    }

    private void setRecentlyRecyclerView(List<RecentlyViewd> recentlyViewdList) {
        RecyclerView recentlyRecyclerView = findViewById(R.id.recentlyRecyclerView);
        recentlyRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        RecentlyViewedAdapter recentlyViewedAdapter = new RecentlyViewedAdapter(MainActivity.this, recentlyViewdList);
        recentlyRecyclerView.setAdapter(recentlyViewedAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryList) {
        RecyclerView categoryRecyclerView = findViewById(R.id.categoryRecyclerView);
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        CategoryAdapter categoryAdapter = new CategoryAdapter(MainActivity.this, categoryList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }

    private void setDiscountedRecycler(List<DiscountedProducts> productsList) {

        RecyclerView discountedRecyclerView = findViewById(R.id.discountedRecyclerView);
        discountedRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        DiscountProductAdapter discountProductAdapter = new DiscountProductAdapter(MainActivity.this, productsList);
        discountedRecyclerView.setAdapter(discountProductAdapter);

    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(MainActivity.this, AllCategoryActivity.class));
    }
}