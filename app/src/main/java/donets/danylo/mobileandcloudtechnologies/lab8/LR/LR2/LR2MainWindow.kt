package donets.danylo.mobileandcloudtechnologies.lab8.LR.LR2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import donets.danylo.mobileandcloudtechnologies.lab8.MainActivity
import donets.danylo.mobileandcloudtechnologies.lab8.R


class LR2MainWindow : AppCompatActivity() {

    private lateinit var solution1Text: EditText
    private lateinit var solution2Text: EditText
    private lateinit var solution3Text: EditText
    private var x: Boolean = false
    private var y: Boolean = false
    private var z: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lr2_main_window)

        solution1Text = findViewById(R.id.solution1Text)
        solution2Text = findViewById(R.id.solution2Text)
        solution3Text = findViewById(R.id.solution3Text)

        val checkX = findViewById<CheckBox>(R.id.checkX)
        val checkY = findViewById<CheckBox>(R.id.checkY)
        val checkZ = findViewById<CheckBox>(R.id.checkZ)

        val clearBtn = findViewById<Button>(R.id.clearBtn)
        clearBtn.setOnClickListener {
            checkX.isChecked = false
            checkY.isChecked = false
            checkZ.isChecked = false
            solution1Text.text.clear()
            solution2Text.text.clear()
            solution3Text.text.clear()
        }

        val countBtn = findViewById<Button>(R.id.countBtn)
        countBtn.setOnClickListener {
            x = checkX.isChecked
            y = checkY.isChecked
            z = checkZ.isChecked
            solution1Text.setText(task1().toString())
            solution2Text.setText(task2().toString())
            solution3Text.setText(task3().toString())
        }
    }

    private fun task1(): Boolean {
        return x || (y && !z)
    }

    private fun task2(): Boolean {
        return !x && !y
    }

    private fun task3(): Boolean {
        return !(x && z) || y
    }


    override fun onBackPressed() {
        val intent = Intent(this@LR2MainWindow, MainActivity::class.java)
        startActivity(intent)
        finish()
        super.onBackPressed()
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }



}