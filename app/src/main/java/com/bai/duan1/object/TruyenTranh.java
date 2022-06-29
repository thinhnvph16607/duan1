package com.bai.duan1.object;

import org.json.JSONException;
import org.json.JSONObject;

public class TruyenTranh {
    private String tenTruyen, tenChap,linkAnh;

    /*
    {
        "tenTruyen"
        "tenChap"
        "linkAnh"
    }
    */


    public TruyenTranh() {
    }

    public TruyenTranh(JSONObject o) throws JSONException {
        tenTruyen = o.getString("tenTruyen");
        tenChap = o.getString("tenChap");
        linkAnh = o.getString("linkAnh");
    }

    public TruyenTranh(String tenTruyen, String tenChap, String linkAnh) {
        this.tenTruyen = tenTruyen;
        this.tenChap = tenChap;
        this.linkAnh = linkAnh;
    }
    public String getTenTruyen() {
        return tenTruyen;
    }

    public String getTenChap() {
        return tenChap;
    }

    public String getLinkAnh() {
        return linkAnh;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }

    public void setTenChap(String tenChap) {
        this.tenChap = tenChap;
    }

    public void setLinkAnh(String linkAnh) {
        this.linkAnh = linkAnh;
    }


}
