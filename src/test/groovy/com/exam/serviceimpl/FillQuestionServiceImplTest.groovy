package com.exam.serviceimpl

import com.baomidou.mybatisplus.core.metadata.IPage
import com.exam.entity.FillQuestion
import com.exam.mapper.FillQuestionMapper
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class FillQuestionServiceImplTest extends Specification {
    @Mock
    FillQuestionMapper fillQuestionMapper
    @InjectMocks
    FillQuestionServiceImpl fillQuestionServiceImpl

    def setup() {
        MockitoAnnotations.initMocks(this)
    }

    def "test find By Id And Type"() {
        given:
        when(fillQuestionMapper.findByIdAndType(anyInt())).thenReturn([new FillQuestion()])

        when:
        List<FillQuestion> result = fillQuestionServiceImpl.findByIdAndType(0)

        then:
        result == [new FillQuestion()]
    }

    def "test find All"() {
        given:
        when(fillQuestionMapper.findAll(any())).thenReturn(null)

        when:
        IPage<FillQuestion> result = fillQuestionServiceImpl.findAll(null)

        then:
        result == null
    }

    def "test find Only Question Id"() {
        given:
        when(fillQuestionMapper.findOnlyQuestionId()).thenReturn(new FillQuestion())

        when:
        FillQuestion result = fillQuestionServiceImpl.findOnlyQuestionId()

        then:
        result == new FillQuestion()
    }

    def "test add"() {
        given:
        when(fillQuestionMapper.add(any())).thenReturn(0)

        when:
        int result = fillQuestionServiceImpl.add(new FillQuestion())

        then:
        result == 0
    }

    def "test find By Subject"() {
        given:
        when(fillQuestionMapper.findBySubject(anyString(), anyInt())).thenReturn([0])

        when:
        List<Integer> result = fillQuestionServiceImpl.findBySubject("subject", 0)

        then:
        result == [0]
    }
}

