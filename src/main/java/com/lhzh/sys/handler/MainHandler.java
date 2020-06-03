package com.lhzh.sys.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sys")
public class MainHandler {

    @GetMapping("/hello")
    public String toHello(){
        return "hello";
    }
}
