package com.lamda.web.proxy;

import com.lamda.web.music.Music;
import com.lamda.web.music.MusicRepository;
import com.lamda.web.movie.Movie;
import com.lamda.web.movie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@RestController
public class ProxyContorller  {
    @Autowired Box<Object> box;
    @Autowired Crawler crawler;
    @Autowired FileUploader uploader;
    @Autowired Proxy pxy;
    @Autowired
    MusicRepository musicRepository;
    @Autowired
    MovieRepository movieRepository;
//    @Autowired FileUploader loader;

    @PostMapping("/bugsmusic")
    public HashMap<String,Object> bugsMusic(@RequestBody String searchWord){
        pxy.print("넘어온 키워드 : "+searchWord);
        box.clear();

        if(musicRepository.count() == 0)
            crawler.bugsMusic();
        List<Music> list= musicRepository.findAll();
        box.put("list",list);
        box.put("count",String.valueOf(list.size()));
        pxy.print("박스에 담긴 카운트: "+box.get("count"));
        return box.get();
    }

    @GetMapping("/soccer/{searchWord}")
    public HashMap<String,String> soccer(@PathVariable String searchWord){
        pxy.print("넘어온 키워드:"+ searchWord);
        uploader.upload();
        return null;
    }
//  @GetMapping("/movie/{searchWord}")
//    public void movieNaver(@PathVariable String searchWord){
//        pxy.print("넘어온 값" +searchWord);
//        crawler.movieNaver();
//
//  }



   /* @GetMapping("/movie/{searchWord}")
        public HashMap<String,Object> movie(@PathVariable String searchWord){
        pxy.print("넘어온 키워드 : "+searchWord);
        box.clear();

        if(movieRepository.count() == 0)crawler.movie();
        List<Movie> list= movieRepository.findAll();
        box.put("list",list);
//        box.put("count",String.valueOf(list.size()));

            return box.get();
    }*/

}