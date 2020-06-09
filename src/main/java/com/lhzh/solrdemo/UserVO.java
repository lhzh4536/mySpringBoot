package com.lhzh.solrdemo;
//VO PO POJO  DTO Entity Model JavaBean
public class UserVO implements  Cloneable{
    private Integer id;
    private String name;

    @Override
    protected UserVO clone() throws CloneNotSupportedException {
        return (UserVO) super.clone();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
