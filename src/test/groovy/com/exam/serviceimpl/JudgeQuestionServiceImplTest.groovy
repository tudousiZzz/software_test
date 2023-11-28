package com.exam.serviceimpl

import com.baomidou.mybatisplus.core.metadata.IPage
import com.exam.entity.JudgeQuestion
import com.exam.mapper.JudgeQuestionMapper
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class JudgeQuestionServiceImplTest extends Specification {
    @Mock
    JudgeQuestionMapper judgeQuestionMapper
    @InjectMocks
    JudgeQuestionServiceImpl judgeQuestionServiceImpl

    def setup() {
        MockitoAnnotations.initMocks(this)
    }

    def "test find By Id And Type"() {
        given:
        when(judgeQuestionMapper.findByIdAndType(anyInt())).thenReturn([new JudgeQuestion()])

        when:
        List<JudgeQuestion> result = judgeQuestionServiceImpl.findByIdAndType(0)

        then:
        result == [new JudgeQuestion()]
    }

    def "test find All"() {
        given:
        when(judgeQuestionMapper.findAll(any())).thenReturn(null)

        when:
        IPage<JudgeQuestion> result = judgeQuestionServiceImpl.findAll(null)

        then:
        result == null
    }

    def "test find Only Question Id"() {
        given:
        when(judgeQuestionMapper.findOnlyQuestionId()).thenReturn(new JudgeQuestion())

        when:
        JudgeQuestion result = judgeQuestionServiceImpl.findOnlyQuestionId()

        then:
        result == new JudgeQuestion()
    }

    def "test add"() {
        given:
        when(judgeQuestionMapper.add(any())).thenReturn(0)

        when:
        int result = judgeQuestionServiceImpl.add(new JudgeQuestion())

        then:
        result == 0
    }

    def "test find By Subject"() {
        given:
        when(judgeQuestionMapper.findBySubject(anyString(), anyInt())).thenReturn([0])

        when:
        List<Integer> result = judgeQuestionServiceImpl.findBySubject("subject", 0)

        then:
        result == [0]
    }
}

