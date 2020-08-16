package com.fh.controller;

import com.fh.common.JsonData;
import com.fh.entity.vo.MovieParam;
import com.fh.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping("queryMovie")
    public MovieParam queryMovie(MovieParam movieParam){
        MovieParam movieList =  movieService.queryMovie(movieParam);
       return movieList;
    }


}
