package com.bizi.config.center.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bizi.config.center.data.DataUtil;
import com.bizi.config.center.model.ProductInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 * Created by GuoFangBi on 16-6-10.
 */
@Service
public class ConfigCenterService implements IConfigCenterService {
    @Override
    public String findProductByApp(String appName) {
        List<ProductInfo> productInfoList = new ArrayList<>();
        for (String productId : DataUtil.productConfigMap.keySet()){
            ProductInfo productInfo = DataUtil.productConfigMap.get(productId);
            if(appName.equals(productInfo.getAppName())){
                productInfoList.add(productInfo);
            }
        }
        return JSONArray.toJSONString(productInfoList);
    }

    @Override
    public String findProductById(String productId) {
        return JSONObject.toJSONString(DataUtil.productConfigMap.get(productId));
    }
}
