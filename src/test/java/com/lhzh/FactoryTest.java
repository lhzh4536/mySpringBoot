package com.lhzh;

import com.disign.Factory.Human;
import com.disign.Factory.HumanFactory;

public class FactoryTest {
    public static void main(String[] args){
//        HumanFactory factory = new HumanFactory();
//        Human male = factory.createHuman("male");
//        Human male = factory.createMale();
        Human male = HumanFactory.createMale();
        male.eat();
        male.sleep();
        male.beat();
    }

}
