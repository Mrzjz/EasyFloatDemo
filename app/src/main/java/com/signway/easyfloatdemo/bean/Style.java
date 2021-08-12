/**
  * Copyright 2021 bejson.com 
  */
package com.signway.easyfloatdemo.bean;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Auto-generated: 2021-06-23 18:28:55
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Style {
    @JSONField(alternateNames = "background-color")
    private String background_color;
    @JSONField(alternateNames = "background-repeat")
    private String background_repeat;
    private String color;
    private String display;
    @JSONField(alternateNames = "font-size")
    private String font_size;
    @JSONField(alternateNames = "background-image")
    private String background_image;
    @JSONField(alternateNames = "background-position")
    private String background_position;

    public String getBackground_color() {
        return background_color;
    }

    public void setBackground_color(String background_color) {
        this.background_color = background_color;
    }

    public String getBackground_repeat() {
        return background_repeat;
    }

    public void setBackground_repeat(String background_repeat) {
        this.background_repeat = background_repeat;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getFont_size() {
        return font_size;
    }

    public void setFont_size(String font_size) {
        this.font_size = font_size;
    }

    public String getBackground_image() {
        return background_image;
    }

    public void setBackground_image(String background_image) {
        this.background_image = background_image;
    }

    public String getBackground_position() {
        return background_position;
    }

    public void setBackground_position(String background_position) {
        this.background_position = background_position;
    }
}