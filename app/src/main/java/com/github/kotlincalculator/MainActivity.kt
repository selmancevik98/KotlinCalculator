package com.github.kotlincalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var num1edittext: EditText
    lateinit var num2edittext: EditText
    lateinit var addButton: Button
    lateinit var subtractButton: Button
    lateinit var multiplyButton: Button
    lateinit var divideButton: Button
    lateinit var ResultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        definitions()
    }

    fun definitions () {
        num1edittext = findViewById(R.id.num1text)
        num2edittext = findViewById(R.id.num2text)
        addButton = findViewById(R.id.addButton)
        subtractButton = findViewById(R.id.subtractButton)
        multiplyButton = findViewById(R.id.multiplyButton)
        divideButton = findViewById(R.id.divideButton)
        ResultTextView = findViewById(R.id.ResultTextView)



        addButton.setOnClickListener {
            var num1 = num1edittext.text.toString().toDouble()
            var num2 = num2edittext.text.toString().toDouble()
            sum(num1, num2)
        }

        subtractButton.setOnClickListener {
            var num1 = num1edittext.text.toString().toDouble()
            var num2 = num2edittext.text.toString().toDouble()
            subtract(num1, num2)
        }

        multiplyButton.setOnClickListener {
            var num1 = num1edittext.text.toString().toDouble()
            var num2 = num2edittext.text.toString().toDouble()
            multiply(num1, num2)
        }

        divideButton.setOnClickListener {
            var num1 = num1edittext.text.toString().toDouble()
            var num2 = num2edittext.text.toString().toDouble()
            if (num2 != 0.0) {
                divide(num1, num2)
            } else {
                ResultTextView.text = "cannot be divided by 0"
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun sum(a: Double, b: Double) {
        ResultTextView.text = "Result: ${a + b}";
    }

    private fun subtract(a: Double, b: Double) {
        ResultTextView.text = "Result: ${a - b}";
    }

    private fun multiply(a: Double, b: Double) {
        ResultTextView.text = "Result: ${a * b}";
    }

    private fun divide(a: Double, b: Double) {
        ResultTextView.text = "Result: ${a / b}";
    }
}