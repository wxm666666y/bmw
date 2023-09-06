package com.bmw.seed.util.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 中北大学软件学院王袭明版权声明(c) 2023/7/11
 */
@Data
@ApiModel("基础请求")
public class BaseRequest<T> implements Serializable {
    @NotNull(message = "设备类型不能为空")
    @ApiModelProperty(
            value = "设备类型",
            example = "ios,android或h5"
    )
    private String deviceType;

    @NotNull(message = "设备No参数不能为空")
    @ApiModelProperty(
            value = "设备No",
            example = "A123456bcdg67"
    )
    private String deviceNo;

    @NotNull(message = "当前版本参数不能为空")
    @ApiModelProperty(
            value = "当前版本参数",
            example = "1.2.0"
    )
    private String version;

    @NotNull(message = "渠道ID不能为空")
    @ApiModelProperty(
            value = "渠道ID",
            example = "xiaomi/huawei"
    )
    private String channelId;

    //默认验证只是验证当前对象的属性，不会验证内部引入对象的属性（即data里面的字段就是加了参数验证的注解），也不会生效
    //所以我们要在data上增加@valid注解,这样data的属性如果增加了参数注解也会生效了
    @Valid
    @ApiModelProperty("请求内容")
    private T data;

    public BaseRequest() {
    }
}