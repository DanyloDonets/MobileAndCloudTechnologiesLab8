package donets.danylo.mobileandcloudtechnologies.lab8.LR.LR4

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import donets.danylo.mobileandcloudtechnologies.lab8.LR.LR1.LR1MainWindow
import donets.danylo.mobileandcloudtechnologies.lab8.MainActivity
import donets.danylo.mobileandcloudtechnologies.lab8.R

class LR4MainWindow : AppCompatActivity() {
    lateinit var wordEdt: EditText
    lateinit var numSymbolEdt: EditText
    lateinit var symbolEdt: EditText
    var handler = Handler()
    val idleMin: Long = 4000 // 4 seconds after user stops typing

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lr4_main_window)




        wordEdt = findViewById(R.id.wordEdt)
        numSymbolEdt = findViewById(R.id.numSymbolEdt)
        symbolEdt = findViewById(R.id.SymbolEdt)

        numSymbolEdt.addTextChangedListener(object : TextWatcher {
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
        val symbolNum = numSymbolEdt.text.toString().toIntOrNull()
        if (word == null || word == " "){
            Toast.makeText(this, "Word is empty", Toast.LENGTH_SHORT).show()
        }
        else if (symbolNum == null){
            Toast.makeText(this, "Num of symbol is null or isnt number", Toast.LENGTH_SHORT).show()
        }
        else if(symbolNum> word.length){
            Toast.makeText(this, "Num of symbol is bigger than word", Toast.LENGTH_SHORT).show()

        }
        else {

            var laters: String ="";
            var numOfLaters = 0;
            for (i in 0 until word.length) {
                var found = false
                for (j in 0 until laters.length) {
                    if (word[i] == laters[j]) {
                        found = true
                        break // no need to iterate further
                    }
                }
                if (!found) {
                    laters = laters + word[i].toString() + " "
                    numOfLaters++
                }
            }
            Toast.makeText(this, "laters($numOfLaters): $laters", Toast.LENGTH_SHORT).show()
            symbolEdt.setText(word[symbolNum-1].toString())


        }
    }

    override fun onBackPressed() {
        val intent = Intent(this@LR4MainWindow, MainActivity::class.java)
        startActivity(intent)
        finish()
        super.onBackPressed()
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
