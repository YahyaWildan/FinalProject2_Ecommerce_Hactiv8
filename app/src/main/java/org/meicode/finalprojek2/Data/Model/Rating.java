package org.meicode.finalprojek2.Data.Model;

import com.google.gson.annotations.SerializedName;

public class Rating {
    @SerializedName("rate")
    public String rate;

    @SerializedName("count")
    public String count;

    public String getRate() {
        return rate;
    }

    public String getCount() {
        return count;
    }
}
