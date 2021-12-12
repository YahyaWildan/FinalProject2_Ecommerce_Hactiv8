package org.meicode.finalprojek2.Data.Model;

import com.google.gson.annotations.SerializedName;

public class BaseResponse {
    @SerializedName("id")
    public String id;

    @SerializedName("title")
    public String title;

    @SerializedName("price")
    public String price;

    @SerializedName("description")
    public String description;

    @SerializedName("category")
    public String category;

    @SerializedName("image")
    public String image;

    @SerializedName("rating")
    public Rating rating;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }

    public Rating getRating() {
        return rating;
    }
}
