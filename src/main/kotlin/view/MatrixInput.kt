package view

import java.awt.GridLayout
import javax.swing.JButton
import javax.swing.JPanel
import javax.swing.JTextField

class MatrixInput(private val rows: Int, private val columns: Int) : JPanel() {
    private val textFields = Array(rows) { Array(columns) { JTextField() } }
    var matrix = Array(rows) { IntArray(columns) }

    init {
        val panel = JPanel(GridLayout(rows + 1, columns))

        for (i in 0 until rows) {
            for (j in 0 until columns) {
//                panel.add(JLabel("($i, $j):"))
                panel.add(textFields[i][j])
            }
        }

        val button = JButton("Записать")
        button.addActionListener {
            val matrix = Array(rows) { IntArray(columns) }
            for (i in 0 until rows) {
                for (j in 0 until columns) {
                    matrix[i][j] = textFields[i][j].text.toInt()
                }
            }
            for (i in 0 until rows) {
                for (j in 0 until columns) {
                    matrix[i][j] %= 2
                }
            }
            for (i in 0 until rows) {
                for (j in 0 until columns) {
                    textFields[i][j].text = matrix[i][j].toString()
                }
            }
        }

        panel.add(button)

        add(panel)
    }
}
