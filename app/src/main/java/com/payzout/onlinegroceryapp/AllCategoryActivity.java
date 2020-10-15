package com.payzout.onlinegroceryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.payzout.onlinegroceryapp.adapter.AllCategoryAdapter;
import com.payzout.onlinegroceryapp.model.AllCategory;

import java.util.ArrayList;
import java.util.List;

public class AllCategoryActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_category);

        initViews();
    }

    private void initViews() {

        ImageView ivGoBack = findViewById(R.id.ivGoBack);

        List<AllCategory> allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory(0, R.drawable.ic_cookies));
        allCategoryList.add(new AllCategory(1, R.drawable.ic_dairy));
        allCategoryList.add(new AllCategory(2, R.drawable.ic_fruits));
        allCategoryList.add(new AllCategory(3, R.drawable.ic_desert));
        allCategoryList.add(new AllCategory(4, R.drawable.ic_drink));
        allCategoryList.add(new AllCategory(5, R.drawable.ic_fish));
        allCategoryList.add(new AllCategory(6, R.drawable.ic_veggies));
        allCategoryList.add(new AllCategory(7, R.drawable.ic_meat));
        allCategoryList.add(new AllCategory(8, R.drawable.ic_spices));
        allCategoryList.add(new AllCategory(9, R.drawable.ic_egg));
        allCategoryList.add(new AllCategory(10, R.drawable.ic_juce));
        setAllCategoryRV(allCategoryList);

        ivGoBack.setOnClickListener(this);
    }

    private void setAllCategoryRV(List<AllCategory> allCategoryList) {
        RecyclerView allCategoryRecyclerView = findViewById(R.id.allCategoryRecyclerView);
        allCategoryRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        allCategoryRecyclerView.addItemDecoration(new GridSpacingItemDecoration(4, 10, true));
        allCategoryRecyclerView.setItemAnimator(new DefaultItemAnimator());
        AllCategoryAdapter allCategoryAdapter = new AllCategoryAdapter(AllCategoryActivity.this, allCategoryList);
        allCategoryRecyclerView.setAdapter(allCategoryAdapter);
    }

    @Override
    public void onClick(View v) {
        onBackPressed();
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}