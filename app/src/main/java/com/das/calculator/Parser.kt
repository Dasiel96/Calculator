package com.das.calculator

import android.util.Log

class ParseResult(err: Error?=null, node: Node?=null) {

    var err = err
        private set
    var node = node
        private set

    fun success(node: Node) {
        this.node = node
    }

    fun failure(err: Error) {
        this.err = err
    }

    fun register(result: ParseResult) {
        if (result.err != null) {
            err = result.err
        }
        else if (result.node != null) {
            node = result.node
        }
    }

    override fun toString(): String {
        return when {
            node != null -> node.toString()
            err != null -> err!!.getErrorDetails()
            else -> "null"
        }
    }
}

class Parser(tokList: ArrayList<Token>) {
    private val tokenList = tokList
    private var tokenIndex = 0
    private var curTok: Token?

    init {
        curTok = if (tokenList.isNotEmpty()){
            tokenList[tokenIndex]
        }
        else {
            null
        }
    }

    private fun advance() {
        tokenIndex++

        if (tokenIndex < tokenList.size) {
            curTok = tokenList[tokenIndex]
        }
        else {
            curTok = null
        }
    }

    private fun binOpProcess(func: () -> ParseResult, ops: Array<String>): ParseResult {
        var left = func()

        while (left.err == null && curTok != null && curTok?.tokType in ops) {
            val opTok = curTok
            advance()
            val right= func()
            if (right.err == null && right.node != null && opTok != null && left.node != null) {
                left = ParseResult(null, BinOpNode(opTok, left.node!!, right.node!!))
            }
            else {
                left.failure(IllegalSyntaxError("Invalid input"))
                break
            }
        }

        return  left
    }

    private fun expr(): ParseResult {
        val left = binOpProcess(::term, arrayOf(TT_PLUS, TT_MINUS))
        Log.d("PARENT_AST_NODE", "output: $left")
        return left
    }

    private fun term(): ParseResult {
        return binOpProcess(::factor, arrayOf(TT_MUL, TT_DIV))
    }

    private fun factor(): ParseResult {
        val numNode = ParseResult()
        if (curTok?.tokType in listOf(TT_INT, TT_FLOAT, TT_DOUBLE)) {
            numNode.success(NumberNode(curTok!!))
            advance()
        }
        else if (curTok?.tokType == TT_LPAREN) {
            advance()
            val expression = expr()

            if (curTok?.tokType != TT_RPAREN) {
                numNode.failure(IllegalSyntaxError("Invalid input"))
            }
            else {
                numNode.register(expression)
                advance()
            }
        }
        else {
            numNode.failure(IllegalSyntaxError("invalid input"))
        }
        return numNode
    }

    fun parse(): ParseResult {
       return expr()
    }
}