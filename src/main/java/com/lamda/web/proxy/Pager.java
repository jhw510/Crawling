package com.lamda.web.proxy;


import com.lamda.web.mappers.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Pager {
   @Autowired
    MovieMapper movieMapper;
    private int rowCount,startRow,endRow
            ,pageCount,pageSize,startPage,endPage,nowPage
            ,blockCount,blockSize,prevBlock,nextBlock,nowBlock;
    private boolean existPrev,existNext;

    public void paging(){
        rowCount = movieMapper.Count();
        pageSize = 5;
        pageCount=(rowCount%pageSize!=0)?rowCount/pageSize+1:rowCount/pageSize;
        blockSize=5;
        blockCount=(pageCount%blockCount !=0)?pageCount/blockSize+1:pageCount/blockSize;
        nowPage=1;
        startRow = 1+(pageSize*(nowPage-1));
        endRow=(nowPage==pageCount)?rowCount:nowPage*pageSize;
        /*if(nowPage==pageCount){
            endRow = rowCount;} else {
            endRow = nowPage*pageSize;
        }*/
        nowBlock=(nowPage%blockSize !=0)? nowPage/blockSize+1:nowPage/blockSize;
        startPage=1+(blockSize*(nowBlock-1));
        endPage=(nowBlock==blockCount)?pageCount:startPage+blockSize;
        prevBlock=startPage-blockSize;
        nextBlock=startPage+blockSize;
        existPrev=(nowBlock !=1);
        existNext=(nowBlock != blockCount);




    }
}
