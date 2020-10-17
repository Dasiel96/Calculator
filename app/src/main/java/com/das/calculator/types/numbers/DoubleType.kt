package com.das.calculator.types.numbers

import com.das.calculator.TT_DOUBLE
import com.das.calculator.TT_FLOAT
import com.das.calculator.TT_INT
import com.das.calculator.types.NumberType

class DoubleType(private val num: Double) : NumberType {

    private fun isInt(): Boolean {
        return num % 1 == 0.0
    }

    override fun add(other: NumberType): NumberType {
        return when {
            other.getType() == TT_INT && isInt() -> IntType((num + other.getVal() as Int).toInt())
            other.getType() == TT_INT -> DoubleType(num + other.getVal() as Int)
            other.getType() == TT_FLOAT -> DoubleType(num + other.getVal() as Float)
            other.getType() == TT_DOUBLE -> DoubleType(num + other.getVal() as Double)
            else -> DoubleType(0.0)
        }
    }

    override fun subtract(other: NumberType): NumberType {
        return when {
            other.getType() == TT_INT && isInt() -> IntType((num - other.getVal() as Int).toInt())
            other.getType() == TT_INT -> DoubleType(num - other.getVal() as Int)
            other.getType() == TT_FLOAT -> DoubleType(num - other.getVal() as Float)
            other.getType() == TT_DOUBLE -> DoubleType(num - other.getVal() as Double)
            else -> DoubleType(0.0)
        }
    }

    override fun multiply(other: NumberType): NumberType {
        return when {
            other.getType() == TT_INT && isInt() -> IntType((num * other.getVal() as Int).toInt())
            other.getType() == TT_INT -> DoubleType(num * other.getVal() as Int)
            other.getType() == TT_FLOAT -> DoubleType(num * other.getVal() as Float)
            other.getType() == TT_DOUBLE -> DoubleType(num * other.getVal() as Double)
            else -> DoubleType(0.0)
        }
    }

    override fun divide(other: NumberType): NumberType {
        TODO("Not yet implemented")
    }

    override fun getVal(): Number {
        return num
    }

    override fun getType(): String {
        return TT_DOUBLE
    }
}