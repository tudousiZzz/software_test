package com.exam.controller

import com.exam.entity.ApiResult
import com.exam.entity.JudgeQuestion
import com.exam.serviceimpl.JudgeQuestionServiceImpl
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class JudgeQuestionControllerTest extends Specification {
    @Mock
    JudgeQuestionServiceImpl judgeQuestionService
    @InjectMocks
    JudgeQuestionController judgeQuestionController

    def setup() {
        MockitoAnnotations.initMocks(this)
    }

    def "test add"() {
        given:
        when(judgeQuestionService.add(any())).thenReturn(1)

        when:
        ApiResult result = judgeQuestionController.add(new JudgeQuestion())

        then:
        result.code == 200
        result.message == "添加成功"    }

    def "test find Only Question Id"() {
        given:
        when(judgeQuestionService.findOnlyQuestionId()).thenReturn(new JudgeQuestion())

        when:
        ApiResult result = judgeQuestionController.findOnlyQuestionId()

        then:
        result.code == 200
        result.message == "查询成功"    }
}

