package com.lifesumtest.app.models;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class ResponseModel {
    private static final java.lang.String TAG = ResponseModel.class.getSimpleName();
    public List<Food> food;

    public String error;

    public List<Food> getFood() {
        return food;
    }

    public void setFood(List<Food> food) {
        this.food = food;
    }
}