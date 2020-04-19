package com.example.groceryapp;

import java.util.ArrayList;

public class GroceryListItem {
    private String gItemName;
    private Integer gItemQuantity;
    private Double gSingleItemPrice;
    private Double gTotalPrice;

    public GroceryListItem(String g_item_name, Integer g_item_quantity, Double g_single_item_price) {
        gItemName = g_item_name;
        gItemQuantity = g_item_quantity;
        gSingleItemPrice = g_single_item_price;
        gTotalPrice = g_single_item_price * g_item_quantity;
    }

    public static ArrayList<GroceryListItem> createGroceryList(int numItems) {
        ArrayList<GroceryListItem> groceryList = new ArrayList<GroceryListItem>();

        for (int i = 1; i <= numItems; i++) {
            groceryList.add(new GroceryListItem("Item", 2+i, (double) 200.00*i));
        }

        return groceryList;
    }

    public String getGItemName() {
        return gItemName;
    }

    public Integer getGItemQuantity() {
        return gItemQuantity;
    }

    public Double getGTotalPrice() {
        return gTotalPrice;
    }
}
