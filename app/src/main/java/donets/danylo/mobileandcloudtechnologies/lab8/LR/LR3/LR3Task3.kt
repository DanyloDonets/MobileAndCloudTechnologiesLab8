package donets.danylo.mobileandcloudtechnologies.lab8.LR.LR3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import donets.danylo.mobileandcloudtechnologies.lab8.R

class LR3Task3 : AppCompatActivity() {

    private val numRows = 5
    private val numColumns = 5
    private val matrix = Array(numRows) { IntArray(numColumns) }
    private var firstRow = -1
    private var secondRow = -1
    private lateinit var tableLayout: TableLayout
    private lateinit var firstRowText: EditText
    private lateinit var secondRowText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lr3_task3)


        tableLayout = findViewById(R.id.tableLayout)
        firstRowText = findViewById(R.id.firstRowText)
        secondRowText = findViewById(R.id.secondRowText)

        initializeTable()
    }

    private fun initializeTable() {
        for (i in 0 until numRows) {
            val row = TableRow(this)
            tableLayout.addView(row)

            for (j in 0 until numColumns) {
                val textView = TextView(this)
                textView.text = matrix[i][j].toString()
                row.addView(textView)

                if (i == firstRow || i == secondRow) {
                    textView.setBackgroundColor(resources.getColor(android.R.color.holo_red_light))
                }
            }
        }
    }

    fun randomFillMatrix(view: View) {
        firstRow = -1
        secondRow = -1

        for (i in 0 until numRows) {
            for (j in 0 until numColumns) {
                matrix[i][j] = (Math.random() * 100).toInt()
            }
        }

        refreshTable()
    }

    fun changeRows(view: View) {
        try {
            firstRow = firstRowText.text.toString().toInt()
            secondRow = secondRowText.text.toString().toInt()

            if (firstRow < 0 || firstRow >= numRows || secondRow < 0 || secondRow >= numRows) {
                showErrorMessage("Invalid Row Values", "Please check the row values (0 to 4).")
            } else {
                for (i in 0 until numColumns) {
                    val temp = matrix[firstRow][i]
                    matrix[firstRow][i] = matrix[secondRow][i]
                    matrix[secondRow][i] = temp
                }

                refreshTable()
            }
        } catch (e: NumberFormatException) {
            showErrorMessage("Invalid Row Values", "Please enter valid row values.")
        }
    }

    private fun refreshTable() {
        tableLayout.removeAllViews()
        initializeTable()
    }

    private fun showErrorMessage(title: String, message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("OK", null)
        builder.create().show()
    }




    override fun onBackPressed() {
        val intent = Intent(this@LR3Task3, LR3MainWindow::class.java)
        startActivity(intent)
        finish()
        super.onBackPressed()
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}