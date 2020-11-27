package com.cetc.renren.config.exception;

import com.cetc.renren.util.CommonUtil;
import com.cetc.renren.util.constants.ErrorEnum;
import com.alibaba.fastjson.JSONObject;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 系统错误拦截, 主要是针对404的错误
 */

@Controller
public class MainsiteErrorController implements ErrorController {
    private static final String ERROR_PATH = "/error";

    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    public JSONObject handleError() {
        return CommonUtil.errorJson(ErrorEnum.E_501);
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

}
