package com.das.calculator

import android.util.Log

class NumberDataType(numVal: Number) {

    private val addOp = '+'
    private val subtractOp = '-'
    private val mulOp = '*'
    private val divOp = '/'
    private val value: Number = numVal

    private operator fun Number.plus (otherOpVal: Number): Number {
        return calc(addOp, otherOpVal)
    }

    private operator fun Number.minus(otherOpVal: Number): Number {
        return calc(subtractOp, otherOpVal)
    }

    private operator fun Number.times(otherOpVal: Number): Number {
        return calc(mulOp, otherOpVal)
    }

    private operator fun Number.div(otherOpVal: Number): Number {
        return calc(divOp, otherOpVal)
    }

    operator fun plus(other: NumberDataType): NumberDataType {
        return NumberDataType(value + other.value)
    }

    operator fun minus(other: NumberDataType): NumberDataType {
        return NumberDataType(value - other.value)
    }

    operator fun times(other: NumberDataType): NumberDataType {
        return NumberDataType(value * other.value)
    }

    operator fun div(other: NumberDataType): NumberDataType {
        return NumberDataType(value / other.value)
    }

    private fun calc(oper: Char, otherVal: Number): Number {
        var internalIntVal: Int? = null
        var internalFloatVal: Float? = null
        var internalDoubleVal: Double? = null

        when (value) {
            is Int -> internalIntVal = value
            is Float -> internalFloatVal = value
            is Double -> internalDoubleVal = value
        }

        val calcOperType = fun(operation: Char, intNum: Int?, floatNum: Float?, doubleNum: Double?): Number {
            return if (internalIntVal != null) {
                when (operation) {
                    addOp -> {
                        when {
                            intNum is Int -> internalIntVal + intNum
                            floatNum is Float -> internalIntVal + floatNum
                            doubleNum is Double -> internalIntVal + doubleNum
                            else -> 0
                        }
                    }
                    subtractOp -> {
                        when {
                            intNum is Int -> internalIntVal - intNum
                            floatNum is Float -> internalIntVal - floatNum
                            doubleNum is Double -> internalIntVal - doubleNum
                            else -> 0
                        }
                    }
                    mulOp -> {
                        when {
                            intNum is Int -> internalIntVal * intNum
                            floatNum is Float -> internalIntVal * floatNum
                            doubleNum is Double -> internalIntVal * doubleNum
                            else -> 0
                        }
                    }
                    divOp -> {
                        when {
                            intNum is Int -> internalIntVal / intNum.toDouble()
                            floatNum is Float -> internalIntVal / floatNum
                            doubleNum is Double -> internalIntVal / doubleNum
                            else -> 0
                        }
                    }
                    else -> 0
                }
            }
            else if (internalFloatVal != null) {
                when (operation) {
                    addOp -> {
                        when {
                            intNum is Int -> internalFloatVal + intNum
                            floatNum is Float -> internalFloatVal + floatNum
                            doubleNum is Double -> internalFloatVal + doubleNum
                            else -> 0
                        }
                    }
                    subtractOp -> {
                        when {
                            intNum is Int -> internalFloatVal - intNum
                            floatNum is Float -> internalFloatVal - floatNum
                            doubleNum is Double -> internalFloatVal - doubleNum
                            else -> 0
                        }
                    }
                    mulOp -> {
                        when {
                            intNum is Int -> internalFloatVal * intNum
                            floatNum is Float -> internalFloatVal * floatNum
                            doubleNum is Double -> internalFloatVal * doubleNum
                            else -> 0
                        }
                    }
                    divOp -> {
                        when {
                            intNum is Int -> internalFloatVal / intNum.toDouble()
                            floatNum is Float -> internalFloatVal / floatNum
                            doubleNum is Double -> internalFloatVal / doubleNum
                            else -> 0
                        }
                    }
                    else -> 0
                }

            }
            else if (internalDoubleVal != null) {
                when (operation) {
                    addOp -> {
                        when {
                            intNum is Int -> internalDoubleVal + intNum
                            floatNum is Float -> internalDoubleVal + floatNum
                            doubleNum is Double -> internalDoubleVal + doubleNum
                            else -> 0
                        }
                    }
                    subtractOp -> {
                        when {
                            intNum is Int -> internalDoubleVal - intNum
                            floatNum is Float -> internalDoubleVal - floatNum
                            doubleNum is Double -> internalDoubleVal - doubleNum
                            else -> 0
                        }
                    }
                    mulOp -> {
                        when {
                            intNum is Int -> internalDoubleVal * intNum
                            floatNum is Float -> internalDoubleVal * floatNum
                            doubleNum is Double -> internalDoubleVal * doubleNum
                            else -> 0
                        }
                    }
                    divOp -> {
                        when {
                            intNum is Int -> internalDoubleVal / intNum.toDouble()
                            floatNum is Float -> internalDoubleVal / floatNum
                            doubleNum is Double -> internalDoubleVal / doubleNum
                            else -> 0
                        }
                    }
                    else -> 0
                }
            }
            else {
                0
            }
        }

        val calcIntOperType = fun(operation: Char, otherNum: Int): Number {
            return calcOperType(operation, otherNum, null, null)
        }

        val calcFloatOperType = fun(operation: Char, otherNum: Float): Number {
            return calcOperType(operation, null, otherNum, null)
        }

        val calcDoubleOperType = fun (operation: Char, otherNum: Double): Number {
            return calcOperType(operation, null, null, otherNum)
        }

        val checkOtherTypeAndCalc = fun(otherNum: Number): Number {
            return  when (otherNum) {
                is Int -> calcIntOperType(oper, otherNum)
                is Float -> calcFloatOperType(oper, otherNum)
                is Double -> calcDoubleOperType(oper, otherNum)
                else -> 0
            }
        }
        return when(value) {
            is Int -> checkOtherTypeAndCalc(otherVal)
            is Float -> checkOtherTypeAndCalc(otherVal)
            is Double -> checkOtherTypeAndCalc(otherVal)
            else -> 0
        }
    }

    override fun toString(): String {
        var numParts = value.toString().split(".")
        var rep = ""

        var isntPlaceHolder = false

        if (numParts.size > 1) {
            for (digits in numParts[1]) {
                if (digits != '0') {
                    isntPlaceHolder = true
                    break
                }
            }
        }

        if (isntPlaceHolder) {
            rep = "${numParts[0]}.${numParts[1]}"
        }
        else {
            rep = numParts[0]
        }

        return rep
    }

}



