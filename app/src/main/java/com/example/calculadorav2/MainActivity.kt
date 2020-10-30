package com.example.calculadorav2

import android.content.ClipData
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Surface
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.ActionMenuItem
import androidx.appcompat.view.menu.MenuView
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var num1: Double = 0.0
    var num2: Double = 0.0
    var operator: String = ""


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
        }
    }

    fun isEnableDD(h :Button){
        if(h.isEnabled()==false ){
            h.setTextColor(Color.BLUE)
        }else{
            h.setTextColor(Color.MAGENTA)
        }
    }

    fun hex(v: View){
        var  h = findViewById<Button>(R.id.btHex)
        var  d = findViewById<Button>(R.id.btDec)
        var  b = findViewById<Button>(R.id.btBina)
        d.setEnabled(true)
        h.setEnabled(false)
        b.setEnabled(true)
        isEnableDD(h)
        isEnableDD(d)
        isEnableDD(b)

    }
    fun dec(v: View){
        var  h = findViewById<Button>(R.id.btHex)
        var  d = findViewById<Button>(R.id.btDec)
        var  b = findViewById<Button>(R.id.btBina)
        d.setEnabled(false)
        h.setEnabled(true)
        b.setEnabled(true)

        isEnableDD(h)
        isEnableDD(d)
        isEnableDD(b)
    }
    fun Bin(v: View){
        var  h = findViewById<Button>(R.id.btHex)
        var  d = findViewById<Button>(R.id.btDec)
        var  b = findViewById<Button>(R.id.btBina)
        d.setEnabled(true)
        h.setEnabled(true)
        b.setEnabled(false)
        isEnableDD(h)
        isEnableDD(d)
        isEnableDD(b)
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

    fun btSuma(v: View) {
        var bt13 = findViewById<Button>(R.id.button13)
        bt13.isEnabled = true
        if (textView.getText().toString() == "") {
            Toast.makeText(applicationContext, "No has puesto nada", Toast.LENGTH_LONG).show()
        } else {
            num1 = textView.getText().toString().toDouble()
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
            num1 = textView.getText().toString().toDouble()
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
            num1 = textView.getText().toString().toDouble()
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
            num1 = textView.getText().toString().toDouble()
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
            Toast.makeText(
                applicationContext,
                "No se puede borrar si no hay nada",
                Toast.LENGTH_LONG
            ).show()
        } else {
            borra()
        }
    }

    fun btEquals(v: View) {
        if (textView.getText().toString() == "") {
            textView.text = sincero(num1)
        } else if (comprueba() == false) {
            num2 = textView.getText().toString().toDouble()
            if (operator == "+") {
                textView.text = sincero(sum(num1, num2)).toString()
            }
            if (operator == "-") {
                textView.text = sincero(rest(num1, num2)).toString()
            }
            if (operator == "x") {
                textView.text = sincero(multi(num1, num2)).toString()
            }
            if (operator == "/") {
                if (num2 == 0.0) {
                    Toast.makeText(
                        applicationContext,
                        "No se puede dividir entre 0",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    textView.text = sincero(divi(num1, num2)).toString()
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
