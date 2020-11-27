package com.cetc.renren.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import com.cetc.renren.util.CommonUtil;
import com.cetc.renren.service.UserService;

/**
 * description:
 * Created by YGP on 2020-11-27
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public JSONObject list(HttpServletRequest request) {
        return userService.listUser(CommonUtil.request2Json(request));
    }

    @PostMapping("/addUser")
    public JSONObject add(@RequestBody JSONObject requestJson){
        CommonUtil.hasAllRequired(requestJson, "username, password, role");
        return userService.addUser(requestJson);
    }

}
