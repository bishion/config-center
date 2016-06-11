package com.bizi.config.center.service;

import com.bizi.config.center.data.DataUtil;
import com.bizi.config.center.model.ProductInfo;
import org.springframework.stereotype.Service;

/**
 * 描述：
 * Created by GuoFangBi on 16-6-10.
 */
@Service
public class ProductService implements IProductService{
    @Override
    public void saveProduct(ProductInfo productInfo) {
        DataUtil.productConfigMap.put(productInfo.getProductId(),productInfo);
    }

    @Override
    public void findAll(String productId) {

    }
}
