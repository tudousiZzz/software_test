package com.exam.service

import com.exam.entity.Student
import com.exam.mapper.LoginMapper
import com.exam.serviceimpl.LoginServiceImpl
import spock.lang.Specification

class LoginServiceTest extends Specification {

    LoginMapper loginMapper = Mock(LoginMapper)

    def loginServiceTest = new LoginServiceImpl(loginMapper: loginMapper)


    def "StudentLogin"() {

        given:
        Student fakeStudent = new Student()
        fakeStudent.setStudentId(123)
        fakeStudent.setPwd("123")

        and:
        loginMapper.studentLogin(123, "123") >> fakeStudent

        when:
        def result = loginServiceTest.studentLogin(123, "123")

        then:
        result.getStudentName() == fakeStudent.getStudentName()
    }
}
