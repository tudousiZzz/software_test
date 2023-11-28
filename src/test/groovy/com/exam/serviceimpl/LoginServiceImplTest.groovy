package com.exam.serviceimpl

import com.exam.entity.Admin
import com.exam.entity.Student
import com.exam.entity.Teacher
import com.exam.mapper.LoginMapper
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class LoginServiceImplTest extends Specification {
    @Mock
    LoginMapper loginMapper
    @InjectMocks
    LoginServiceImpl loginServiceImpl

    def setup() {
        MockitoAnnotations.initMocks(this)
    }

    def "test admin Login"() {
        given:
        when(loginMapper.adminLogin(anyInt(), anyString())).thenReturn(new Admin())

        when:
        Admin result = loginServiceImpl.adminLogin(0, "password")

        then:
        result == new Admin()
    }

    def "test teacher Login"() {
        given:
        when(loginMapper.teacherLogin(anyInt(), anyString())).thenReturn(new Teacher())

        when:
        Teacher result = loginServiceImpl.teacherLogin(0, "password")

        then:
        result == new Teacher()
    }

    def "test student Login"() {
        given:
        when(loginMapper.studentLogin(anyInt(), anyString())).thenReturn(new Student())

        when:
        Student result = loginServiceImpl.studentLogin(0, "password")

        then:
        result == new Student()
    }
}

