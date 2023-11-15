package com.exam.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class AnswerVO {
    private String question;
    private String subject;
    private String score;
    private String section;
    private String level;
    private String type;
}
