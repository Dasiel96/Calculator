package com.das.calculator.types

interface NumberType {
    fun add(other: NumberType): NumberType
    fun subtract(other: NumberType): NumberType
    fun multiply(other: NumberType): NumberType
    fun divide(other: NumberType): NumberType
    fun getVal(): Number
    fun getType(): String
}