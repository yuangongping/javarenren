package com.cetc.renren.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cetc.renren.service.UserService;
import com.cetc.renren.mapper.UserMapper;
import com.cetc.renren.util.CommonUtil;
import com.cetc.renren.util.constants.ErrorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description:
 * Created by YGP on 2020-11-27
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public JSONObject listUser(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int total = userMapper.getTotal(jsonObject);
        List<JSONObject> list = userMapper.listUser(jsonObject);
        return CommonUtil.success(list, total);
    }

    @Override
    public JSONObject addUser(JSONObject jsonObject) {
        // 后端自动生成uuid，将uuid放入到主键中
        String id = CommonUtil.getUUID();
        jsonObject.put("id", id);
        // 判断数据是否存在
        int exist = userMapper.queryExistUsername(jsonObject);
        if (exist > 0) {
            return CommonUtil.errorJson(ErrorEnum.E_10009);
        }
        // 写入数据
        userMapper.addUser(jsonObject);
        // 返回id 对象
        return CommonUtil.success(new JSONObject().put("key", id));
    }
}
