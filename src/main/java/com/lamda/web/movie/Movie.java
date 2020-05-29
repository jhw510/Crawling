package com.lamda.web.movie;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
@Entity @Component
public class Movie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieNo;
    @Column(length = 4)
    private String seq;
    @Column(length = 100)
    private String movieName;
    @Column(length = 15)
    private String rankDate;

    @Builder
    public Movie(String seq, String movieName,String rankDate ){
        this.seq=seq;
        this.movieName=movieName;
        this.rankDate=rankDate;
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

    public String getRankDate() {
        return rankDate;
    }

    public void setRankDate(String rankDate) {
        this.rankDate = rankDate;
    }

    public Movie(){}

    @Override
    public String toString() {
        return "Movie{" +
                "movieNo=" + movieNo +
                ", seq='" + seq + '\'' +
                ", movieName='" + movieName + '\'' +
                ", rankDate='" + rankDate + '\'' +
                '}';
    }
}
