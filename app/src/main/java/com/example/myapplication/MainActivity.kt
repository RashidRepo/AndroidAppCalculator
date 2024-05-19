package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



//        setContentView(R.layout.activity_main)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val noNum1 = "Please enter the first number"
        val noNum2 = "Please enter the second number"


        fun performOperation(operation: (Double, Double) -> Double, operationName: String) {
            val num1 = binding.num1EditText.text.toString()
            val num2 = binding.num2EditText.text.toString()

            when {
                num1.isEmpty() -> binding.resultTextView.text = noNum1
                num2.isEmpty() -> binding.resultTextView.text = noNum2
                else -> {
                    val result = operation(num1.toDouble(), num2.toDouble())
                    binding.resultTextView.text = "The $operationName of $num1 and $num2 is $result"
                }
            }
        }

        binding.plusBtn.setOnClickListener {
            performOperation(Double::plus, "sum")
        }

        binding.minusBtn.setOnClickListener {
            performOperation(Double::minus, "subtraction")
        }

        binding.productBtn.setOnClickListener {
            performOperation(Double::times, "product")
        }

        binding.divideBtn.setOnClickListener {
            performOperation(Double::div, "division")
        }
    }
}