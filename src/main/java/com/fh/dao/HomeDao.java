package com.fh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.entity.po.Home;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HomeDao extends BaseMapper<Home> {
}
