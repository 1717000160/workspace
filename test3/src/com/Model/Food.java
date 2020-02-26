package com.Model;

public class Food {
    private int id;
    private String foodName;
    private int foodType;
    private float price;
    private String introduce;
    private String img;

    public Food(String foodName, int foodType, float price, String introduce, String img) {
        this.foodName = foodName;
        this.foodType = foodType;
        this.price = price;
        this.introduce = introduce;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Food(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodType() {
        return foodType;
    }

    public void setFoodType(int foodType) {
        this.foodType = foodType;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
