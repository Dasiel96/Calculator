package com.das.calculator

import com.das.calculator.types.NumberType
import com.das.calculator.types.numbers.DoubleType
import com.das.calculator.types.numbers.FloatType
import com.das.calculator.types.numbers.IntType

class Interpreter {
    fun visit(node: Node): NumberType {
        return when (node) {
            is BinOpNode -> binOp(node)
            is NumberNode -> numberOp(node)
            else -> IntType(0)
        }
    }

    fun binOp(node: BinOpNode): NumberType {
        var result: NumberType = IntType(0)
        val left = visit(node.leftNode)
        val right = visit(node.rightNode)

        when (node.tok.tokType) {
            TT_PLUS -> result = left.add(right)
            TT_MINUS -> result = left.subtract(right)
            TT_MUL -> result = left.multiply(right)
            TT_DIV -> result = left.divide(right)
        }


        return result
    }

    fun numberOp(node: NumberNode): NumberType {
       return when(node.tok.tokType) {
           TT_INT -> IntType(node.tok.tokData!! as Int)
           TT_FLOAT -> FloatType(node.tok.tokData!! as Float)
           TT_DOUBLE -> DoubleType(node.tok.tokData!! as Double)
           else -> IntType(0)
       }
    }

}