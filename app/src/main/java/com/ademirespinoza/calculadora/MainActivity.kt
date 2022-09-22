package com.ademirespinoza.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    //0->nada, 1->suma, 2->resta, 3->mult, 4->div
    var oper: Int = 0
    var numero1: Double = 0.0
    lateinit var tv1: TextView
    lateinit var tv2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv1 = findViewById(R.id.tv1)
        tv2 = findViewById(R.id.tv2)
        val btnBorrar: Button =findViewById(R.id.btnac)
        val btnIgualr: Button =findViewById(R.id.btnIgual)

        btnIgualr.setOnClickListener{
            var numero2: Double = tv2.text.toString().toDouble()
            var resp: Double = 0.0

            when(oper){
                1 -> resp = numero1 + numero2
                2 -> resp = numero1 - numero2
                3 -> resp = numero1 * numero2
                4 -> resp = numero1 / numero2
            }

            tv2.setText(resp.toString())
            tv1.setText("")
        }

            btnBorrar.setOnClickListener{
                tv1.setText("")
                tv2.setText("")
                numero1 = 0.0
                oper = 0


            }
    }

    fun presionarDigito(view: View){
        //val tv2: TextView = findViewById(R.id.tv2)
        val num2: String = tv2.text.toString()

        when(view.id){
            R.id.btn0 -> tv2.setText(num2 + "0")
            R.id.btn1 -> tv2.setText(num2 + "1")
            R.id.btn2 -> tv2.setText(num2 + "2")
            R.id.btn3 -> tv2.setText(num2 + "3")
            R.id.btn4 -> tv2.setText(num2 + "4")
            R.id.btn5 -> tv2.setText(num2 + "5")
            R.id.btn6 -> tv2.setText(num2 + "6")
            R.id.btn7 -> tv2.setText(num2 + "7")
            R.id.btn8 -> tv2.setText(num2 + "8")
            R.id.btn9 -> tv2.setText(num2 + "9")
            R.id.btnPunto -> tv2.setText(num2 + ".")

        }

    }

    fun clicOperacion(view: View){
        numero1 = tv2.text.toString().toDouble()
        var num2_tex: String = tv2.text.toString()
        tv2.setText("")

        when(view.id){
            R.id.btnSuma ->{
                tv1.setText(num2_tex + "+")
                oper = 1
            }
            R.id.btnResta ->{
                tv1.setText(num2_tex + "-")
                oper = 2
            }
            R.id.btnMultiplicacion ->{
                tv1.setText(num2_tex + "*")
                oper = 3
            }
            R.id.btnDivision ->{
                tv1.setText(num2_tex + "/")
                oper = 4
            }
        }

    }
}