package com.payzout.onlinegroceryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetailsActivity extends AppCompatActivity implements View.OnClickListener {
private TextView tvProductName;
private TextView tvDescription;
private TextView tvPrice;
private TextView tvQTY;
private TextView unit;
private ImageView ivProduct;
private ImageView ivGoBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        
        initView();
    }

    private void initView() {
        tvProductName = findViewById(R.id.tvProductName);
        tvDescription = findViewById(R.id.tvDescription);
        tvPrice = findViewById(R.id.tvPrice);
        tvQTY = findViewById(R.id.tvQTY);
        unit = findViewById(R.id.unit);
        ivProduct = findViewById(R.id.ivProduct);
        ivGoBack = findViewById(R.id.ivGoBack);

        ivGoBack.setOnClickListener(this);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String price = intent.getStringExtra("price");
        String description = intent.getStringExtra("desc");
        int image = intent.getIntExtra("image", R.drawable.b1);

        tvProductName.setText(name);
        tvDescription.setText(description);
        tvPrice.setText(price);
        ivProduct.setImageResource(image);
    }

    @Override
    public void onClick(View v) {
        onBackPressed();
    }
}