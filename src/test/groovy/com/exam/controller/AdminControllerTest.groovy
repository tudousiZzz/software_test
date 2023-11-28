package com.exam.controller

import com.exam.entity.Admin
import com.exam.entity.ApiResult
import com.exam.serviceimpl.AdminServiceImpl
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class AdminControllerTest extends Specification {
    @Mock
    AdminServiceImpl adminService
    @InjectMocks
    AdminController adminController

    def setup() {
        MockitoAnnotations.initMocks(this)
    }

    def "test find All"() {
        given:
        when(adminService.findAll()).thenReturn([new Admin()])

        when:
        ApiResult result = adminController.findAll()

        then:
        result.code == 200
        result.message == "请求成功"
    }

    def "test find By Id"() {
        given:
        when(adminService.findById(anyInt())).thenReturn(new Admin())

        when:
        ApiResult result = adminController.findById(0)

        then:
        result.code == 200
        result.message == "请求成功"
    }

    def "test delete By Id"() {
        given:
        when(adminService.deleteById(anyInt())).thenReturn(0)

        when:
        ApiResult result = adminController.deleteById(0)

        then:
        result.code == 200
        result.message == "请求成功"
    }

    def "test update"() {
        given:
        when(adminService.update(any())).thenReturn(0)

        when:
        ApiResult result = adminController.update(0, new Admin())

        then:
        result.code == 200
        result.message == "请求成功"
    }

    def "test add"() {
        given:
        when(adminService.add(any())).thenReturn(0)

        when:
        ApiResult result = adminController.add(new Admin())

        then:
        result.code == 200
        result.message == "请求成功"
    }
}

