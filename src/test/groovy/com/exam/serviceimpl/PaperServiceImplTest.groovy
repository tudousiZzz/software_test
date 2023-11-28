package com.exam.serviceimpl

import com.exam.entity.PaperManage
import com.exam.mapper.PaperMapper
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class PaperServiceImplTest extends Specification {
    @Mock
    PaperMapper paperMapper
    @InjectMocks
    PaperServiceImpl paperServiceImpl

    def setup() {
        MockitoAnnotations.initMocks(this)
    }

    def "test find All"() {
        given:
        when(paperMapper.findAll()).thenReturn([new PaperManage(0, 0, 0)])

        when:
        List<PaperManage> result = paperServiceImpl.findAll()

        then:
        result == [new PaperManage(0, 0, 0)]
    }

    def "test find By Id"() {
        given:
        when(paperMapper.findById(anyInt())).thenReturn([new PaperManage(0, 0, 0)])

        when:
        List<PaperManage> result = paperServiceImpl.findById(0)

        then:
        result == [new PaperManage(0, 0, 0)]
    }

    def "test add"() {
        given:
        when(paperMapper.add(any())).thenReturn(0)

        when:
        int result = paperServiceImpl.add(new PaperManage(0, 0, 0))

        then:
        result == 0
    }
}

