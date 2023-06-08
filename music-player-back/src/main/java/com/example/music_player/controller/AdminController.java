package com.example.music_player.controller;

import com.example.music_player.common.Response;
import com.example.music_player.entity.User;
import com.example.music_player.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin")
@CrossOrigin
@Api(tags = "管理员接口", description = "包括管理员的添加、删除、查看等操作。")
public class AdminController {
    @Autowired
    private UserService userService;

    
    @PostMapping("/")
    @ApiOperation("添加普通管理员")
    public Response addAdmin(User admin) {
        return userService.addAdmin(admin);
    }

    
    @DeleteMapping("/{id}")
    @ApiOperation("删除普通管理员")
    public Response deleteAdmin(@PathVariable("id") Integer id) {
        return userService.deleteAdmin(id);
    }

    
    @GetMapping("/")
    @ApiOperation("得到全部普通管理员的信息")
    public Response getAllAdmin() {
        return userService.getAllAdmin();
    }

    
    @GetMapping("/{numOfPage}/{pageNo}")
    @ApiOperation("得到全部普通管理员的信息（分页）")
    public Response getAllAdminPage(@PathVariable("numOfPage") Integer numOfPage, @PathVariable("pageNo") Integer pageNo) {
        return userService.getAllAdminPage(numOfPage, pageNo);
    }

    
    @GetMapping("/search/{name}")
    @ApiOperation("搜索管理员（通过名字）")
    public Response searchAdmin(@PathVariable("name") String name) {
        return userService.searchAdmin(name);
    }

   
    @GetMapping("/search/{numOfPage}/{pageNo}/{name}")
    @ApiOperation("搜索管理员（通过名字）（分页）")
    public Response searchAdmin(@PathVariable("numOfPage") Integer numOfPage, @PathVariable("pageNo") Integer pageNo, @PathVariable("name") String name) {
        return userService.searchAdminPage(numOfPage, pageNo, name);
    }
}
