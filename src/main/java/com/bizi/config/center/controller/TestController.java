package com.bizi.config.center.controller;

import com.alibaba.fastjson.JSONArray;
import com.bizi.config.center.dao.IProductDao;
import com.bizi.config.center.model.ProductInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 描述：
 * Created by GuoFangBi on 16-6-10.
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    private IProductDao iProductDao;
    @RequestMapping("/hello")
    public String hello(){

        return "Hello World";
    }
    @RequestMapping("add")
    public String addProduct(String id){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setAppName("appName");
        productInfo.setConfigListJson("JSON");
        productInfo.setProductId(id);
        productInfo.setIsRealTime("1");
        iProductDao.save(productInfo);
        return JSONArray.toJSONString(iProductDao.findAll());
    }

}
