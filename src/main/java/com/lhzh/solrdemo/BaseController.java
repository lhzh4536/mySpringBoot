package com.lhzh.solrdemo;

import java.util.HashMap;
import java.util.Map;

public class BaseController {
    //单纯的成功提示
    public Map<String,Object> success(){
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","success");
        return map;
    }
    //带数据的成功提示
    public Map<String,Object> success(Object object){
        return userDefined(200,"success",object);
    }

    public Map<String,Object> userDefined(Integer code,String msg,Object object){
        Map<String,Object> map = new HashMap<>();
        map.put("code",code);
        map.put("msg",msg);
        map.put("data",object);
        return map;
    }
}
