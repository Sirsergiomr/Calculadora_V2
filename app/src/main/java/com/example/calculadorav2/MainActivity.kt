package com.example.calculadorav2

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.Surface
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var num1: Double = 0.0
    var num2: Double = 0.0
    var operator: String = ""
    var binbo : Boolean = false
    var decbo : Boolean = true
    var hexbo : Boolean = false
    @RequiresApi(Build.VERSION_CODES.FROYO)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var  h = findViewById<Button>(R.id.btHex)
        var  d = findViewById<Button>(R.id.btDec)
        var  b = findViewById<Button>(R.id.btBina)
        val rotacion = windowManager.defaultDisplay.rotation

        if (rotacion == Surface.ROTATION_0 || rotacion == Surface.ROTATION_180) {
        }else{
            h.setEnabled(true)
            d.setEnabled(false)
            b.setEnabled(true)
            isEnableDD(h)
            isEnableDD(d)
            isEnableDD(b)

            var bta = findViewById<Button>(R.id.bta)
            var btb = findViewById<Button>(R.id.btb)
            var btc = findViewById<Button>(R.id.btc)
            var btd = findViewById<Button>(R.id.btd)
            var bte = findViewById<Button>(R.id.bte)
            var btf = findViewById<Button>(R.id.btf)

            falseButtons(bta)
            falseButtons(btb)
            falseButtons(btc)
            falseButtons(btd)
            falseButtons(bte)
            falseButtons(btf)
        }
    }
    fun isEnableDD(h: Button){
        if(h.isEnabled()==false ){
            h.setTextColor(Color.parseColor("#FF1B2977"))
        }else{
            h.setTextColor(Color.BLUE)
        }
    }
    fun hex(v: View){
        var entrada = textView.getText().toString()
        if (entrada == "") {
        }else{
            if(decbo == true){
                textView.text = Integer.toHexString(textView.text.toString().toInt())
            }
            if(binbo == true){
                var d = convertBinaryToDecimal(textView.text.toString().toLong())
                textView.text = Integer.toHexString(d.toInt())
            }
        }

        var  h = findViewById<Button>(R.id.btHex)
        var  d = findViewById<Button>(R.id.btDec)
        var  b = findViewById<Button>(R.id.btBina)

        trueButtons(bt2)
        trueButtons(bt3)
        trueButtons(bt4)
        trueButtons(bt5)
        trueButtons(bt6)
        trueButtons(bt7)
        trueButtons(bt8)
        trueButtons(bt9)

        trueButtonsHex(bta)
        trueButtonsHex(btb)
        trueButtonsHex(btc)
        trueButtonsHex(btd)
        trueButtonsHex(bte)
        trueButtonsHex(btf)

        d.setEnabled(true)
        h.setEnabled(false)
        b.setEnabled(true)
        isEnableDD(btHex)
        isEnableDD(btDec)
        isEnableDD(btBina)

        binbo = false
        decbo = false
        hexbo = true
    }

    fun convertBinaryToDecimal(num: Long): Int {
        var num = num
        var decimalNumber = 0
        var i = 0
        var remainder: Long

        while (num.toInt() != 0) {
            remainder = num % 10
            num /= 10
            decimalNumber += (remainder * Math.pow(2.0, i.toDouble())).toInt()
            ++i
        }
        return decimalNumber
    }

    fun caracterHexadecimalADecimal(caracter: Char): Int {
        return when (caracter) {
            'a' -> 10
            'b' -> 11
            'c' -> 12
            'd' -> 13
            'e' -> 14
            'f' -> 15
            else -> caracter.toString().toInt()
        }
    }

    fun hexadecimalADecimal(hexadecimal: String): Long {
        var decimal: Long = 0
        var potencia = 0
        for (x in hexadecimal.length - 1 downTo 0) {
            val valor: Int = caracterHexadecimalADecimal(hexadecimal[x])
            val elevado = Math.pow(16.0, potencia.toDouble()).toLong() * valor
            decimal += elevado
            potencia++
        }
        return decimal
    }
    fun dec(v: View){

        var entrada = textView.getText().toString()
        if (entrada == "") {

        }else{
            if (hexbo == true){
                textView.text =hexadecimalADecimal(textView.text.toString()).toString()
            }
            if(binbo == true){
                var c = textView.text.toString().toLong()
                textView.text = convertBinaryToDecimal(c).toString()
            }
        }

        var  h = findViewById<Button>(R.id.btHex)
        var  d = findViewById<Button>(R.id.btDec)
        var  b = findViewById<Button>(R.id.btBina)
        d.setEnabled(false)
        h.setEnabled(true)
        b.setEnabled(true)

        isEnableDD(h)
        isEnableDD(d)
        isEnableDD(b)

        falseButtons(bta)
        falseButtons(btb)
        falseButtons(btc)
        falseButtons(btd)
        falseButtons(bte)
        falseButtons(btf)

        trueButtons(bt2)
        trueButtons(bt3)
        trueButtons(bt4)
        trueButtons(bt5)
        trueButtons(bt6)
        trueButtons(bt7)
        trueButtons(bt8)
        trueButtons(bt9)
        binbo = false
        decbo = true
        hexbo = false
    }
    fun Bin(v: View){
        var entrada = textView.getText().toString()
        if (entrada == "") {
        }else{
            if (decbo == true){
                textView.text = Integer.toBinaryString(textView.text.toString().toInt()).toString()
            }
            if(hexbo == true){
                var c = hexadecimalADecimal(textView.text.toString()).toInt()
                textView.text = Integer.toBinaryString(c)
            }
        }

        var h = findViewById<Button>(R.id.btHex)
        var d = findViewById<Button>(R.id.btDec)
        var b = findViewById<Button>(R.id.btBina)
        d.setEnabled(true)
        h.setEnabled(true)
        b.setEnabled(false)
        isEnableDD(h)
        isEnableDD(d)
        isEnableDD(b)

        falseButtons(bt2)
        falseButtons(bt3)
        falseButtons(bt4)
        falseButtons(bt5)
        falseButtons(bt6)
        falseButtons(bt7)
        falseButtons(bt8)
        falseButtons(bt9)

        falseButtons(bta)
        falseButtons(btb)
        falseButtons(btc)
        falseButtons(btd)
        falseButtons(bte)
        falseButtons(btf)
        binbo = true
        decbo = false
        hexbo = false
    }

    fun falseButtons(b: Button){
        if(b.isEnabled==true){
            b.isEnabled=false
            b.setTextColor(Color.GRAY)
        }
    }
    fun trueButtons(b: Button){
        if(b.isEnabled==false){
            b.isEnabled=true
            b.setTextColor(Color.parseColor("#FF00B0FF"))
        }
    }
    fun trueButtonsHex(b: Button){
        if(b.isEnabled==false){
            b.isEnabled=true
            b.setTextColor(Color.parseColor("#090E33"))
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
    /**
     * 
     */
    fun numbers(v: View) {
        val num = findViewById<Button>(v.id)
        textView.text = textView.text.toString() + num.text.toString()
    }

    fun punto(v: View) {
        var entrada = textView.getText().toString()
        var bt13 = findViewById<Button>(R.id.button13)
        if (entrada == "") {
            Toast.makeText(applicationContext, "No has puesto nada", Toast.LENGTH_SHORT).show()
        } else if (entrada.contains('.')) {
            Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
            bt13.isEnabled = false
        } else {
            textView.text = textView.text.toString() + "."
        }
    }

    fun Decimal(): Double{
        var retorno : Double = 0.0
        if (hexbo == true){
            retorno = hexadecimalADecimal(textView.getText().toString()).toString().toDouble()
        }
        if(binbo == true){
            var c = textView.getText().toString().toLong()
            retorno= convertBinaryToDecimal(c).toString().toDouble()
        }
        if (decbo == true){
            retorno = textView.getText().toString().toDouble()
        }
        return retorno
    }

    fun btSuma(v: View) {
        var bt13 = findViewById<Button>(R.id.button13)
        bt13.isEnabled = true
        if (textView.getText().toString() == "") {
            Toast.makeText(applicationContext, "No has puesto nada", Toast.LENGTH_LONG).show()
        } else {
            num1 = Decimal()
            operator = "+"
            textView.text = ""
        }
    }

    fun btResta(v: View) {
        var bt13 = findViewById<Button>(R.id.button13)
        bt13.isEnabled = true
        if (textView.getText().toString() == "") {
            textView.text = "-"
        } else if (comprueba() == false) {
            num1 = Decimal()
            operator = "-"
            textView.text = ""
        }
    }

    fun btMulti(v: View) {
        var bt13 = findViewById<Button>(R.id.button13)
        bt13.isEnabled = true
        if (textView.getText().toString() == "") {
            Toast.makeText(applicationContext, "No has puesto nada", Toast.LENGTH_SHORT).show()
        } else if (comprueba() == false) {
            num1 = Decimal()
            operator = "x"
            textView.text = ""
        }
    }

    fun btDivi(v: View) {
        var bt13 = findViewById<Button>(R.id.button13)
        bt13.isEnabled = true
        if (textView.getText().toString() == "") {
            Toast.makeText(applicationContext, "No has puesto nada", Toast.LENGTH_SHORT).show()
        } else if (comprueba() == false) {
            num1 = Decimal()
            operator = "/"
            textView.text = ""
        }
    }

    fun btDel(v: View) {
        var bt13 = findViewById<Button>(R.id.button13)
        bt13.isEnabled = true
        if (textView.getText().toString() == "") {
            Toast.makeText(applicationContext, "No has puesto nada", Toast.LENGTH_SHORT).show()
        } else if (textView.getText().toString() == "") {
            Toast.makeText(applicationContext,"No se puede borrar si no hay nada",Toast.LENGTH_LONG).show()
        } else {
            borra()
        }
    }

    fun btEquals(v: View) {
        if (textView.getText().toString() == "") {
            textView.text = num1.toString()
        } else if (comprueba() == false) {
            num2 = Decimal()
            if (operator == "+") {
                if (binbo == true){
                    var c = sum(num1, num2)
                    textView.text = Integer.toBinaryString(c.toInt()).toString()
                }
                if(hexbo == true){
                    var c= sum(num1, num2)
                    textView.text = Integer.toHexString(c.toInt()).toString()
                }
                if(decbo == true){
                    textView.text = sincero(sum(num1, num2)).toString()
                }
            }
            if (operator == "-") {
                if (binbo == true){
                    var c = rest(num1, num2)
                    textView.text = Integer.toBinaryString(c.toInt()).toString()
                }
                if(hexbo == true){
                    var c= rest(num1, num2)
                    textView.text = Integer.toHexString(c.toInt()).toString()
                }
                if(decbo == true){
                    textView.text = sincero(rest(num1, num2)).toString()
                }
            }
            if (operator == "x") {
                if (binbo == true){
                    var c = multi(num1, num2)
                    textView.text = Integer.toBinaryString(c.toInt()).toString()
                }
                if(hexbo == true){
                    var c= multi(num1, num2)
                    textView.text = Integer.toHexString(c.toInt()).toString()
                }
                if(decbo == true){
                    textView.text = sincero(multi(num1, num2)).toString()
                }
            }
            if (operator == "/") {
                if (num2 == 0.0) {
                    Toast.makeText(applicationContext,"No se puede dividir entre 0",Toast.LENGTH_LONG).show()
                } else {
                    if (binbo == true){
                        var c = divi(num1, num2)
                        textView.text = Integer.toBinaryString(c.toInt()).toString()
                    }
                    if(hexbo == true){
                        var c= divi(num1, num2)
                        textView.text = Integer.toHexString(c.toInt()).toString()
                    }
                    if(decbo == true){
                        textView.text = sincero(divi(num1, num2)).toString()
                    }
                }
            }
        }
    }

    fun sum(a: Double, b: Double): Double = a + b
    fun rest(a: Double, b: Double): Double = a - b
    fun multi(a: Double, b: Double): Double = a * b
    fun divi(a: Double, b: Double): Double = a / b
    fun sincero(resultado: Double): String? {
        var retorno = ""
        retorno = resultado.toString()
        if (resultado % 1.0 == 0.0) {
            retorno = retorno.substring(0, retorno.length - 2)
        }
        return retorno
    }

    fun comprueba(): Boolean? {
        var retorno = false
        var c = textView.getText().toString()
        if (c == "-" || c == "-." || c == ".-" || c == ".") {
            retorno = true
        }
        return retorno
    }

    fun borra() {
        val Vc = ""
        textView.text = Vc
        num1 = 0.0
        num2 = 0.0
    }
}