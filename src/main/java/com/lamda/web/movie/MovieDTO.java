package com.lamda.web.movie;

import com.lamda.web.music.MusicDTO;
import lombok.Data;
import org.springframework.stereotype.Component;
@Data
@Component
public class MovieDTO {

private String seq, movieName ,rankDate;
private MusicDTO ost;
}
