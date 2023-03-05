package com.example.bmiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmical.R
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculate.setOnClickListener {
            if (!edtWeight.text.toString().equals("") && !edtHeight.text.toString().equals("")) {
                val wt = (edtWeight.text.toString()).toDouble()
                val ht = (edtHeight.text.toString()).toDouble()
                val bmi =wt/((ht+ht)/100)
                txtTitle.text = "Your BMI"
                txtResult.text = "${bmi.toInt()}"
                if (bmi > 25)
                {
                    Toast.makeText(this@MainActivity, R.string.strOverweight, Toast.LENGTH_SHORT)
                        .show();
                    txtMsg.text = resources.getString(R.string.strOverweight)
                }
                else if (bmi < 18)
                {
                    Toast.makeText(this@MainActivity, R.string.strUnderweight, Toast.LENGTH_SHORT)
                        .show();
                    txtMsg.text = resources.getString(R.string.strUnderweight)
                }
                else
                {
                    Toast.makeText(this@MainActivity, R.string.strHealthy, Toast.LENGTH_SHORT).show();
                    txtMsg.text = resources.getString(R.string.strHealthy)
                }
            }
            else{
                Toast.makeText(this@MainActivity, "Fill up all the details", Toast.LENGTH_SHORT).show();
            }

        }
    }
}