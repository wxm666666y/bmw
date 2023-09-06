package com.bmw.seed.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 中北大学软件学院王袭明版权声明(c) 2023/7/11
 */
@ApiModel("demo对象")
public class DemoReq implements Serializable {

    @ApiModel("demo新增基础对象")
    public static class BaseInfo implements Serializable {

        @NotNull(message = "text不能为空")
        @ApiModelProperty(
                value = "text",
                required = true,
                example = "demo的内容"
        )
        private String text;

        @NotNull(message = "text不能为空")
        @ApiModelProperty(
                value = "dcode",
                required = true,
                example = "dcode对应的码值"
        )
        private String dcode;

        public String getDcode() {
            return dcode;
        }
        public void setDcode(String dcode) {
            this.dcode = dcode;
        }
        public String getText() {
            return text;
        }
        public void setText(String text) {
            this.text = text;
        }
    }
    //lombok的注解，相当于自动添加了get和set方法
    @Data
    @ApiModel("demo返回展示对象")
    public static class ShowBaseInfo extends BaseInfo implements Serializable {

        @ApiModelProperty(
                value = "id",
                example = "1234"
        )
        private Long id;

        @ApiModelProperty(
                value = "创建时间",
                example = "2021-10-10 12:13:24"
        )
        private String createTimeString;
    }
}
//“java里面static一般用来修饰成员变量或函数。但有一种特殊用法是用static修饰内部类,普通类是不允许声明为静态的,只有内部类才可以。内部类用static修饰是为了方便静态调用