package com.lamda.web.movie;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
@Entity(name="movie")@Component
public class Movie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieNo;
    @Column(length = 4)
    private String seq;
    @Column(length = 200)
    private String movieName;

    @Builder
    public Movie(String seq, String movieName){
        this.seq=seq;
        this.movieName=movieName;
    }

    public Long getMovieNo() {
        return movieNo;
    }

    public void setMovieNo(Long movieNo) {
        this.movieNo = movieNo;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public Movie(){}
}
