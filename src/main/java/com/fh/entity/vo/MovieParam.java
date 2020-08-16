package com.fh.entity.vo;

import com.fh.entity.po.Movie;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class MovieParam {

    //返回的数据
    private Integer draw;

    private long recordsTotal;

    private long recordsFiltered;

    private List<Movie> data;

    private Integer start; //开始下标

    private Integer length;//每页条数

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endDate;

    private String movieName;

    private Integer showHome;
    private Integer movieNum;


    public Integer getMovieNum() {
        return movieNum;
    }

    public void setMovieNum(Integer movieNum) {
        this.movieNum = movieNum;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getShowHome() {
        return showHome;
    }

    public void setShowHome(Integer showHome) {
        this.showHome = showHome;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<Movie> getData() {
        return data;
    }

    public void setData(List<Movie> data) {
        this.data = data;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public MovieParam(Integer draw, long recordsFiltered, long recordsTotal, List<Movie> data) {
        this.draw = draw;
        this.recordsFiltered = recordsFiltered;
        this.recordsTotal = recordsTotal;
        this.data = data;
    }

    public MovieParam() {

    }


}
