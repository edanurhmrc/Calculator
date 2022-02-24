package com.edanurhamurcu.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var newOperator = true
    var operator = "*"
    var oldCount=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun btnNumbers_Click(view:View){

        if(newOperator){
            tvCikti.setText("")
        }
        newOperator = false

        var btnClickValue = tvCikti.text.toString()

        var btnSelect :Button = view as Button

        btnClickValue += btnSelect.text

        tvCikti.setText(btnClickValue)

        /*when(btnSelect.id){
            btn0.id ->{ btnClickValue += "0"}

            btn1.id ->{ btnClickValue += "1"}

            btn2.id ->{ btnClickValue += "2"}

            btn3.id ->{ btnClickValue += "3" }

            btn4.id ->{ btnClickValue += "4" }

            btn5.id ->{ btnClickValue += "5"}

            btn6.id ->{ btnClickValue += "6"}

            btn7.id ->{ btnClickValue += "7"}

            btn8.id ->{ btnClickValue += "8"}

            btn9.id ->{ btnClickValue += "9"}

            btnSub.id ->{ btnClickValue = "-" + btnClickValue }
        }*/
    }


    fun btnOperator_Click(view: View) {

        var btnSelect= view as Button

        when(btnSelect.id){

            btnSum.id->{operator="+" }

            btnSub.id->{ operator="-"}

            btnDiv.id->{operator="/"}

            btnMul.id->{operator="*" }
        }

        oldCount=tvCikti.text.toString()

        newOperator=true
    }


    fun Equals_Click(view: View) {

        var newCount = tvCikti.text.toString()

        var result : Double? = null

        when(operator){
            "+"->{ result= oldCount.toDouble() + newCount.toDouble() }

            "-"->{  result= oldCount.toDouble() - newCount.toDouble() }

            "*"-> { result= oldCount.toDouble() * newCount.toDouble() }

            "/"-> { result = oldCount.toDouble() / newCount.toDouble() }

        }
        tvCikti.setText(result.toString())

        newOperator=true
    }

    fun AC_Click(view: View) {

        tvCikti.setText("0")
        operator = ""
        newOperator=true
        oldCount = ""
    }

    fun Per_Click(view: View) {

        var count:Double=tvCikti.text.toString().toDouble()/100
        tvCikti.setText(count.toString())
        newOperator=true
    }


}