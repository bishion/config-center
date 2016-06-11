package com.bizi.config.center.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 描述：
 * Created by GuoFangBi on 16-6-11.
 */
@Data
@Entity
public class Student {
    @Id
    @Column
    private String username;
    @Column
    private String password;
}
