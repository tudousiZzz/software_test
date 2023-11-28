package com.exam.serviceimpl

import com.baomidou.mybatisplus.core.metadata.IPage
import com.exam.entity.ExamManage
import com.exam.mapper.ExamManageMapper
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class ExamManageServiceImplTest extends Specification {
    @Mock
    ExamManageMapper examManageMapper
    @InjectMocks
    ExamManageServiceImpl examManageServiceImpl

    def setup() {
        MockitoAnnotations.initMocks(this)
    }

    def "test find All"() {
        given:
        when(examManageMapper.findAll()).thenReturn([new ExamManage()])

        when:
        List<ExamManage> result = examManageServiceImpl.findAll()

        then:
        result == [new ExamManage()]
    }

    def "test find All 2"() {
        given:
        when(examManageMapper.findAll(any())).thenReturn(null)

        when:
        IPage<ExamManage> result = examManageServiceImpl.findAll(null)

        then:
        result == null
    }

    def "test find By Id"() {
        given:
        when(examManageMapper.findById(anyInt())).thenReturn(new ExamManage())

        when:
        ExamManage result = examManageServiceImpl.findById(0)

        then:
        result == new ExamManage()
    }

    def "test delete"() {
        given:
        when(examManageMapper.delete(anyInt())).thenReturn(0)

        when:
        int result = examManageServiceImpl.delete(0)

        then:
        result == 0
    }

    def "test update"() {
        given:
        when(examManageMapper.update(any())).thenReturn(0)

        when:
        int result = examManageServiceImpl.update(new ExamManage())

        then:
        result == 0
    }

    def "test add"() {
        given:
        when(examManageMapper.add(any())).thenReturn(0)

        when:
        int result = examManageServiceImpl.add(new ExamManage())

        then:
        result == 0
    }

    def "test find Only Paper Id"() {
        given:
        when(examManageMapper.findOnlyPaperId()).thenReturn(new ExamManage())

        when:
        ExamManage result = examManageServiceImpl.findOnlyPaperId()

        then:
        result == new ExamManage()
    }
}

