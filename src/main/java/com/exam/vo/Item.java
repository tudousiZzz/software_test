package com.exam.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

//题目模型
@Data
@ApiModel
public class Item {

    private String subject;

    private Integer paperId;

    private Integer changeNumber;

    private Integer fillNumber;

    private Integer judgeNumber;
}
