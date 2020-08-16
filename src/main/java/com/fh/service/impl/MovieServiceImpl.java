package com.fh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fh.dao.HomeDao;
import com.fh.dao.MovieDao;
import com.fh.entity.po.Home;
import com.fh.entity.po.Movie;
import com.fh.entity.vo.MovieParam;
import com.fh.service.MovieService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Resource
    private MovieDao movieDao;
    @Resource
    private HomeDao homeDao;

    @Override
    public MovieParam queryMovie(MovieParam movieParam) {
        QueryWrapper<Movie> qw = new QueryWrapper<>();
        qw.eq(!StringUtils.isEmpty(movieParam.getMovieName()),"movieName",movieParam.getMovieName())
                .eq(!StringUtils.isEmpty(movieParam.getShowHome())&& !movieParam.getShowHome().equals("-1"),"showHome",movieParam.getShowHome());
        if(movieParam.getMovieNum()==null ){// 没票

        }else if( movieParam.getMovieNum()==1){
            qw.eq("movieNum",0);
        }else{//有票
            qw.gt("movieNum",0);
        }

        Page<Movie> page = new Page<>((movieParam.getStart()/movieParam.getLength())+1,movieParam.getLength());
        Page<Movie> moviePage = movieDao.selectPage(page, qw);
        MovieParam movieParams = new MovieParam(movieParam.getDraw(),moviePage.getTotal(),moviePage.getTotal(),moviePage.getRecords());
        return movieParams;
    }

    @Override
    public void addMovie(Movie movie) {
        movieDao.insert(movie);
    }

    @Override
    public List<Home> queryHome() {
        List<Home> homes = homeDao.selectList(null);
        return homes;
    }

    @Override
    public void toUpdatemovieNum(Integer movieId) {
        Movie movie = movieDao.selectById(movieId);
        Integer movieNum = movie.getMovieNum();
        if(movieNum>0){
            movieDao.toUpdatemovieNum(movieId);
        }
    }
}
