package com.bimowu.springboot.model;

import java.math.BigDecimal;


/**
 * 
 * 
 * 
 **/
public class Account{


  /****/

  private Integer id;


  /**姓名**/

  private String name;


  /**金额**/

  private BigDecimal money;




  public void setId(Integer id) {     this.id = id;
  }


  public Integer getId() {     return this.id;
  }


  public void setName(String name) {     this.name = name;
  }


  public String getName() {     return this.name;
  }


  public void setMoney(BigDecimal money) {     this.money = money;
  }


  public BigDecimal getMoney() {     return this.money;
  }

}
