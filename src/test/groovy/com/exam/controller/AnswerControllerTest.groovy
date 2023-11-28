package com.exam.controller

import com.exam.entity.ApiResult
import com.exam.serviceimpl.AnswerServiceImpl
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class AnswerControllerTest extends Specification {
    @Mock
    AnswerServiceImpl answerService
    @InjectMocks
    AnswerController answerController

    def setup() {
        MockitoAnnotations.initMocks(this)
    }

    def "test find All Question"() {
        given:
        when(answerService.findAll(any())).thenReturn(null)

        when:
        ApiResult result = answerController.findAllQuestion(0, 0)

        then:
        result.code == 200
        result.message == "查询所有题库"
    }
}

