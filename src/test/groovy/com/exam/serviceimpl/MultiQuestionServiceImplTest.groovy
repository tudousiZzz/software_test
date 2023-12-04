package com.exam.serviceimpl

import com.baomidou.mybatisplus.core.metadata.IPage
import com.exam.entity.MultiQuestion
import com.exam.mapper.MultiQuestionMapper
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class MultiQuestionServiceImplTest extends Specification {
    @Mock
    MultiQuestionMapper multiQuestionMapper
    @InjectMocks
    MultiQuestionServiceImpl multiQuestionServiceImpl

    def setup() {
        MockitoAnnotations.initMocks(this)
    }

    def "test find By Id And Type"() {
        given:
        when(multiQuestionMapper.findByIdAndType(anyInt())).thenReturn([new MultiQuestion()])

        when:
        List<MultiQuestion> result = multiQuestionServiceImpl.findByIdAndType(0)

        then:
        result == [new MultiQuestion()]
    }

    def "test find All"() {
        given:
        when(multiQuestionMapper.findAll(any())).thenReturn(null)

        when:
        IPage<MultiQuestion> result = multiQuestionServiceImpl.findAll(null)

        then:
        result == null
    }

    def "test find Only Question Id"() {
        given:
        when(multiQuestionMapper.findOnlyQuestionId()).thenReturn(new MultiQuestion())

        when:
        MultiQuestion result = multiQuestionServiceImpl.findOnlyQuestionId()

        then:
        result == new MultiQuestion()
    }

    def "test add"() {
        given:
        when(multiQuestionMapper.add(any())).thenReturn(0)

        when:
        int result = multiQuestionServiceImpl.add(new MultiQuestion())

        then:
        result == 0
    }

    def "test find By Subject"() {
        given:
        when(multiQuestionMapper.findBySubject(anyString(), anyInt())).thenReturn([0])

        when:
        List<Integer> result = multiQuestionServiceImpl.findBySubject("subject", 0)

        then:
        result == [0]
    }

    def "test find By Subject Score"() {

        given:
        when(multiQuestionMapper.findBySubject(anyString(), anyInt())).thenReturn([0])

        when:
        def pageNo = -1;
        List<Integer> result = multiQuestionServiceImpl.findBySubject("subject", pageNo)

        then:
        result == [0]
    }

}

