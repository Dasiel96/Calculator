package com.das.calculator

interface Node {
    fun tokenType(): String
    fun tokenVal(): Number?
}

class NumberNode(token: Token): Node  {
    val tok = token

    override fun tokenType(): String {
        return tok.tokType
    }

    override fun tokenVal(): Number? {
        return tok.tokData
    }

    override fun toString(): String {
        return tok.toString()
    }
}

class BinOpNode(token: Token, lNode: Node, rNode: Node): Node {
    val tok = token
    val leftNode = lNode
    val rightNode = rNode

    override fun tokenType(): String {
        return tok.tokType
    }

    override fun tokenVal(): Number? {
        return tok.tokData
    }

    override fun toString(): String {
        return "($leftNode $tok $rightNode)"
    }
}

class UnaryOpNode(op: String, node: NumberNode): Node {
    val tok = op
    val opNode = node

    override fun tokenType(): String {
        return tok
    }

    override fun tokenVal(): Number? {
        return opNode.tokenVal()
    }
}