package com.lamda.web.movie;

import lombok.*;


import javax.persistence.*;
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
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

}
