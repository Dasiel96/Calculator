package com.das.calculator.types.numbers

import com.das.calculator.TT_DOUBLE
import com.das.calculator.TT_FLOAT
import com.das.calculator.TT_INT
import com.das.calculator.types.NumberType

class IntType(private val num: Int): NumberType {

    override fun add(other: NumberType): NumberType {
        return when(other.getType()) {
            TT_INT -> IntType(num + other.getVal() as Int)
            TT_FLOAT -> FloatType(num + other.getVal() as Float)
            TT_DOUBLE -> DoubleType(num + other.getVal() as Double)
            else -> IntType(0)
        }
    }

    override fun subtract(other: NumberType): NumberType {
        return when(other.getType()){
            TT_INT -> IntType(num - other.getVal() as Int)
            TT_FLOAT -> FloatType(num - other.getVal() as Float)
            TT_DOUBLE -> DoubleType(num - other.getVal() as Double)
            else -> IntType(0)
        }
    }

    override fun multiply(other: NumberType): NumberType {
        return when(other.getType()) {
            TT_INT -> IntType(num * other.getVal() as Int)
            TT_FLOAT -> FloatType(num * other.getVal() as Float)
            TT_DOUBLE -> DoubleType(num * other.getVal() as Double)
            else -> IntType(0)
        }
    }

    override fun divide(other: NumberType): NumberType {
        return when(other.getType()) {
            TT_INT -> IntType(num / other.getVal() as Int)
            TT_FLOAT -> FloatType(num / other.getVal() as Float)
            TT_DOUBLE -> DoubleType(num / other.getVal() as Double)
            else -> IntType(0)
        }
    }

    override fun getVal(): Number {
        return num
    }

    override fun getType(): String {
        return TT_INT
    }
}