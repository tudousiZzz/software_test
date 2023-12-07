package com.exam.serviceimpl

import com.baomidou.mybatisplus.core.metadata.IPage
import com.exam.entity.Student
import com.exam.mapper.StudentMapper
import spock.lang.*
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import static org.mockito.Mockito.*

class StudentServiceImplTest extends Specification {
    @Mock
    StudentMapper studentMapper
    @InjectMocks
    StudentServiceImpl studentServiceImpl

    def setup() {
        MockitoAnnotations.initMocks(this)
    }

    def "test find All"() {
        given:
        when(studentMapper.findAll(any())).thenReturn(null)

        when:
        IPage<Student> result = studentServiceImpl.findAll(null)

        then:
        result == null
    }

    def "test find By Id"() {
        given:
        when(studentMapper.findById(anyInt())).thenReturn(new Student(studentId: 0))

        when:
        Student result = studentServiceImpl.findById(0)

        then:
        result.getStudentId() == 0
    }

    def "test delete By Id"() {
        given:
        when(studentMapper.deleteById(anyInt())).thenReturn(0)

        when:
        int result = studentServiceImpl.deleteById(0)

        then:
        result == 0
    }

    def "test update"() {
        given:
        when(studentMapper.update(any())).thenReturn(0)

        when:
        int result = studentServiceImpl.update(new Student())

        then:
        result == 0
    }

    def "test update Pwd"() {
        given:
        when(studentMapper.updatePwd(any())).thenReturn(0)

        when:
        int result = studentServiceImpl.updatePwd(new Student())

        then:
        result == 0
    }

    def "test add"() {
        given:
        when(studentMapper.add(any())).thenReturn(0)

        when:
        int result = studentServiceImpl.add(new Student())

        then:
        result == 0
    }

    @Unroll
    def "input 学生id:#id, 返回的学生姓名:#Name, 返回的成绩的两倍:#gradeMultiTwo"() {
        given: "Mock返回的学生信息"
        when(studentMapper.findById(anyInt())).thenReturn(student)

        when: "获取学生信息"
        def result = studentServiceImpl.findById(id)

        then: "验证返回结果"
        with(result) {
            studentName == Name
            grade == gradeMultiTwo
        }
        where: "经典之处：表格方式验证学生信息的分支场景"
        id | student                   || Name  | gradeMultiTwo
        1  | getStudent(1, "张三", "60") || "张三" | "120"
        2  | getStudent(2, "李四", "40") || "李四" | "80"
    }

    def getStudent(def id, def name, def grade) {
        return new Student(studentId: id, studentName: name, grade: grade)
    }
}

