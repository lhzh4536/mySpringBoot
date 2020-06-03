package com.lhzh.sys.handler.service;

import com.lhzh.sys.handler.dao.EtainedMapper;
import com.lhzh.sys.handler.entity.EetainedVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EtainedService {
    @Resource
    private EtainedMapper etainedMapper;
    public List<EetainedVo> activateNewByday(Long starttime,Long endtime){
        return etainedMapper.activateNewByday(starttime,endtime);
    };
}
