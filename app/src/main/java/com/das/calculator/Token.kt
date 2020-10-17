package com.das.calculator

class Token(type: String, data: Number?=null) {
    val tokType = type
    val tokData = data

    override fun toString(): String {
        return  when(tokData) {
            is Number -> "$tokType:$tokData"
            else -> tokType
        }
    }
}