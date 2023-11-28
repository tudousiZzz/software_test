package com.exam.serviceimpl

import com.baomidou.mybatisplus.core.metadata.IPage
import com.exam.entity.Message
import com.exam.mapper.MessageMapper
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class MessageServiceImplTest extends Specification {
    @Mock
    MessageMapper messageMapper
    @InjectMocks
    MessageServiceImpl messageServiceImpl

    def setup() {
        MockitoAnnotations.initMocks(this)
    }

    def "test find All"() {
        given:
        when(messageMapper.findAll(any())).thenReturn(null)

        when:
        IPage<Message> result = messageServiceImpl.findAll(null)

        then:
        result == null
    }

    def "test find By Id"() {
        given:
        when(messageMapper.findById(anyInt())).thenReturn(new Message())

        when:
        Message result = messageServiceImpl.findById(0)

        then:
        result == new Message()
    }

    def "test delete"() {
        given:
        when(messageMapper.delete(anyInt())).thenReturn(0)

        when:
        int result = messageServiceImpl.delete(0)

        then:
        result == 0
    }

    def "test update"() {
        given:
        when(messageMapper.update(any())).thenReturn(0)

        when:
        int result = messageServiceImpl.update(new Message())

        then:
        result == 0
    }

    def "test add"() {
        given:
        when(messageMapper.add(any())).thenReturn(0)

        when:
        int result = messageServiceImpl.add(new Message())

        then:
        result == 0
    }
}

