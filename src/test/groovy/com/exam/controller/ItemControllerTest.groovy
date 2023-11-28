package com.exam.controller

import com.exam.entity.ApiResult
import com.exam.service.PaperService
import com.exam.serviceimpl.FillQuestionServiceImpl
import com.exam.serviceimpl.JudgeQuestionServiceImpl
import com.exam.serviceimpl.MultiQuestionServiceImpl
import com.exam.vo.Item
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class ItemControllerTest extends Specification {
    @Mock
    MultiQuestionServiceImpl multiQuestionService
    @Mock
    FillQuestionServiceImpl fillQuestionService
    @Mock
    JudgeQuestionServiceImpl judgeQuestionService
    @Mock
    PaperService paperService
    @InjectMocks
    ItemController itemController

    def setup() {
        MockitoAnnotations.initMocks(this)
    }

    def "test Item Controller"() {
        given:
        when(multiQuestionService.findBySubject(anyString(), anyInt())).thenReturn([0])
        when(fillQuestionService.findBySubject(anyString(), anyInt())).thenReturn([0])
        when(judgeQuestionService.findBySubject(anyString(), anyInt())).thenReturn([0])
        when(paperService.add(any())).thenReturn(1)

        when:
        ApiResult result = itemController.ItemController(new Item())

        then:
        result.code == 200
        result.message == "试卷组卷成功"    }
}

