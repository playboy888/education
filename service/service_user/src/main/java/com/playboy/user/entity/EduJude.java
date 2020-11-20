package com.playboy.user.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EduJude {
    private  int size;
    private  int current;
    @ApiModelProperty(value = "模糊查询",example = "王")
    private String name;
    @ApiModelProperty(value="等级",example = "0")
    private Integer level;
    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    private String gmtCreate;
    @ApiModelProperty(value = "查询结束时间", example = "2019-01-01 10:10:10")
    private String gmtModified;
}
