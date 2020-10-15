package com.payzout.onlinegroceryapp.model;

public class DiscountedProducts {
    private int id;
    private int imageUrl;

    public DiscountedProducts(int id, int imageUrl) {
        this.id = id;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
