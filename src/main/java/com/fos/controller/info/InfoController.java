package com.fos.controller.info;


import com.fos.entity.info.TbInfo;
import com.fos.enums.info.InfoEnums;
import com.fos.service.info.InfoService;
import com.fos.util.RestHelper;
import com.fos.vo.RestVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/info")
public class InfoController {
    @Resource
    InfoService infoService;
    @RequestMapping("/headlineinfo")
    public RestVO findHeadLineInfoOnTheIndexPage(){
        List<TbInfo> tbInfos =infoService.findHeadLineInfoOnTheIndexPage();
        return RestHelper.success(InfoEnums.QUERT_INFO_SUCCESS.getMsg(),tbInfos);
    }
    @RequestMapping("/allinfo")
    public RestVO findAllInfo(){
        List<TbInfo> tbInfos = infoService.findAllInfo();
        return RestHelper.success(InfoEnums.QUERT_INFO_SUCCESS.getMsg(),tbInfos);
    }
    @GetMapping("/infobyid")
    public RestVO findInfoById(@RequestParam("infoId") Integer infoId){
        TbInfo tbInfo = infoService.findInfoById(infoId);
        return RestHelper.success(InfoEnums.QUERT_INFO_SUCCESS.getMsg(),tbInfo);
    }
}
