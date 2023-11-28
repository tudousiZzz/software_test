package com.exam.serviceimpl

import com.baomidou.mybatisplus.core.metadata.IPage
import com.exam.mapper.AnswerMapper
import com.exam.vo.AnswerVO
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class AnswerServiceImplTest extends Specification {
    @Mock
    AnswerMapper answerMapper
    @InjectMocks
    AnswerServiceImpl answerServiceImpl

    def setup() {
        MockitoAnnotations.initMocks(this)
    }

    def "test find All"() {
        given:
        when(answerMapper.findAll(any())).thenReturn(null)

        when:
        IPage<AnswerVO> result = answerServiceImpl.findAll(null)

        then:
        result == null
    }
}

