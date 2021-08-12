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
public class Children {
    @JSONField(alternateNames = "icon-left")
    private String icon_left;
    @JSONField(alternateNames = "icon-right")
    private String icon_right;

    @JSONField(alternateNames = "icon-top")
    private String icon_top;
    private List<Children> children;
    @JSONField(alternateNames = "icon-bottom")
    private String icon_bottom;
    private Style style;
    private String text;
    private String iconCls;
    private boolean leaf;


    private String signature;
    private String previewPathSignature;
    private String previewSignature;
    private String sense;
    private String playtime;
    private String displayMode;
    private String size;
    private String pathSignature;
    private String fileType;



    private boolean private_bc;
    private String gs_code;
    private String gc_code;
    private List<Integer> clientIds;
    private List<String> clientSns;
    private String nd_code;
    private String orgId;


    public String getIcon_left() {
        return icon_left;
    }

    public void setIcon_left(String icon_left) {
        this.icon_left = icon_left;
    }

    public String getIcon_right() {
        return icon_right;
    }

    public void setIcon_right(String icon_right) {
        this.icon_right = icon_right;
    }

    public String getIcon_top() {
        return icon_top;
    }

    public void setIcon_top(String icon_top) {
        this.icon_top = icon_top;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    public String getIcon_bottom() {
        return icon_bottom;
    }

    public void setIcon_bottom(String icon_bottom) {
        this.icon_bottom = icon_bottom;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setStyle(Style style) {
         this.style = style;
     }
     public Style getStyle() {
         return style;
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

    public void setLeaf(boolean leaf) {
         this.leaf = leaf;
     }
     public boolean getLeaf() {
         return leaf;
     }


    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getPreviewPathSignature() {
        return previewPathSignature;
    }

    public void setPreviewPathSignature(String previewPathSignature) {
        this.previewPathSignature = previewPathSignature;
    }

    public String getPreviewSignature() {
        return previewSignature;
    }

    public void setPreviewSignature(String previewSignature) {
        this.previewSignature = previewSignature;
    }

    public String getSense() {
        return sense;
    }

    public void setSense(String sense) {
        this.sense = sense;
    }

    public String getPlaytime() {
        return playtime;
    }

    public void setPlaytime(String playtime) {
        this.playtime = playtime;
    }

    public String getDisplayMode() {
        return displayMode;
    }

    public void setDisplayMode(String displayMode) {
        this.displayMode = displayMode;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPathSignature() {
        return pathSignature;
    }

    public void setPathSignature(String pathSignature) {
        this.pathSignature = pathSignature;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public boolean isPrivate_bc() {
        return private_bc;
    }

    public void setPrivate_bc(boolean private_bc) {
        this.private_bc = private_bc;
    }

    public String getGs_code() {
        return gs_code;
    }

    public void setGs_code(String gs_code) {
        this.gs_code = gs_code;
    }

    public String getGc_code() {
        return gc_code;
    }

    public void setGc_code(String gc_code) {
        this.gc_code = gc_code;
    }

    public List<Integer> getClientIds() {
        return clientIds;
    }

    public void setClientIds(List<Integer> clientIds) {
        this.clientIds = clientIds;
    }

    public List<String> getClientSns() {
        return clientSns;
    }

    public void setClientSns(List<String> clientSns) {
        this.clientSns = clientSns;
    }

    public String getNd_code() {
        return nd_code;
    }

    public void setNd_code(String nd_code) {
        this.nd_code = nd_code;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
}