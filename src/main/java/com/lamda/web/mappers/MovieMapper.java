package com.lamda.web.mappers;


import org.springframework.stereotype.Repository;

@Repository
public interface MovieMapper {
    public void  insertMovie();

  public  int Count();
}
