package com.cetc.renren.service;

import com.alibaba.fastjson.JSONObject;

/**
 * description:
 * Created by YGP on 2020-11-27
 */
public interface UserService {
    JSONObject listUser(JSONObject jsonObject);
    JSONObject addUser(JSONObject jsonObject);
}
