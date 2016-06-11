package com.bizi.config.center.service;

import com.bizi.config.center.model.ProductInfo;

/**
 * 描述：
 * Created by GuoFangBi on 16-6-10.
 */
public interface IProductService {
    void saveProduct(ProductInfo productInfo);
    void findAll(String productId);
}
