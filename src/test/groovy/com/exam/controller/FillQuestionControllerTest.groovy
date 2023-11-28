package com.exam.controller

import com.exam.entity.ApiResult
import com.exam.entity.FillQuestion
import com.exam.serviceimpl.FillQuestionServiceImpl
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class FillQuestionControllerTest extends Specification {
    @Mock
    FillQuestionServiceImpl fillQuestionService
    @InjectMocks
    FillQuestionController fillQuestionController

    def setup() {
        MockitoAnnotations.initMocks(this)
    }

    def "test add"() {
        given:
        when(fillQuestionService.add(any())).thenReturn(1)

        when:
        ApiResult result = fillQuestionController.add(new FillQuestion())

        then:
        result.code == 200
        result.message == "添加成功"    }

    def "test find Only Question Id"() {
        given:
        when(fillQuestionService.findOnlyQuestionId()).thenReturn(new FillQuestion())

        when:
        ApiResult result = fillQuestionController.findOnlyQuestionId()

        then:
        result.code == 200
        result.message == "查询成功"    }
}

