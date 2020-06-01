package com.lamda.web.movie;

import com.lamda.web.mappers.MovieMapper;
import com.lamda.web.proxy.Crawler;
import com.lamda.web.proxy.ISupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class MovieInitializer implements ApplicationRunner {
    @Autowired
    MovieMapper movieMapper;

   @Autowired
    Crawler crawler;
   @Override
    public void run(ApplicationArguments args) throws Exception {
        ISupplier<Integer> s= movieMapper::count;
              //  int i =s.get();  i는 한번만 쓰니까 아래에 합침
                if(s.get() == 0){ crawler.movieNaver(); }

    }
}
