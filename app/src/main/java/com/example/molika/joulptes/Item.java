package com.example.molika.joulptes;

public class Item {

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemReviewsNum() {
        return itemReviewsNum;
    }

    public void setItemReviewsNum(int itemReviewsNum) {
        this.itemReviewsNum = itemReviewsNum;
    }

    public float getItemRatingNum() {
        return itemRatingNum;
    }

    public void setItemRatingNum(float itemRatingNum) {
        this.itemRatingNum = itemRatingNum;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public Double getItemLat() {
        return itemLat;
    }

    public void setItemLat(Double itemLat) {
        this.itemLat = itemLat;
    }

    public Double getItemLng() {
        return itemLng;
    }

    public void setItemLng(Double itemLng) {
        this.itemLng = itemLng;
    }

    private String itemImage;
    private String itemName;
    private int itemPrice;
    private int itemReviewsNum;
    private float itemRatingNum;
    private String itemDesc;
    private Double itemLat;
    private Double itemLng;

}
