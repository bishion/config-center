package com.bizi.config.center.dto;

import lombok.Data;

/**
 * 描述：
 * Created by GuoFangBi on 16-6-10.
 */
@Data
public class ConfigItem {
    public static final String TYPE_DATE = "DATE";
    private String config;
    private String type = ConfigItem.TYPE_DATE;

    public ConfigItem(String config){
        this.config = config;
    }
    public ConfigItem(){

    }
}
