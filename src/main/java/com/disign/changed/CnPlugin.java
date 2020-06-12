package com.disign.changed;
// 实现国标插座的充电方法
public class CnPlugin implements CnPluginInterface {
    @Override
    public void chargeWith2Pins() {
        System.out.println("change with CnPlugin");
    }
}
