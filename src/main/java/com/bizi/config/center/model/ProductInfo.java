package com.bizi.config.center.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 描述：
 * Created by GuoFangBi on 16-6-10.
 */
@Data
@Entity
public class ProductInfo {
    @Id
    public String productId;
    public String isRealTime;
    public String configListJson;
    public String appName;

}
