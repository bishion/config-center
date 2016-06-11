package com.bizi.config.center.dao;

import com.bizi.config.center.model.ProductInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 描述：
 * Created by GuoFangBi on 16-6-11.
 */
@Repository
public interface IProductDao extends CrudRepository<ProductInfo,String>{

}
