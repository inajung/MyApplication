package com.example.myapplication;

import java.util.ArrayList;

public class RecInRecTypeModel {

    private String headerTitle;
    private ArrayList<SingleRecViewTypeModel> allItemsInSection;

    public RecInRecTypeModel() {
    }

    public RecInRecTypeModel(String headerTitle, ArrayList<SingleRecViewTypeModel> allItemsInSection) {
        this.headerTitle = headerTitle;
        this.allItemsInSection = allItemsInSection;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<SingleRecViewTypeModel> getAllItemsInSection() {
        return allItemsInSection;
    }

    public void setAllItemsInSection(ArrayList<SingleRecViewTypeModel> allItemsInSection) {
        this.allItemsInSection = allItemsInSection;
    }
}
