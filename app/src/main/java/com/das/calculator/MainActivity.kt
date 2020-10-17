package com.das.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private val clicks = ButtonClicks(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val screen = findViewById<TextView>(R.id.screen_output)
        screen.movementMethod = ScrollingMovementMethod()
    }

    /**
     * Gets all the buttons in the calculator keypad and stores them in an
     * array and returns the array
     *
     * @return [Array<Button>]
     * @author Daniel Schechtman
     */
    private fun getKeyPadBtns(): ArrayList<Button> {
        //val keyPad = findViewById<TableLayout>(R.id.keypad)
        val btnList = ArrayList<Button>()

//        for (row in keyPad.children) {
//            val tableRow = row as TableRow
//            for (element in tableRow.children) {
//                if (element is Button) {
//                    btnList.add(element)
//                }
//            }
//        }
        return btnList
    }

    fun clickBtnZero(view: View) {
        clicks.zero()
    }

    fun clickBtnOne(view: View) {
        clicks.one()
    }

    fun clickBtnTwo(view: View) {
        clicks.two()
    }

    fun clickBtnThree(view: View) {
        clicks.three()
    }

    fun clickBtnFour(view: View) {
        clicks.four()
    }

    fun clickBtnFive(view: View) {
        clicks.five()
    }

    fun clickBtnSix(view: View) {
        clicks.six()
    }

    fun clickBtnSeven(view: View) {
        clicks.seven()
    }

    fun clickBtnEight(view: View) {
        clicks.eight()
    }

    fun clickBtnNine(view: View) {
        clicks.nine()
    }

    fun clickBtnClear(view: View) {
        clicks.clear()
    }

    fun clickBtnMul(view: View) {
        clicks.mul()
    }

    fun clickBtnDiv(view: View) {
        clicks.div()
    }

    fun clickBtnAdd(view: View) {
        clicks.add()
    }

    fun clickBtnSub(view: View) {
        clicks.subtract()
    }

    fun clickBtnPnt(view: View) {
        clicks.point()
    }

    fun clickBtnMod(view: View) {
        clicks.mod()
    }

    fun clickBtnEqual(view: View) {
        clicks.calculate()
    }

    fun clickBtnParens(view: View) {
        clicks.parens()
    }
}
