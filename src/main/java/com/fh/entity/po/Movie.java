package com.fh.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.boot.convert.DurationFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@TableName("t_movie")
public class Movie {
    @TableId(value = "movieId",type = IdType.AUTO)
    private Integer  movieId;	//number(10)	主键ID
    @TableField(value = "movieName")
    private String   movieName;	//varchar2(120)	电影名称
    @TableField(value = "showTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date     showTime;	//date	放映时间
    @TableField(value = "movieNum")
    private Integer  movieNum;	//int	余票数量
    @TableField(value = "moviePrice")
    private Integer  moviePrice;	//Number(2)	价格
    @TableField(value = "showHome")
    private Integer  showHome;	//number	放映室的ID
    @TableField(value = "imgUrl")
    private String   imgUrl;	//varchar2(200)	图片保存路径


    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public Integer getMovieNum() {
        return movieNum;
    }

    public void setMovieNum(Integer movieNum) {
        this.movieNum = movieNum;
    }

    public Integer getMoviePrice() {
        return moviePrice;
    }

    public void setMoviePrice(Integer moviePrice) {
        this.moviePrice = moviePrice;
    }

    public Integer getShowHome() {
        return showHome;
    }

    public void setShowHome(Integer showHome) {
        this.showHome = showHome;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
