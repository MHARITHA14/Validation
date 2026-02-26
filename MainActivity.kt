package com.example.validationapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.digitalcafeloginvalidation.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = findViewById<EditText>(R.id.editUsername)
        val id = findViewById<EditText>(R.id.editId)
        val validateBtn = findViewById<Button>(R.id.btnValidate)
        val result = findViewById<TextView>(R.id.textResult)

        validateBtn.setOnClickListener {

            val nameText = username.text.toString().trim()
            val idText = id.text.toString().trim()

            // Check empty
            if (nameText.isEmpty() || idText.isEmpty()) {
                result.text = "Fields should not be empty"
                return@setOnClickListener
            }

            // Username alphabets only
            if (!nameText.matches(Regex("[a-zA-Z]+"))) {
                result.text = "Username should contain only alphabets"
                return@setOnClickListener
            }

            // ID exactly 4 digits
            if (!idText.matches(Regex("\\d{4}"))) {
                result.text = "ID should be exactly 4 digits"
                return@setOnClickListener
            }

            result.text = "Validation Successful!"
        }
    }
}
