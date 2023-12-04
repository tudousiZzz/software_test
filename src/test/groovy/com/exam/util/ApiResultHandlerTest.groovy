package com.exam.util

import com.exam.entity.ApiResult
import spock.lang.*

class ApiResultHandlerTest<T> extends Specification {

    def "test success"() {
        when:
        ApiResult result = ApiResultHandler.success("object")

        then:
        result.message == "请求成功"
    }

    def "test success 2"() {
        when:
        ApiResult result = ApiResultHandler.success()

        then:
        result.getCode() == 200
    }

    def  "test build Api Result"() {
        when:
        T data;
        ApiResult result = ApiResultHandler.buildApiResult(0, "message", data)

        then:
        result.getMessage() == "message"
    }
}

