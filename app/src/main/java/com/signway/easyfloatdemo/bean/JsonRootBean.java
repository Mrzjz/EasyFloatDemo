/**
  * Copyright 2021 bejson.com 
  */
package com.signway.easyfloatdemo.bean;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Auto-generated: 2021-06-23 18:28:55
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class JsonRootBean {

    private String styleType;
    private String transitmode;
    private String NSTCode;
    private List<Children> children;
    @JSONField(alternateNames = "icon-main")
    private String icon_main;
    private String webhost;
    private String text;
    private String iconCls;
    private String displayPosition;
    private String timeout;
    private String touch_menu_id;
    public void setStyleType(String styleType) {
         this.styleType = styleType;
     }
     public String getStyleType() {
         return styleType;
     }

    public void setTransitmode(String transitmode) {
         this.transitmode = transitmode;
     }
     public String getTransitmode() {
         return transitmode;
     }

    public void setNSTCode(String NSTCode) {
         this.NSTCode = NSTCode;
     }
     public String getNSTCode() {
         return NSTCode;
     }

    public void setChildren(List<Children> children) {
         this.children = children;
     }
     public List<Children> getChildren() {
         return children;
     }

    public String getIcon_main() {
        return icon_main;
    }

    public void setIcon_main(String icon_main) {
        this.icon_main = icon_main;
    }

    public void setWebhost(String webhost) {
         this.webhost = webhost;
     }
     public String getWebhost() {
         return webhost;
     }

    public void setText(String text) {
         this.text = text;
     }
     public String getText() {
         return text;
     }

    public void setIconCls(String iconCls) {
         this.iconCls = iconCls;
     }
     public String getIconCls() {
         return iconCls;
     }

    public void setDisplayPosition(String displayPosition) {
         this.displayPosition = displayPosition;
     }
     public String getDisplayPosition() {
         return displayPosition;
     }

    public void setTimeout(String timeout) {
         this.timeout = timeout;
     }
     public String getTimeout() {
         return timeout;
     }

    public void setTouch_menu_id(String touch_menu_id) {
         this.touch_menu_id = touch_menu_id;
     }
     public String getTouch_menu_id() {
         return touch_menu_id;
     }

}