package com.exam.serviceimpl

import com.exam.entity.Replay
import com.exam.mapper.ReplayMapper
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class ReplayServiceImplTest extends Specification {
    @Mock
    ReplayMapper replayMapper
    @InjectMocks
    ReplayServiceImpl replayServiceImpl

    def setup() {
        MockitoAnnotations.initMocks(this)
    }

    def "test find All"() {
        given:
        when(replayMapper.findAll()).thenReturn([new Replay()])

        when:
        List<Replay> result = replayServiceImpl.findAll()

        then:
        result == [new Replay()]
    }

    def "test find All By Id"() {
        given:
        when(replayMapper.findAllById(anyInt())).thenReturn([new Replay()])

        when:
        List<Replay> result = replayServiceImpl.findAllById(0)

        then:
        result == [new Replay()]
    }

    def "test find By Id"() {
        given:
        when(replayMapper.findById(anyInt())).thenReturn(new Replay())

        when:
        Replay result = replayServiceImpl.findById(0)

        then:
        result == new Replay()
    }

    def "test delete"() {
        given:
        when(replayMapper.delete(anyInt())).thenReturn(0)

        when:
        int result = replayServiceImpl.delete(0)

        then:
        result == 0
    }

    def "test update"() {
        given:
        when(replayMapper.update(any())).thenReturn(0)

        when:
        int result = replayServiceImpl.update(new Replay())

        then:
        result == 0
    }

    def "test add"() {
        given:
        when(replayMapper.add(any())).thenReturn(0)

        when:
        int result = replayServiceImpl.add(new Replay())

        then:
        result == 0
    }
}

