package com.example.music_player.controller;

import com.example.music_player.common.Response;
import com.example.music_player.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/auth")
@CrossOrigin
@Api(tags = "认证接口", description = "包括用户、管理员的登录、退出等操作。")
public class AuthController {

    @Autowired
    AuthService authService;

   
    @PostMapping(value = "/login")
    @ApiOperation("登录")
    public Response login(HttpServletRequest request, String name, String password) {
        return authService.login(request.getHeader("platform"), name, password);
    }

    
    @GetMapping(value = "/logout")
    @ApiOperation("注销")
    public Response logout() {
        return authService.logout();
    }

}
