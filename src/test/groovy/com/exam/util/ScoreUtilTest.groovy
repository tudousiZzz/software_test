package com.exam.util

import com.exam.entity.Score
import spock.lang.*

class ScoreUtilTest extends Specification {

    def "test check"() {
        given:
        def score = new Score()
        score.setPtScore(40)
        score.setEtScore(60)
        when:
        boolean result = ScoreUtil.check(score)

        then:
        result == true
    }

    def "test check1"() {
        given:
        def score = new Score()
        score.setPtScore(0)
        score.setEtScore(0)
        when:
        boolean result = ScoreUtil.check(score)

        then:
        result == true
    }

    def "test check2"() {
        given:
        def score = new Score()
        score.setPtScore(20)
        score.setEtScore(40)
        when:
        boolean result = ScoreUtil.check(score)

        then:
        result == true
    }

    def "test sum Score"() {
        given:
        def score = new Score()
        score.setPtScore(20)
        score.setEtScore(40)

        when:
        Integer result = ScoreUtil.sumScore(score)

        then:
        result == 60
    }
}

