package donets.danylo.mobileandcloudtechnologies.lab8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import donets.danylo.mobileandcloudtechnologies.lab8.LR.LR1.LR1MainWindow
import donets.danylo.mobileandcloudtechnologies.lab8.LR.LR2.LR2MainWindow
import donets.danylo.mobileandcloudtechnologies.lab8.LR.LR3.LR3MainWindow
import donets.danylo.mobileandcloudtechnologies.lab8.LR.LR4.LR4MainWindow
import donets.danylo.mobileandcloudtechnologies.lab8.LR.LR5.LR5MainWindow


class MainActivity : AppCompatActivity() {

    lateinit var lr1Btn:Button
    lateinit var lr2Btn:Button
    lateinit var lr3Btn:Button
    lateinit var lr4Btn:Button
    lateinit var lr5Btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lr1Btn = findViewById(R.id.LR1)
        lr2Btn = findViewById(R.id.LR2)
        lr3Btn = findViewById(R.id.LR3)
        lr4Btn = findViewById(R.id.LR4)
        lr5Btn = findViewById(R.id.LR5)

        lr1Btn.setOnClickListener {
            val intent = Intent(this@MainActivity, LR1MainWindow::class.java)
            startActivity(intent)
            finish()
        }
        lr2Btn.setOnClickListener {
            val intent = Intent(this@MainActivity, LR2MainWindow::class.java)
            startActivity(intent)
            finish()
        }
        lr3Btn.setOnClickListener {
            val intent = Intent(this@MainActivity, LR3MainWindow::class.java)
            startActivity(intent)
            finish()
        }
        lr4Btn.setOnClickListener {
            val intent = Intent(this@MainActivity, LR4MainWindow::class.java)
            startActivity(intent)
            finish()
        }
        lr5Btn.setOnClickListener {
            val intent = Intent(this@MainActivity, LR5MainWindow::class.java)
            startActivity(intent)
            finish()
        }


    }
}