package com.exam.serviceimpl

import com.baomidou.mybatisplus.core.metadata.IPage
import com.exam.entity.Teacher
import com.exam.mapper.TeacherMapper
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class TeacherServiceImplTest extends Specification {
    @Mock
    TeacherMapper teacherMapper
    @InjectMocks
    TeacherServiceImpl teacherServiceImpl

    def setup() {
        MockitoAnnotations.initMocks(this)
    }

    def "test find All"() {
        given:
        when(teacherMapper.findAll(any())).thenReturn(null)

        when:
        IPage<Teacher> result = teacherServiceImpl.findAll(null)

        then:
        result == null
    }

    def "test find All 2"() {
        given:
        when(teacherMapper.findAll()).thenReturn([new Teacher()])

        when:
        List<Teacher> result = teacherServiceImpl.findAll()

        then:
        result == [new Teacher()]
    }

    def "test find By Id"() {
        given:
        when(teacherMapper.findById(anyInt())).thenReturn(new Teacher())

        when:
        Teacher result = teacherServiceImpl.findById(0)

        then:
        result == new Teacher()
    }

    def "test delete By Id"() {
        given:
        when(teacherMapper.deleteById(anyInt())).thenReturn(0)

        when:
        int result = teacherServiceImpl.deleteById(0)

        then:
        result == 0
    }

    def "test update"() {
        given:
        when(teacherMapper.update(any())).thenReturn(0)

        when:
        int result = teacherServiceImpl.update(new Teacher())

        then:
        result == 0
    }

    def "test add"() {
        given:
        when(teacherMapper.add(any())).thenReturn(0)

        when:
        int result = teacherServiceImpl.add(new Teacher())

        then:
        result == 0
    }
}

