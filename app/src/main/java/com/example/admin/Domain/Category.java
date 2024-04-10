package com.example.admin.Domain;

import com.example.admin.Data.Phim;

import java.util.ArrayList;

public class Category {
    private String categoryName;
    private int categoryId;
    private ArrayList<Phim> lstPhim;

//    public Category(String categoryName, int categoryId) {
//        this.categoryName = categoryName;
//        this.categoryId = categoryId;
//    }

    public Category(String categoryName, int categoryId, ArrayList<Phim> lstPhim) {
        this.categoryName = categoryName;
        this.categoryId = categoryId;
        this.lstPhim = lstPhim;
    }

    public ArrayList<Phim> getLstPhim() {
        return lstPhim;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
