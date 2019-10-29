package com.fos.controller;

import com.fos.entity.movietype.TbMovieType;
import com.fos.service.movietype.MovieTypeService;
import com.fos.util.RestHelpyer;
import com.fos.vo.RestVO;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movietype")
public class MovieTypeController {

  @Resource private MovieTypeService movieTypeService;

  @GetMapping("/list")
  public RestVO getAllMovieTypeList() {
    Set<TbMovieType> data = movieTypeService.findAllMovieTypeList();
    return RestHelpyer.success(data);
  }
}
