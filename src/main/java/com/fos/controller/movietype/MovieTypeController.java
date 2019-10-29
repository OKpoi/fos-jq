package com.fos.controller.movietype;

import com.fos.entity.movietype.TbMovieType;
import com.fos.enums.movietype.MovieTypeEnums;
import com.fos.service.movietype.MovieTypeService;
import com.fos.util.RestHelper;
import com.fos.vo.RestVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Set;

@RestController
@RequestMapping("/api/movietype")
public class MovieTypeController {

  @Resource private MovieTypeService movieTypeService;

  @GetMapping("/allmovietype")
  public RestVO findAllMovieTypeList() {
    Set<TbMovieType> allMovieTypeList = movieTypeService.findAllMovieTypeList();
    return RestHelper.success(MovieTypeEnums.QUERY_MOVIETYPE_SUCCESS.getMsg(), allMovieTypeList);
  }
}
