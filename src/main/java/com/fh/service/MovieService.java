package com.fh.service;

import com.fh.entity.po.Home;
import com.fh.entity.po.Movie;
import com.fh.entity.vo.MovieParam;

import java.util.List;

public interface MovieService {
    MovieParam queryMovie(MovieParam movieParam);

    void addMovie(Movie movie);

    List<Home> queryHome();

    void toUpdatemovieNum(Integer movieId);
}
