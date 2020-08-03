package com.example.anew;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class my_request_class {
    @SerializedName("my_request_data")
    @Expose
    public List<request_data> requestData = null;

    public class request_data {

        @SerializedName("date")
        @Expose
        public String date;
        @SerializedName("area")
        @Expose
        public String area;
        @SerializedName("city")
        @Expose
        public String city;
        @SerializedName("message")
        @Expose
        public String message;
        @SerializedName("image")
        @Expose
        public String image;
    }
}