package com.disign.changed;
//在家中充电
public class Home {
    private CnPluginInterface cnPlugin;
    public  Home(){}
    public Home(CnPluginInterface cnPlugin){
        this.cnPlugin=cnPlugin;
    }

    public void setCnPlugin(CnPluginInterface cnPlugin) {
        this.cnPlugin = cnPlugin;
    }
    //充电
    public void  charge(){
        //国标充电
        cnPlugin.chargeWith2Pins();
    }

}
