package com.lhzh.gift.model;

public class GiftModel {

    private Integer gid;
    private String gname;
    private Long price;

    public GiftModel(){

    }

    public GiftModel(Integer gid, String gname, Long price) {
        this.gid = gid;
        this.gname = gname;
        this.price = price;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        if(gid != null){
            this.gid = gid;
        }
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        if(price !=null && price>0){
            this.price = price;
        }

    }
}
