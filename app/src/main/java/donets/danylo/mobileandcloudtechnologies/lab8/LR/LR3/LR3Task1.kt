package donets.danylo.mobileandcloudtechnologies.lab8.LR.LR3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import donets.danylo.mobileandcloudtechnologies.lab8.MainActivity
import donets.danylo.mobileandcloudtechnologies.lab8.R

class LR3Task1 : AppCompatActivity() {


    private lateinit var xText: EditText
    private lateinit var yText: EditText
    private lateinit var zText: EditText
    private lateinit var aLbl: TextView
    private lateinit var bLbl: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lr3_task1)

        xText = findViewById(R.id.xText)
        yText = findViewById(R.id.yText)
        zText = findViewById(R.id.zText)
        aLbl = findViewById(R.id.aLbl)
        bLbl = findViewById(R.id.bLbl)

        val btnCount = findViewById<Button>(R.id.btnCount)
        btnCount.setOnClickListener {
            calculateAndDisplayResults()
        }

        val resetBtn = findViewById<Button>(R.id.resetBtn)
        resetBtn.setOnClickListener {
            clearInputFields()
        }


    }

    private fun calculateAndDisplayResults() {
        val x = xText.text.toString().toDoubleOrNull()
        val y = yText.text.toString().toDoubleOrNull()
        val z = zText.text.toString().toDoubleOrNull()

        if (x != null && y != null && z != null) {
            val a = countA(x, y)
            val b = countB(x, y, z)
            aLbl.text = "= $a"
            bLbl.text = "= $b"
        } else {
            // Handle input error
            aLbl.text = "= 0"
            bLbl.text = "= 0"
        }
    }

    private fun countA(x: Double, y: Double): Double {
        return (1 + y) * ((x + y / (x * x + 4)) / (Math.exp(-x - 2) + 1 / (x * x + 4)))
    }

    private fun countB(x: Double, y: Double, z: Double): Double {
        return (1 + Math.cos(y - 2)) / (Math.pow(x, 4.0) / 2 + Math.pow(Math.sin(z), 2.0))
    }

    private fun clearInputFields() {
        xText.text.clear()
        yText.text.clear()
        zText.text.clear()
        aLbl.text = "= 0"
        bLbl.text = "= 0"
    }


    override fun onBackPressed() {
        val intent = Intent(this@LR3Task1, LR3MainWindow::class.java)
        startActivity(intent)
        finish()
        super.onBackPressed()
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}