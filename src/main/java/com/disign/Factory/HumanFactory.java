package com.disign.Factory;

public class HumanFactory {
    public Human createHuman(String gender){
        if(gender.equals("male")){
            return new Male();
        }else if(gender.equals("famale")){
            return new Female();
        }else {
            System.out.println("请输入正确的类型！");
            return null;
        }
    }
    public static Male createMale() {
        return new Male();
    }
    public static Female createFemale() {
        return new Female();
    }
}
