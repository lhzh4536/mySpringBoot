package com.disign.changed;
//适配器测试类
public class AdapterTest {
    public static void main(String[] args) {
        EnPluginInterface enPlugin=new EnPlugin();
        Home home =new Home();
        PluginAdapter pluginAdapter =new PluginAdapter(enPlugin);
        home.setCnPlugin(pluginAdapter);
        home.charge();
    }
}
