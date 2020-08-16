package com.fh.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.entity.po.Movie;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MovieDao extends BaseMapper<Movie> {

}
