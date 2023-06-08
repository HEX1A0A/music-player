package com.example.music_player.controller;

import com.example.music_player.common.Response;
import com.example.music_player.service.BannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;


@RestController
@RequestMapping("/banner")
@CrossOrigin
@Api(tags = "轮播图接口", description = "主要获取轮播图信息。")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    
    @GetMapping("/")
    @ApiOperation("获取轮播图信息")
    public Response getAllBanner() {
        return bannerService.getAllBanner();
    }
}
