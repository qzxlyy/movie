package com.fh.controller;

import com.fh.common.JsonData;
import com.fh.entity.po.Home;
import com.fh.entity.po.Movie;
import com.fh.entity.vo.MovieParam;
import com.fh.service.MovieService;
import com.fh.utils.OSSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("addMovie")
    public JsonData addMovie(Movie movie){
        movieService.addMovie(movie);
        return JsonData.getJsonSuccess("添加成功");
    }

    @RequestMapping("queryHome")
    public JsonData queryHome(){
      List<Home> list =  movieService.queryHome();
        return JsonData.getJsonSuccess(list);
    }

    @RequestMapping("uploadFIle")
    public Map uploadFIle(@RequestParam("img") MultipartFile img, HttpServletRequest request) throws Exception {
        InputStream ins = img.getInputStream();
        File toFile = new File(img.getOriginalFilename());
        inputStreamToFile(ins,toFile);
        String s = OSSUtils.uploadFile(toFile);
        Map map=new HashMap();
        map.put("imgPath",s);
        return  map;
    }



    //获取流文件
    private static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("toUpdatemovieNum")
    public JsonData toUpdatemovieNum(Integer movieId){
        movieService.toUpdatemovieNum(movieId);
        return  JsonData.getJsonSuccess("购票成功");
    }

}
