package donets.danylo.mobileandcloudtechnologies.lab8.LR.LR3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import donets.danylo.mobileandcloudtechnologies.lab8.R

class LR3Task2 : AppCompatActivity() {

    private val numRows = 5
    private val numColumns = 5
    private val matrix = Array(numRows) { IntArray(numColumns) }

    private lateinit var tableLayout: TableLayout
    private lateinit var biggestValueTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lr3_task2)


        tableLayout = findViewById(R.id.tableLayout)
        biggestValueTextView = findViewById(R.id.biggestValueTextView)

        setupTable()
        updateTable()

        val randomFillButton = findViewById<Button>(R.id.randomFillButton)
        randomFillButton.setOnClickListener {
            randomFillMatrix()
            updateTable()
        }
    }

    private fun setupTable() {
        for (i in 0 until numRows) {
            val row = TableRow(this)
            for (j in 0 until numColumns) {
                val cell = TextView(this)
                cell.text = matrix[i][j].toString()
                cell.setPadding(8, 8, 8, 8)
                row.addView(cell)
            }
            tableLayout.addView(row)
        }
    }

    private fun randomFillMatrix() {
        for (i in 0 until numRows) {
            for (j in 0 until numColumns) {
                matrix[i][j] = (0..99).random()
            }
        }
    }

    private fun updateTable() {
        var theBiggest = 0
        for (i in 0 until numRows) {
            val row = tableLayout.getChildAt(i) as TableRow
            for (j in 0 until numColumns) {
                val cell = row.getChildAt(j) as TextView
                cell.text = matrix[i][j].toString()
                if (i <= j && i < numColumns - j) {
                    cell.setBackgroundColor(getColor(android.R.color.holo_red_light))
                }
                if (matrix[i][j] > theBiggest) {
                    theBiggest = matrix[i][j]
                }
            }
        }
        biggestValueTextView.text = theBiggest.toString()
    }



    override fun onBackPressed() {
        val intent = Intent(this@LR3Task2, LR3MainWindow::class.java)
        startActivity(intent)
        finish()
        super.onBackPressed()
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}