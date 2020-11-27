package com.cetc.renren.mapper;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * description:
 * Created by YGP on 2020-11-27
 */
public interface UserMapper {
    List<JSONObject> listUser(JSONObject jsonObject);
    int queryExistUsername(JSONObject jsonObject);
    int addUser(JSONObject jsonObject);
    int getTotal(JSONObject jsonObject);

}
