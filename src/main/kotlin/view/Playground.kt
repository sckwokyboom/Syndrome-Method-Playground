package view

import model.code.Code
import model.code.HadamardCode
import java.awt.BorderLayout
import java.awt.Graphics
import java.awt.image.BufferedImage
import javax.swing.*
import javax.swing.table.DefaultTableModel


class Playground : JPanel() {

    private val sliders = Array(3) { JSlider(SwingConstants.HORIZONTAL) }
    private val image = BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB)
    private val g = image.createGraphics()

    private val chart = Chart()
    private val table: JTable


    public override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        g.drawImage(image, 0, 0, this)
    }

    init {
        val chooseCodeButtonGroup = ButtonGroup()
        val hammingCodeButton = JRadioButton("Код Хэмминга")
        val hadamardCodeButton = JRadioButton("Код Адамара")
        val randomCodeButton =
            JRadioButton("Код с 5-ю единицами в случайных позициях каждого столбца проверочной матрицы")
        val userCodeByParityCheckMatrixButton = JRadioButton("По заданной проверочной матрице")

//        val listener = ActionListener { e: ActionEvent ->
//            val selectedRadioButton = e.source as JRadioButton
//            hammingCodeParameter.isVisible = selectedRadioButton === hammingCodeButton
//        }
//        hammingCodeButton.addActionListener(listener)

        // Добавление JRadioButton в ButtonGroup
        chooseCodeButtonGroup.add(hammingCodeButton)
        chooseCodeButtonGroup.add(hadamardCodeButton)
        chooseCodeButtonGroup.add(randomCodeButton)
        chooseCodeButtonGroup.add(userCodeByParityCheckMatrixButton)

        // Добавление JRadioButton в JPanel
        val chooseCodeButtonsPanel = JPanel()
        chooseCodeButtonsPanel.setLayout(BoxLayout(chooseCodeButtonsPanel, BoxLayout.Y_AXIS))
        chooseCodeButtonsPanel.add(hammingCodeButton)
        chooseCodeButtonsPanel.add(hadamardCodeButton)
        chooseCodeButtonsPanel.add(randomCodeButton)
        chooseCodeButtonsPanel.add(userCodeByParityCheckMatrixButton)

        val codeParametersSpinnersPanel = JPanel()
        codeParametersSpinnersPanel.setLayout(BoxLayout(codeParametersSpinnersPanel, BoxLayout.Y_AXIS))
        // Первый JSlider
        val hammingCodeParameter = JSlider(0, 50)
        val hammingCodeParameterSpinner = JSpinner(SpinnerNumberModel(0, 0, 50, 1))
        hammingCodeParameter.addChangeListener { hammingCodeParameterSpinner.value = hammingCodeParameter.value }

        // Второй JSlider
        val hadamardCodeParameter = JSlider(0, 50)
        val hadamardCodeParameterSpinner = JSpinner(SpinnerNumberModel(0, 0, 50, 1))
        hadamardCodeParameter.addChangeListener { hadamardCodeParameterSpinner.value = hadamardCodeParameter.value }

        // Третий JSlider
        val randomCodeLength = JSlider(60, 1000)
        val randomCodeLengthSpinner = JSpinner(SpinnerNumberModel(60, 60, 1000, 1))
        randomCodeLength.addChangeListener { randomCodeLengthSpinner.value = randomCodeLength.value }

        // Добавление элементов
        codeParametersSpinnersPanel.add(JLabel("Параметр кода Хэмминга:"))
        codeParametersSpinnersPanel.add(hammingCodeParameter)
        codeParametersSpinnersPanel.add(hammingCodeParameterSpinner)
        codeParametersSpinnersPanel.add(JLabel("0"))
        codeParametersSpinnersPanel.add(JLabel("50"))

        codeParametersSpinnersPanel.add(JLabel("Параметр кода Адамара:"))
        codeParametersSpinnersPanel.add(hadamardCodeParameter)
        codeParametersSpinnersPanel.add(hadamardCodeParameterSpinner)
        codeParametersSpinnersPanel.add(JLabel("0"))
        codeParametersSpinnersPanel.add(JLabel("50"))

        codeParametersSpinnersPanel.add(JLabel("Длина случайного кода:"))
        codeParametersSpinnersPanel.add(randomCodeLength)
        codeParametersSpinnersPanel.add(randomCodeLengthSpinner)
        codeParametersSpinnersPanel.add(JLabel("60"))
        codeParametersSpinnersPanel.add(JLabel("1000"))


        // Создание таблицы
        val tableModel = DefaultTableModel(
            arrayOf("Синдром", "Лидер"),
            0
        )
        for (i in 1 until 11) {
            tableModel.addRow(arrayOf("Row $i", "Value $i"))
        }
        tableModel.setColumnIdentifiers(arrayOf("Синдром", "Лидер"))
        table = JTable(tableModel)

        // Размещение элементов на экране
        val leftPanel = JPanel(BorderLayout())
//        leftPanel.add(slidersPanel)
//        leftPanel.add(chooseCodeButtonsPanel)
//        leftPanel.add(codeParametersSpinnersPanel)
//        leftPanel.add(CodeOptionsPanel(context))
        add(leftPanel, BorderLayout.WEST)

        add(this.chart, BorderLayout.SOUTH)
        chart.setSize(500, 500)
        chart.update(HadamardCode(4), 100000, 0.1)
        add(MatrixInput(3, 4))
        add(JScrollPane(table), BorderLayout.EAST)
        repaint()
    }
}