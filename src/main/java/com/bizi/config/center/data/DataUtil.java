package com.bizi.config.center.data;

import com.bizi.config.center.model.ProductInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：
 * Created by GuoFangBi on 16-6-10.
 */
public class DataUtil {
    public static final Map<String,ProductInfo> productConfigMap = new HashMap<>();
    public static final Map<String,String> productAppMap = new HashMap<String,String>(){{
        put("123455", "za-bops");
    }};
}
