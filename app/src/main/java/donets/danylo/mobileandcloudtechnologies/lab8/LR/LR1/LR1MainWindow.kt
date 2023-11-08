package donets.danylo.mobileandcloudtechnologies.lab8.LR.LR1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import donets.danylo.mobileandcloudtechnologies.lab8.MainActivity
import donets.danylo.mobileandcloudtechnologies.lab8.R


class LR1MainWindow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lr1_main_window)
    }








    override fun onBackPressed() {
        val intent = Intent(this@LR1MainWindow, MainActivity::class.java)
        startActivity(intent)
        finish()
        super.onBackPressed()
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}