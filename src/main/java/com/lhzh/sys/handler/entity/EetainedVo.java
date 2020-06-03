package com.lhzh.sys.handler.entity;

public class EetainedVo {
    public Integer activateNew;
    public String theday;

    public EetainedVo(Integer activateNew, String theday) {
        this.activateNew = activateNew;
        this.theday = theday;
    }

    public EetainedVo() {
    }

    public Integer getActivateNew() {
        return activateNew;
    }

    public void setActivateNew(Integer activateNew) {
        this.activateNew = activateNew;
    }

    public String getTheday() {
        return theday;
    }

    public void setTheday(String theday) {
        this.theday = theday;
    }
}
