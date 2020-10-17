package com.das.calculator

abstract class Error(errorDetail: String) {
    protected val details = errorDetail

    fun getErrorDetails(): String {
        return details
    }
}

class IllegalCharError(errorDetail: String) : Error(errorDetail)
class IllegalSyntaxError(errorDetail: String): Error(errorDetail)