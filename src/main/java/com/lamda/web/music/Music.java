package com.lamda.web.music;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Entity @Component
public class Music {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long musicNo;
    @Column(length = 4)
    private String seq;
    @Column(length = 200)
    private String title;
    @Column(length = 100)
    private String artist;
    @Column(length = 800)
    private String thumbnail;
    @Builder
    public Music(String seq, String title, String artist,
                 String thumbnail) {
        this.seq = seq;
        this.title = title;
        this.artist = artist;
        this.thumbnail = thumbnail;
    }

    public Long getMusicNo() {
        return musicNo;
    }

    public void setMusicNo(Long musicNo) {
        this.musicNo = musicNo;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
    public Music(){

    }

    @Override
    public String toString() {
        return "Music{" +
                "musicNo=" + musicNo +
                ", seq='" + seq + '\'' +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}