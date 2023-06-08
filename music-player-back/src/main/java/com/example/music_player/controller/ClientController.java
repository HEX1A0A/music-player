package com.example.music_player.controller;

import com.example.music_player.common.Response;
import com.example.music_player.entity.User;
import com.example.music_player.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/client")
@CrossOrigin
@Api(tags = "用户接口", description = "包括用户的添加、删除、查看、修改等操作。")
public class ClientController {
    @Autowired
    private UserService userService;

    
    @DeleteMapping("/{cid}")
    @ApiOperation("删除用户信息")
    public Response deleteClientByCid(@PathVariable("cid") Integer cid) {
        return userService.deleteClientByCid(cid);
    }

    
    @GetMapping("/")
    @ApiOperation("获取所有用户信息")
    public Response getAllClient() {
        return userService.getAllClient();
    }

    
    @GetMapping("/{numOfPage}/{pageNo}")
    @ApiOperation("获取所有用户信息（分页）")
    public Response getAllClientPage(@PathVariable("numOfPage") Integer numOfPage, @PathVariable("pageNo") Integer pageNo) {
        return userService.getAllClientPage(numOfPage, pageNo);
    }
 
    @GetMapping("/{cid}")
    @ApiOperation("获取单个用户信息")
    public Response getClientByCid(@PathVariable("cid") Integer cid) {
        return userService.getClientByCid(cid);
    }

    @PutMapping("/")
    @ApiOperation("用户信息修改")
    public Response updateClientByCid(User client) {
        return userService.updateClientByCid(client);
    }

    
    @GetMapping("/search/{name}")
    @ApiOperation("搜索用户信息")
    public Response searchClient(@PathVariable("name") String name) {
        return userService.searchClient(name);
    }

    
    @GetMapping("/search/{numOfPage}/{pageNo}/{name}")
    @ApiOperation("搜索用户信息（分页）")
    public Response searchClientPage(@PathVariable("numOfPage") Integer numOfPage, @PathVariable("pageNo") Integer pageNo, @PathVariable("name") String name) {
        return userService.searchClientPage(numOfPage, pageNo, name);
    }

   
    @GetMapping("/count")
    @ApiOperation("获取用户数量")
    public Response countClient() {
        return userService.countClient();
    }

    
    @PostMapping("/register")
    @ApiOperation("用户注册")
    public Response clientRegister(User client) {
        return userService.clientRegister(client);
    }

    
    @GetMapping("/sex")
    @ApiOperation("获取用户性别分布信息")
    public Response getClientAllSexNum() {
        return userService.getClientAllSexNum();
    }

}
