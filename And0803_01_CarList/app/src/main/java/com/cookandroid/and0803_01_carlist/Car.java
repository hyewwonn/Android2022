package com.cookandroid.and0803_01_carlist;

import android.graphics.drawable.Drawable;

public class Car {
    private Drawable image;
    private String title;

    public Car(Drawable image, String title) {
        this.image = image;
        this.title = title;
    }

    public Drawable getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
