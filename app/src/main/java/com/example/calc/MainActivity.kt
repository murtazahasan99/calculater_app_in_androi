package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    var isNew=true
    var op="="
    fun revers(view: View){
        var x=textView.text.toString().toDouble()
        var res= x*-1.0
        textView.text=res.toString()
    }

    fun clickNum(view:View){
        if(isNew){
            textView.text=""
        }
            isNew = false
        var textval=textView.text.toString()
        var but= view as Button
        when(but.id){
            button0.id ->{
                textval+="0"
            }
            button1.id ->{
                textval+="1"
            }
            button2.id ->{
                textval+="2"
            }
            button3.id ->{
                textval+="3"
            }
            button4.id ->{
                textval+="4"
            }
            button5.id ->{
                textval+="5"
            }
            button6.id ->{
                textval+="6"
            }
            button7.id ->{
                textval+="7"
            }
            button8.id ->{
                textval+="8"
            }
            button9.id ->{
                textval+="9"
            }
            buttonDout.id ->{
                textval+="."
            }

        }
        textView.text=textval
    }


    var oldNum=""


    fun clickOp(view: View){
      oldNum=textView.text.toString()
        textView1.text=oldNum
        var buselect=view as Button
        when(buselect.id){
            buttonFac.id->{
                op="!"
            }
            buttonMult.id->{
                op="Pow"
            }
            buttonLcm.id->{
                op="Lcm"
            }
            buttonGcd.id->{
                op="gcd"
            }
            buttonMod.id->{
                op="Mod"
            }


        }
        textView1.text=oldNum +" $op "
        textView.text=""
        isNew=true
    }


    fun clickEqual(view: View){
        var newNum=textView.text.toString()
        var res:Double?=null
        when(op){
            "/"-> res=oldNum.toDouble() / newNum.toDouble()
            "*"-> res=oldNum.toDouble() * newNum.toDouble()
            "+"-> res=oldNum.toDouble() + newNum.toDouble()
            "-"-> res=oldNum.toDouble() - newNum.toDouble()
            "Mod"->res=oldNum.toDouble() % newNum.toDouble()
            "!"-> res=factorial(oldNum.toString().toDouble())
            "Pow"-> res= Power(oldNum.toDouble(),newNum.toDouble())
            "gcd"-> res= gcd(oldNum.toDouble(),newNum.toDouble())
            "Lcm"-> res= lcm(oldNum.toDouble(),newNum.toDouble())
             "="->res=textView.text.toString().toDouble()

        }


        textView.text=res.toString()
        op="="
        isNew=true
        textView1.text=""
    }


    fun clear(view: View){
         isNew=true
         op="="
         oldNum=""
        textView.text="0"
        textView1.text=""
    }
}
    fun factorial(num:Double): Double? {

        var factorial: Double = 1.0
        for (i in 1..num.toInt()) {
            // factorial = factorial * i;
            factorial *= i.toDouble()
        }
        return factorial
  }

    fun Power(base :Double, exponent :Double):Double{
        var x =exponent
        var result:Double = 1.0

        while (x != 0.0) {
            result *= base.toDouble()
            --x
        }
        return result
    }

    fun gcd(n1:Double,n2:Double):Double{
        var gcd = 1

        var i = 1
        while (i <= n1 && i <= n2) {
            // Checks if i is factor of both integers
            if (n1 % i == 0.0 && n2 % i == 0.0)
                gcd = i
            ++i
        }
        return gcd.toDouble()
    }

    fun lcm(n1:Double,n2:Double):Double{
        var lcm: Double

        // maximum number between n1 and n2 is stored in lcm
        lcm = if (n1 > n2) n1 else n2

        // Always true
        while (true) {
            if (lcm % n1 == 0.0 && lcm % n2 == 0.0) {
                println("The LCM of $n1 and $n2 is $lcm.")
                break
            }
            ++lcm
        }
        return lcm.toDouble()

    }



