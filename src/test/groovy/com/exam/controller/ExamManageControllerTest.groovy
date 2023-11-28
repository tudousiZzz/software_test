package com.exam.controller

import com.exam.entity.ApiResult
import com.exam.entity.ExamManage
import com.exam.serviceimpl.ExamManageServiceImpl
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class ExamManageControllerTest extends Specification {
    @Mock
    ExamManageServiceImpl examManageService
    @InjectMocks
    ExamManageController examManageController

    def setup() {
        MockitoAnnotations.initMocks(this)
    }

    def "test find All"() {
        given:
        when(examManageService.findAll()).thenReturn([new ExamManage()])

        when:
        ApiResult result = examManageController.findAll()

        then:
        result.code == 200
        result.message == "请求成功"
    }

    def "test find All 2"() {
        given:
        when(examManageService.findAll(any())).thenReturn(null)

        when:
        ApiResult result = examManageController.findAll(0, 0)

        then:
        result.code == 200
        result.message == "请求成功"    }

    def "test find By Id"() {
        given:
        when(examManageService.findById(anyInt())).thenReturn(new ExamManage())

        when:
        ApiResult result = examManageController.findById(0)

        then:
        result.code == 200
        result.message == "请求成功"    }

    def "test delete By Id"() {
        given:
        when(examManageService.delete(anyInt())).thenReturn(0)

        when:
        ApiResult result = examManageController.deleteById(0)

        then:
        result.code == 200
        result.message == "删除成功"    }

    def "test update"() {
        given:
        when(examManageService.update(any())).thenReturn(0)

        when:
        ApiResult result = examManageController.update(new ExamManage())

        then:
        result.code == 200
        result.message == "更新成功"    }

    def "test add"() {
        given:
        when(examManageService.add(any())).thenReturn(1)

        when:
        ApiResult result = examManageController.add(new ExamManage())

        then:
        result.code == 200
        result.message == "添加成功"    }

    def "test find Only Paper Id"() {
        given:
        when(examManageService.findOnlyPaperId()).thenReturn(new ExamManage())

        when:
        ApiResult result = examManageController.findOnlyPaperId()

        then:
        result.code == 200
        result.message == "请求成功"    }
}

