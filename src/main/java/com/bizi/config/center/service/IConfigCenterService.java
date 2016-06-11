package com.bizi.config.center.service;

/**
 * 描述：
 * Created by GuoFangBi on 16-6-10.
 */
public interface IConfigCenterService {
    String findProductByApp(String appName);
    String findProductById(String productId);
}
