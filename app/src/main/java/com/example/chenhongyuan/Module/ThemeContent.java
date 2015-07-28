package com.example.chenhongyuan.Module;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by chenhongyuan on 15/7/14.
 */
public class ThemeContent {
    public List<Story> stories;
    public String description;
    public String background;
    public int color;
    public String name;
    public String image;
    public List<Editor> editors;
    @SerializedName("image_source")
    public String imageSource;
}
