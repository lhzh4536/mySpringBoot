package com.lhzh.sys.handler;

import com.lhzh.sys.handler.entity.EetainedVo;
import com.lhzh.sys.handler.service.EtainedService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("echarts")
public class EchartsHandler {
    @Resource
    EtainedService etainedService;
    @GetMapping("/days")
    public List<EetainedVo> getEchartsByDays(String starttime, String endtime){
        DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {
            long start = sdf.parse(starttime).getTime()/1000;
            long end = sdf.parse(endtime).getTime()/1000;
            return etainedService.activateNewByday(start,end);
        } catch (ParseException e) {
            e.printStackTrace();
        }
      return  null;
    }
}
