package com.farazandishehafagh.bmi

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txtName = findViewById<EditText>(R.id.txtName)
        val txtAge = findViewById<EditText>(R.id.txtAge)
        val swtGender = findViewById<Switch>(R.id.swtGender)
        val txtHeight = findViewById<EditText>(R.id.txtHeight)
        val txtWeight = findViewById<EditText>(R.id.txtWeight)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            val bmi = calculateBMI(
                txtHeight.text.toString().toDouble(),
                txtWeight.text.toString().toDouble()
            )
            showMeTheResult(
                bmi,
                txtName.text.toString(),
                txtAge.text.toString(),
                swtGender.isChecked
            )
        }
    }

    fun calculateBMI(height: Double, weight: Double): Double {
        val bmi = weight / (height * height)
        return bmi
    }

    fun showMeTheResult(bmi: Double, name: String, age: String, gender: Boolean) {

        if (bmi < 18.5) {
            if (!gender)
                Toast.makeText(
                    baseContext,
                    "dear Mr.$name,at the age of $age , You are in 'Underweight' Category",
                    Toast.LENGTH_LONG
                ).show()
            else
                Toast.makeText(
                    baseContext,
                    "dear Miss/Mrs.$name,at the age of $age , You are in 'Underweight' Category",
                    Toast.LENGTH_LONG
                ).show()
        } else if (bmi in 18.5..24.9) {
            if (!gender)
                Toast.makeText(
                    baseContext,
                    "dear Mr.$name,at the age of $age , You are in 'Normal (healthy weight)' Category",
                    Toast.LENGTH_LONG
                ).show()
            else
                Toast.makeText(
                    baseContext,
                    "dear Miss/Mrs.$name,at the age of $age , You are in 'Normal (healthy weight)' Category",
                    Toast.LENGTH_LONG
                ).show()
        } else if (bmi in 25.0..29.9) {
            if (!gender)
                Toast.makeText(
                    baseContext,
                    "dear Mr.$name,at the age of $age ,You are in 'Normal (healthy weight)' Category",
                    Toast.LENGTH_LONG
                ).show()
            else
                Toast.makeText(
                    baseContext,
                    "dear Miss/Mrs.$name,at the age of $age ,You are in 'Normal (healthy weight)' Category",
                    Toast.LENGTH_LONG
                ).show()
        } else if (bmi in 30.0..34.9)
            if (!gender)
                Toast.makeText(
                    baseContext,
                    "dear Mr.$name,at the age of $age ,You are in 'Moderately obese' Category",
                    Toast.LENGTH_LONG
                ).show()
            else
                Toast.makeText(
                    baseContext,
                    "dear Miss/Mrs.$name,at the age of $age ,You are in 'Moderately obese' Category",
                    Toast.LENGTH_LONG
                ).show()
        else if (bmi >= 35)
            if (!gender)
                Toast.makeText(
                    baseContext,
                    "dear Mr.$name,at the age of $age ,You are in 'Severely obese' Category",
                    Toast.LENGTH_LONG
                ).show()
            else
                Toast.makeText(
                    baseContext,
                    "dear Miss/Mrs.$name,at the age of $age ,You are in 'Severely obese' Category",
                    Toast.LENGTH_LONG
                ).show()
    }
}
