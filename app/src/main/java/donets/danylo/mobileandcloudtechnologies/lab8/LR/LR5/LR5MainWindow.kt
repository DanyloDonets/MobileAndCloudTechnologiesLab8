package donets.danylo.mobileandcloudtechnologies.lab8.LR.LR5

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import donets.danylo.mobileandcloudtechnologies.lab8.MainActivity
import donets.danylo.mobileandcloudtechnologies.lab8.R

class LR5MainWindow : AppCompatActivity() {

    lateinit var wordEdt: EditText
    lateinit var newWordEdt: EditText
    var handler = Handler()
    val idleMin: Long = 4000 // 4 seconds after user stops typing

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lr5_main_window)

        wordEdt = findViewById(R.id.wordEdt)
        newWordEdt = findViewById(R.id.newWordEdt)

        wordEdt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                handler.removeCallbacks(inputFinishChecker)
            }

            override fun afterTextChanged(s: Editable?) {
                handler.postDelayed(inputFinishChecker, idleMin)
            }
        })
    }

    private val inputFinishChecker = Runnable {
        transformation()
    }

    private fun transformation() {
        val word = wordEdt.text.toString()
        val sb = StringBuilder()
        for (i in 0 until word.length step 2) {
            sb.append(word[i])
        }
        newWordEdt.setText(sb)
    }

    override fun onBackPressed() {
        val intent = Intent(this@LR5MainWindow, MainActivity::class.java)
        startActivity(intent)
        finish()
        super.onBackPressed()
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}