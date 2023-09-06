package com.bimowu.ssm.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 中北大学软件学院王袭明版权声明(c) 2023/7/3
 */
public class Account implements Serializable {
    private int id;
    private  String name;
    private BigDecimal money;

    public Account() {
    }

    public Account(int id, String name, BigDecimal money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
