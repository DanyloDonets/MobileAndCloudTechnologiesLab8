package donets.danylo.mobileandcloudtechnologies.lab8.LR.LR3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.content.ContextCompat
import donets.danylo.mobileandcloudtechnologies.lab8.R

class LR3Task4 : AppCompatActivity() {

    private var numRows: Int = 0
    private var numColumns: Int = 0
    private var matrix: Array<IntArray>? = null
    private var min: Int = 0
    private var max: Int = 0
    private var minX: Int = 0
    private var minY: Int = 0
    private var maxX: Int = 0
    private var maxY: Int = 0

    private var rowsText: EditText? = null
    private var columnText: EditText? = null
    private var tableLayout: TableLayout? = null
    private var maxTextView: TextView? = null
    private var minTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lr3_task4)


        rowsText = findViewById(R.id.rowsText)
        columnText = findViewById(R.id.columnText)
        tableLayout = findViewById(R.id.tableLayout)
        maxTextView = findViewById(R.id.maxTextView)
        minTextView = findViewById(R.id.minTextView)

        val generateTableButton: Button = findViewById(R.id.generateTableButton)
        generateTableButton.setOnClickListener {
            generateTable()
        }

        val countButton: Button = findViewById(R.id.countButton)
        countButton.setOnClickListener {
            count()
        }

        val changeButton: Button = findViewById(R.id.changeButton)
        changeButton.setOnClickListener {
            changeValues()
        }

        val randomFillButton: Button = findViewById(R.id.randomFillButton)
        randomFillButton.setOnClickListener {
            randomFillMatrix()
        }
    }

    private fun generateTable() {
        val rowsTextValue = rowsText?.text.toString()
        val columnTextValue = columnText?.text.toString()

        if (rowsTextValue.isEmpty() || columnTextValue.isEmpty()) {
            return
        }

        numRows = rowsTextValue.toInt()
        numColumns = columnTextValue.toInt()

        matrix = Array(numRows) { IntArray(numColumns) }

        tableLayout?.removeAllViews()

        for (i in 0 until numRows) {
            val tableRow = TableRow(this)
            for (j in 0 until numColumns) {
                val textView = TextView(this)
                val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT)
                layoutParams.setMargins(10, 10, 10, 10)
                textView.layoutParams = layoutParams
                textView.text = "0"
                matrix!![i][j] = 0
                tableRow.addView(textView)
            }
            tableLayout?.addView(tableRow)
        }
    }

    private fun count() {
        max = Int.MIN_VALUE
        min = Int.MAX_VALUE
        maxX = 0
        maxY = 0
        minX = 0
        minY = 0

        for (i in 0 until numRows) {
            for (j in 0 until numColumns) {
                if (j >= i && j <= numColumns / 2) {
                    if (matrix!![i][j] > max) {
                        max = matrix!![i][j]
                        maxX = i
                        maxY = j
                    }
                } else if (j >= numColumns / 2 && j <= numColumns / 2 + numColumns / 2 && i >= numRows / 2) {
                    if (matrix!![i][j] < min) {
                        min = matrix!![i][j]
                        minX = i
                        minY = j
                    }
                }
            }
        }

        maxTextView?.text = "Max: $max"
        minTextView?.text = "Min: $min"
    }

    private fun changeValues() {
        if (matrix != null) {
            val temp = matrix!![maxX][maxY]
            matrix!![maxX][maxY] = matrix!![minX][minY]
            matrix!![minX][minY] = temp

            val maxCell = tableLayout?.getChildAt(maxX) as TableRow
            val maxTextView = maxCell.getChildAt(maxY) as TextView
            maxTextView.text = matrix!![maxX][maxY].toString()

            val minCell = tableLayout?.getChildAt(minX) as TableRow
            val minTextView = minCell.getChildAt(minY) as TextView
            minTextView.text = matrix!![minX][minY].toString()

            count()
        }
    }

    private fun randomFillMatrix() {
        if (matrix != null) {
            for (i in 0 until numRows) {
                for (j in 0 until numColumns) {
                    matrix!![i][j] = (0..99).random()
                    val cell = tableLayout?.getChildAt(i) as TableRow
                    val textView = cell.getChildAt(j) as TextView
                    textView.text = matrix!![i][j].toString()
                }
            }
            maxTextView?.text = "Max: "
            minTextView?.text = "Min: "
        }
    }




    override fun onBackPressed() {
        val intent = Intent(this@LR3Task4, LR3MainWindow::class.java)
        startActivity(intent)
        finish()
        super.onBackPressed()
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}