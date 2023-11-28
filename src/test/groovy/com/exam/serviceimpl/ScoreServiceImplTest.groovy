package com.exam.serviceimpl

import com.baomidou.mybatisplus.core.metadata.IPage
import com.exam.entity.Score
import com.exam.mapper.ScoreMapper
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class ScoreServiceImplTest extends Specification {
    @Mock
    ScoreMapper scoreMapper
    @InjectMocks
    ScoreServiceImpl scoreServiceImpl

    def setup() {
        MockitoAnnotations.initMocks(this)
    }

    def "test add"() {
        given:
        when(scoreMapper.add(any())).thenReturn(0)

        when:
        int result = scoreServiceImpl.add(new Score())

        then:
        result == 0
    }

    def "test find All"() {
        given:
        when(scoreMapper.findAll()).thenReturn([new Score()])

        when:
        List<Score> result = scoreServiceImpl.findAll()

        then:
        result == [new Score()]
    }

    def "test find By Id"() {
        given:
        when(scoreMapper.findById(any(), anyInt())).thenReturn(null)

        when:
        IPage<Score> result = scoreServiceImpl.findById(null, 0)

        then:
        result == null
    }

    def "test find By Id 2"() {
        given:
        when(scoreMapper.findById(anyInt())).thenReturn([new Score()])

        when:
        List<Score> result = scoreServiceImpl.findById(0)

        then:
        result == [new Score()]
    }

    def "test find By Exam Code"() {
        given:
        when(scoreMapper.findByExamCode(anyInt())).thenReturn([new Score()])

        when:
        List<Score> result = scoreServiceImpl.findByExamCode(0)

        then:
        result == [new Score()]
    }
}

