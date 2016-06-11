package com.bizi.config.center.controller;

import com.bizi.config.center.service.IConfigCenterService;
import com.bizi.config.center.utils.ValidateUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 描述：
 * Created by GuoFangBi on 16-6-10.
 */
@RestController
@RequestMapping("/findConfig")
public class ConfigCenterController {
    @Resource
    private IConfigCenterService configCenterService;
    @RequestMapping("/{key}")
    public String findConfigByKey(@PathVariable String key){
        if(ValidateUtil.isBlank(key)){
            return "[]";
        }
        if(key.matches("^\\d{1,}$")){
            return configCenterService.findProductById(key);
        }
        return configCenterService.findProductByApp(key);
    }
}
