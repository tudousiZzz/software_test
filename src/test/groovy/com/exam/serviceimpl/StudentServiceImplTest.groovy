package com.exam.serviceimpl

import com.baomidou.mybatisplus.core.metadata.IPage
import com.exam.entity.Student
import com.exam.mapper.StudentMapper
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class StudentServiceImplTest extends Specification {
    @Mock
    StudentMapper studentMapper
    @InjectMocks
    StudentServiceImpl studentServiceImpl

    def setup() {
        MockitoAnnotations.initMocks(this)
    }

    def "test find All"() {
        given:
        when(studentMapper.findAll(any())).thenReturn(null)

        when:
        IPage<Student> result = studentServiceImpl.findAll(null)

        then:
        result == null
    }

    def "test find By Id"() {
        given:
        when(studentMapper.findById(anyInt())).thenReturn(new Student())

        when:
        Student result = studentServiceImpl.findById(0)

        then:
        result == new Student()
    }

    def "test delete By Id"() {
        given:
        when(studentMapper.deleteById(anyInt())).thenReturn(0)

        when:
        int result = studentServiceImpl.deleteById(0)

        then:
        result == 0
    }

    def "test update"() {
        given:
        when(studentMapper.update(any())).thenReturn(0)

        when:
        int result = studentServiceImpl.update(new Student())

        then:
        result == 0
    }

    def "test update Pwd"() {
        given:
        when(studentMapper.updatePwd(any())).thenReturn(0)

        when:
        int result = studentServiceImpl.updatePwd(new Student())

        then:
        result == 0
    }

    def "test add"() {
        given:
        when(studentMapper.add(any())).thenReturn(0)

        when:
        int result = studentServiceImpl.add(new Student())

        then:
        result == 0
    }
}

