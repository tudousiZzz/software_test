package com.exam.util

import spock.lang.*

class StackSpecUtilTest extends Specification {
    def stack = new Stack()

    def "size"() {
        expect:
        stack.size() == 0
    }

    def "pop"() {
        when:
        stack.pop()
        then:
        thrown(EmptyStackException)
    }

    def "peek"() {
        when:
        stack.peek()
        then:
        thrown(EmptyStackException)
    }

    def "push"() {
        when:
        stack.push("elem")

        then:
        stack.size() == old(stack.size()) + 1
        stack.peek() == "elem"
    }

    def stack1 = new Stack()
    def stack2 = new Stack()

    def setup() {
        stack1.push("elem")
        ["elem1", "elem2", "elem3"].each {
            stack2.push(it)
        }
    }

    def "size1"() {
        expect:
        stack1.size() == 1
    }

    def "pop1"() {
        when:
        def x = stack1.pop()

        then:
        x == "elem"
        stack1.size() == 0
    }

    def "peek1"() {
        when:
        def x = stack1.peek()

        then:
        x == "elem"
        stack1.size() == 1
    }

    def "push1"() {
        when:
        stack1.push("elem2")

        then:
        stack1.size() == 2
        stack1.peek() == "elem2"
    }

    def "size2"() {
        expect:
        stack2.size() == 3
    }

    def "pop2"() {
        expect:
        stack2.pop() == "elem3"
        stack2.pop() == "elem2"
        stack2.pop() == "elem1"
        stack2.size() == 0
    }

    def "peek2"() {
        expect:
        stack2.peek() == "elem3"
        stack2.peek() == "elem3"
        stack2.peek() == "elem3"
        stack2.size() == 3
    }

    def "push2"() {
        when:
        stack2.push("elem4")

        then:
        stack2.size() == 4
        stack2.peek() == "elem4"
    }
}

