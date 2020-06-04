package com.lamda.web.movie;


import com.lamda.web.mappers.MovieMapper;
import com.lamda.web.proxy.Box;
import com.lamda.web.proxy.IFunction;
import com.lamda.web.proxy.Pager;
import com.lamda.web.proxy.Proxy;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired Pager pager;
    @Autowired MovieMapper movieMapper;
    @Autowired Proxy pxy;
    @Autowired Box<Object> box;
    @GetMapping("/{searchWord}/{pageNumber}")
    public Map<?,?> list(@PathVariable("pageNumber") String pageNumber,
                         @PathVariable("searchWord") String searchWord){
        pxy.println("누른 영화 이름 "+searchWord );
        if(searchWord.equals("null")){
            pxy.println("검색어가 없음");
            pager.setSearchWord("");
        }else{
         pxy.println("검색어가 "+searchWord);
            pager.setSearchWord("searchWord");
        }
        pxy.println("넘어온 페이지 번호: "+pageNumber);
        pager.setPageNow(pxy.integer(pageNumber));
        pager.setBlockSize(5);
        pager.setPageSize(5);
        pager.paging();
        IFunction<Pager, List<MovieDTO>> f = p ->  movieMapper.selectMovies(p);
        List<MovieDTO> l = f.apply(pager);
        pxy.println("***************************************");
        for(MovieDTO m : l){
            pxy.println(m.toString());
        }
        box.clear();
        box.put("pager",pager);
        box.put("list",l);
        return box.get();
    }
    @GetMapping("/{searchWord}")
    public  MovieDTO movieOne (@PathVariable("searchWord") String searchWord) {
        pxy.println("누른 영화의 seq값은  :" + searchWord);


        return movieMapper.selectMovie(searchWord);
    }

}