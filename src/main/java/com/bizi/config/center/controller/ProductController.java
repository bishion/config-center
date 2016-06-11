package com.bizi.config.center.controller;

import com.alibaba.fastjson.JSONArray;
import com.bizi.config.center.dao.IProductDao;
import com.bizi.config.center.data.DataUtil;
import com.bizi.config.center.dto.ConfigItem;
import com.bizi.config.center.model.ProductInfo;
import com.bizi.config.center.service.IProductService;
import com.bizi.config.center.utils.ValidateUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 * Created by GuoFangBi on 16-6-10.
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Resource
    private IProductService iProductService;
    @RequestMapping("/add")
    public String addProduct(String productId,String configListJson,String isRealTime){
        if(ValidateUtil.hasOneBlank(productId,configListJson)){
            return String.format("参数为空，productId：%s,configList:%s",productId,configListJson);
        }
        List<ConfigItem> configItemList = new ArrayList<>();
        List<String> configList = JSONArray.parseArray(configListJson,String.class);

        for(String item : configList){
            String[] config = item.split(",");

            ConfigItem configItem = new ConfigItem(config[0]);
            if(config.length > 1){
                configItem.setType(null);
            }
            configItemList.add(configItem);
        }
        isRealTime = ValidateUtil.isBlank(isRealTime)?"0":"1";

        ProductInfo productInfo = new ProductInfo();
        productInfo.setAppName(DataUtil.productAppMap.get(productId));
        productInfo.setProductId(productId);
        productInfo.setConfigListJson(JSONArray.toJSONString(configItemList));
        productInfo.setIsRealTime(isRealTime);
        return "SUCCESS";
    }

    @RequestMapping("/find")
    public String findConfig(String productId){
        if(ValidateUtil.isBlank(productId)){
            return "[]";
        }
        iProductService.findAll(productId);
        return "";
    }
}
