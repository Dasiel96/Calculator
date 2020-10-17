package com.das.calculator.types.numbers

import com.das.calculator.TT_DOUBLE
import com.das.calculator.TT_FLOAT
import com.das.calculator.TT_FLOAT_SIZE
import com.das.calculator.TT_INT
import com.das.calculator.types.NumberType

class FloatType(private val num: Float): NumberType {

    override fun add(other: NumberType): NumberType {
        return when {
            num % 1 == 0f && other.getType() == TT_INT -> {
                IntType(num.toInt() + other.getVal() as Int)
            }
            other.getType() == TT_INT -> {
                FloatType(num + other.getVal() as Int)
            }
            other.getType() == TT_FLOAT -> {
                FloatType(num + other.getVal() as Float)
            }
            other.getType() == TT_DOUBLE -> {
                DoubleType(num + other.getVal() as Double)
            }
            else -> FloatType(0f)
        }
    }

    override fun subtract(other: NumberType): NumberType {
        return when {
            num % 1 == 0f && other.getType() == TT_INT -> {
                IntType(num.toInt() - other.getVal() as Int)
            }
            other.getType() == TT_INT -> {
                FloatType(num - other.getVal() as Int)
            }
            other.getType() == TT_FLOAT -> {
                FloatType(num - other.getVal() as Float)
            }
            other.getType() == TT_DOUBLE -> {
                DoubleType(num - other.getVal() as Double)
            }
            else -> FloatType(0f)
        }
    }

    override fun multiply(other: NumberType): NumberType {
        return when {
            num % 1 == 0f && other.getType() == TT_INT -> {
                IntType(num.toInt() * other.getVal() as Int)
            }
            other.getType() == TT_INT -> {
                FloatType(num * other.getVal() as Int)
            }
            other.getType() == TT_FLOAT -> {
                FloatType(num * other.getVal() as Float)
            }
            other.getType() == TT_DOUBLE -> {
                DoubleType(num * other.getVal() as Double)
            }
            else -> FloatType(0f)
        }
    }

    override fun divide(other: NumberType): NumberType {
        val type: String
        val res = when (other.getType()) {
            TT_INT -> {
                type = TT_INT
                num / other.getVal() as Int
            }
            TT_FLOAT -> {
                type = TT_FLOAT
                num / other.getVal() as Float
            }
            TT_DOUBLE  -> {
                type = TT_DOUBLE
                num / other.getVal() as Double
            }
            else -> {
                type = TT_FLOAT
                0f
            }
        }

        return when(type){
            TT_INT -> {
                when {
                    res.toDouble() % 1 == 0.toDouble() -> IntType(res.toInt())
                    res.toString().length <= TT_FLOAT_SIZE -> FloatType(res.toFloat())
                    res.toString().length > TT_FLOAT_SIZE -> DoubleType(res.toDouble())
                    else -> FloatType(res.toFloat())
                }
            }
            TT_FLOAT -> {
                when {
                    res.toDouble() % 1 == 0.toDouble() -> IntType(res.toInt())
                    res.toString().length <= TT_FLOAT_SIZE -> FloatType(res.toFloat())
                    res.toString().length > TT_FLOAT_SIZE -> DoubleType(res.toDouble())
                    else -> FloatType(res.toFloat())
                }
            }
            TT_DOUBLE -> DoubleType(res.toDouble())
            else -> FloatType(0f)
        }
    }

    override fun getVal(): Number {
        return num
    }

    override fun getType(): String {
        return TT_FLOAT
    }
}