package com.das.calculator

import com.das.calculator.types.NumberType

class Interpreter {
    fun visit(node: Node): NumberType {
        return when (node) {
            is BinOpNode -> binOp(node)
            is NumberNode -> numberOp(node)
            else -> null
        }
    }

    fun binOp(node: BinOpNode): NumberType {
        var result: NumberDataType? = null
        val left = visit(node.leftNode)
        val right = visit(node.rightNode)

        when (node.tok.tokType) {
            TT_PLUS -> result = left.add(right)
            TT_MINUS -> result = left - right
            TT_MUL -> result = left * right
            TT_DIV -> result = left / right
        }


        return result
    }

    fun numberOp(node: NumberNode): NumberDataType? {
        var number: NumberDataType? = null
        if (node.tok.tokData != null) {
            number = NumberDataType(node.tok.tokData)
        }
        return number
    }

}