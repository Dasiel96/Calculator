package com.das.calculator

const val TT_PLUS = "PLUS"
const val TT_MINUS = "MINUS"
const val TT_MUL = "MUL"
const val TT_DIV = "DIV"
const val TT_LPAREN = "LPAREN"
const val TT_RPAREN = "RPAREN"
const val TT_WHITE_SPACES = " \t"
const val DIGITS = "0123456789"
const val TT_EOF = "EOF"
const val TT_INT = "INT"
const val TT_FLOAT = "FLOAT"
const val TT_DOUBLE = "DOUBLE"
const val TT_ERROR = "ERROR"
const val TT_FLOAT_SIZE = 8

val TYPE_DICT = HashMap<Char, String>().apply {
    set('+', TT_PLUS)
    set('-', TT_MINUS)
    set('*', TT_MUL)
    set('/', TT_DIV)
    set('(', TT_LPAREN)
    set(')', TT_RPAREN)
}