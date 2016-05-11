package com.lifesumtest.app.models;

import org.parceler.Parcel;

/**
 * Created by greymatter on 05/05/16.
 */
@Parcel
public final class Food {
    public String title;
    public long calories;
    public double protein;
    public double potassium;
    public double cholesterol;
    public double saturatedfat;
    public double fiber;
    public double unsaturatedfat;
    public String category;
    public double gramsperserving;
    public double carbohydrates;
    public double fat;
    public double sugar;

    public String getTitle() {
        return title;
    }

    public Food setTitle(String title) {
        this.title = title;
        return this;
    }

    public long getCalories() {
        return calories;
    }

    public Food setCalories(long calories) {
        this.calories = calories;
        return this;
    }

    public double getProtein() {
        return protein;
    }

    public Food setProtein(double protein) {
        this.protein = protein;
        return this;
    }

    public double getPotassium() {
        return potassium;
    }

    public Food setPotassium(double potassium) {
        this.potassium = potassium;
        return this;
    }

    public double getCholesterol() {
        return cholesterol;
    }

    public Food setCholesterol(double cholesterol) {
        this.cholesterol = cholesterol;
        return this;
    }

    public double getSaturatedfat() {
        return saturatedfat;
    }

    public Food setSaturatedfat(double saturatedfat) {
        this.saturatedfat = saturatedfat;
        return this;
    }

    public double getFiber() {
        return fiber;
    }

    public Food setFiber(double fiber) {
        this.fiber = fiber;
        return this;
    }

    public double getUnsaturatedfat() {
        return unsaturatedfat;
    }

    public Food setUnsaturatedfat(double unsaturatedfat) {
        this.unsaturatedfat = unsaturatedfat;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Food setCategory(String category) {
        this.category = category;
        return this;
    }

    public double getGramsperserving() {
        return gramsperserving;
    }

    public Food setGramsperserving(double gramsperserving) {
        this.gramsperserving = gramsperserving;
        return this;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public Food setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
        return this;
    }

    public double getFat() {
        return fat;
    }

    public Food setFat(double fat) {
        this.fat = fat;
        return this;
    }

    public double getSugar() {
        return sugar;
    }

    public Food setSugar(double sugar) {
        this.sugar = sugar;
        return this;
    }
}
