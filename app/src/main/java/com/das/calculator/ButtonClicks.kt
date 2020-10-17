package com.das.calculator

import android.app.Activity
import android.widget.Button
import android.widget.TextView
import java.lang.StringBuilder

class ButtonClicks(private val view: Activity) {
    private val zeroBtnText by lazy {
        view.findViewById<Button>(R.id.btn_0).text.toString()
    }

    private val oneBtnText by lazy {
        view.findViewById<Button>(R.id.btn_1).text.toString()
    }

    private val twoBtnText by lazy {
        view.findViewById<Button>(R.id.btn_2).text.toString()
    }

    private val threeBtnText by lazy {
        view.findViewById<Button>(R.id.btn_3).text.toString()
    }

    private val fourBtnText by lazy {
        view.findViewById<Button>(R.id.btn_4).text.toString()
    }

    private val fiveBtnText by lazy {
        view.findViewById<Button>(R.id.btn_5).text.toString()
    }

    private val sixBtnText by lazy {
        view.findViewById<Button>(R.id.btn_6).text.toString()
    }

    private val sevenBtnText by lazy {
        view.findViewById<Button>(R.id.btn_7).text.toString()
    }

    private val eightBtnText by lazy {
        view.findViewById<Button>(R.id.btn_8).text.toString()
    }

    private val nineBtnText by lazy {
        view.findViewById<Button>(R.id.btn_9).text.toString()
    }

    private val modBtnText by lazy {
        view.findViewById<Button>(R.id.btn_mod).text.toString()
    }

    private val divBtnText by lazy {
        view.findViewById<Button>(R.id.btn_div).text.toString()
    }

    private val mulBtnText by lazy {
        view.findViewById<Button>(R.id.btn_mul).text.toString()
    }

    private val addBtnText by lazy {
        view.findViewById<Button>(R.id.btn_add).text.toString()
    }

    private val subBtnText by lazy {
        view.findViewById<Button>(R.id.btn_sub).text.toString()
    }

    private val pntBtnText by lazy {
        view.findViewById<Button>(R.id.btn_point).text.toString()
    }

    private val screen by lazy {
        view.findViewById<TextView>(R.id.screen_output)
    }

    private var parenLevel = 0

    private fun appendTextToScreen(btn_text: String) {
        val newText = StringBuilder()
        if (screen.text.toString() == view.getString(R.string.error)) {
            screen.text = ""
        }
        newText.append(screen.text).append(btn_text)
        screen.text = newText.toString()
    }


    fun parens() {

        if (screen.text.isNotEmpty()) {
            val lastChar = screen.text.last()

            if (lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/' || lastChar == '(') {
                appendTextToScreen("(")
                parenLevel++
            } else if (parenLevel > 0 && (lastChar.isDigit() || lastChar == ')')) {
                appendTextToScreen(")")
                parenLevel--
            }
        }
        else {
            appendTextToScreen("(")
            parenLevel++
        }
    }

    fun zero() {
        appendTextToScreen(zeroBtnText)
    }

    fun one() {
        appendTextToScreen(oneBtnText)
    }

    fun two() {
        appendTextToScreen(twoBtnText)
    }

    fun three() {
        appendTextToScreen(threeBtnText)
    }

    fun four() {
        appendTextToScreen(fourBtnText)
    }

    fun five() {
        appendTextToScreen(fiveBtnText)
    }

    fun six() {
        appendTextToScreen(sixBtnText)
    }

    fun seven() {
        appendTextToScreen(sevenBtnText)
    }

    fun eight() {
        appendTextToScreen(eightBtnText)
    }

    fun nine() {
        appendTextToScreen(nineBtnText)
    }

    fun mod() {
        appendTextToScreen(modBtnText)
    }

    fun add() {
        appendTextToScreen(addBtnText)
    }

    fun subtract() {
        appendTextToScreen(subBtnText)
    }

    fun div() {
        appendTextToScreen(divBtnText)
    }

    fun mul() {
        appendTextToScreen(mulBtnText)
    }

    fun point() {
        appendTextToScreen(pntBtnText)
    }

    fun clear() {
        screen.text = ""
    }

    fun calculate() {
        val text = screen.text.toString()
        val lexer = Lexer(text)
        val interpreter = Interpreter()

        val tokens = lexer.makeTokens()


        val parser = Parser(tokens)
        val ast = parser.parse()
        if (ast.node != null) {
            val result = interpreter.visit(ast.node!!)
            if (result != null) {
                screen.text = result.toString()
            } else {
                screen.text = view.getString(R.string.error)
            }
        } else {
            screen.text = ast.err.toString()
        }
    }
}
