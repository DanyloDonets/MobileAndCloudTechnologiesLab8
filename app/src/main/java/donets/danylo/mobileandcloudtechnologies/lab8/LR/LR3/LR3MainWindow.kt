package donets.danylo.mobileandcloudtechnologies.lab8.LR.LR3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import donets.danylo.mobileandcloudtechnologies.lab8.MainActivity
import donets.danylo.mobileandcloudtechnologies.lab8.R

class LR3MainWindow : AppCompatActivity() {

    lateinit var  lr3task1Btn:Button
    lateinit var  lr3task2Btn:Button
    lateinit var  lr3task3Btn:Button
    lateinit var  lr3task4Btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lr3_main_window)

        lr3task1Btn = findViewById(R.id.Task1)
        lr3task2Btn = findViewById(R.id.Task2)
        lr3task3Btn = findViewById(R.id.Task3)
        lr3task4Btn = findViewById(R.id.Task4)

        lr3task1Btn.setOnClickListener {
            val intent = Intent(this@LR3MainWindow, LR3Task1::class.java)
            startActivity(intent)
            finish()
        }
        lr3task2Btn.setOnClickListener {
            val intent = Intent(this@LR3MainWindow, LR3Task2::class.java)
            startActivity(intent)
            finish()
        }
        lr3task3Btn.setOnClickListener {
            val intent = Intent(this@LR3MainWindow, LR3Task3::class.java)
            startActivity(intent)
            finish()
        }
        lr3task4Btn.setOnClickListener {
            val intent = Intent(this@LR3MainWindow, LR3Task4::class.java)
            startActivity(intent)
            finish()
        }
    }



    override fun onBackPressed() {
        val intent = Intent(this@LR3MainWindow, MainActivity::class.java)
        startActivity(intent)
        finish()
        super.onBackPressed()
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }



}