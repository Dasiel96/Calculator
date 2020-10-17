package com.das.calculator

import android.util.Log
import java.lang.StringBuilder

class Lexer(text: String) {
    private var inputText: String = text
    private var textIndex: Int = 0
    private var curChar: Char?

    init {
        curChar = if (text.isNotEmpty()) {
            text[textIndex]
        } else {
            null
        }
    }

    private fun advance() {
        textIndex++

        curChar = if (textIndex < inputText.length) {
            inputText[textIndex]
        } else {
            null
        }
    }

    private fun makeNumberToken(): Token {
        var dotCount = 0
        var numsAfterPeriod = 0
        val numberText = StringBuilder()
        val token: Token

        while (curChar != null && curChar!! in "$DIGITS.") {
            if (curChar == '.') {
                dotCount++
                if (dotCount > 1) {
                    numberText.clear()
                    break
                }
                if (numberText.isEmpty()) {
                    numberText.append('0')
                }
                numberText.append(curChar)
            } else {
                numberText.append(curChar)
            }
            advance()
        }

        token = when (dotCount) {
            0 -> Token(TT_INT, numberText.toString().toInt())
            1 -> Token(TT_DOUBLE, numberText.toString().toDouble())
            else -> Token(TT_ERROR)
        }

        return token
    }

    fun makeTokens(): ArrayList<Token> {
        val tokenList = ArrayList<Token>()

        while (curChar != null) {
            when (curChar!!) {
                in TT_WHITE_SPACES -> {
                    advance()
                }
                in TYPE_DICT -> {
                    val type = TYPE_DICT[curChar]
                    if (type != null) {
                        val token = Token(type)
                        tokenList.add(token)
                        advance()
                    }
                }
                in "$DIGITS." -> {
                    val token = makeNumberToken()
                    tokenList.add(token)
                    if (token.tokType == TT_ERROR) {
                        break
                    }
                }
                else -> {
                    tokenList.add(Token(TT_ERROR))
                    break
                }
            }
        }

        if (tokenList.last().tokType != TT_ERROR) {
            tokenList.add(Token(TT_EOF))
        }

        Log.d("TOKEN_LIST_OUTPUT", tokenList.toString())
        return tokenList
    }

}