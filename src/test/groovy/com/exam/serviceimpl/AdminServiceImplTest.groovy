package com.exam.serviceimpl

import com.exam.entity.Admin
import com.exam.mapper.AdminMapper
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class AdminServiceImplTest extends Specification {
    @Mock
    AdminMapper adminMapper
    @InjectMocks
    AdminServiceImpl adminServiceImpl

    def setup() {
        MockitoAnnotations.initMocks(this)
    }

    def "test find All"() {
        given:
        when(adminMapper.findAll()).thenReturn([new Admin()])

        when:
        List<Admin> result = adminServiceImpl.findAll()

        then:
        result == [new Admin()]
    }

    def "test find By Id"() {
        given:
        when(adminMapper.findById(anyInt())).thenReturn(new Admin())

        when:
        Admin result = adminServiceImpl.findById(0)

        then:
        result == new Admin()
    }

    def "test delete By Id"() {
        given:
        when(adminMapper.deleteById(anyInt())).thenReturn(0)

        when:
        int result = adminServiceImpl.deleteById(0)

        then:
        result == 0
    }

    def "test update"() {
        given:
        when(adminMapper.update(any())).thenReturn(0)

        when:
        int result = adminServiceImpl.update(new Admin())

        then:
        result == 0
    }

    def "test add"() {
        when:
        int result = adminServiceImpl.add(new Admin())

        then:
        result == 0
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme