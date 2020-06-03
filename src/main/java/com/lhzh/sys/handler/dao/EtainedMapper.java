package com.lhzh.sys.handler.dao;

import com.lhzh.sys.handler.entity.EetainedVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EtainedMapper {
    public List<EetainedVo> activateNewByday(@Param("starttime") Long starttime, @Param("endtime")Long endtime);
}
