package com.dmbjz.educenter.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel(value = "用户查询对象", description = "用户查询对象封装")
@Data
public class UserQuery implements Serializable {

    @ApiModelProperty(value = "用户名称,模糊查询")
    private String nickname;

    @ApiModelProperty(value = "手机号")
    private Integer mobile;

    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    private String begin;

    @ApiModelProperty(value = "查询结束时间", example = "2019-12-01 10:10:10")
    private String end;


}
