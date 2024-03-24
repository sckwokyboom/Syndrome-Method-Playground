package view

import java.awt.Component
import javax.swing.*

class CodeOptionsPanel(context: ApplicationContext) : JPanel() {
    private val hammingParameterSlider: JSlider
    private val hadamardParameterSlider: JSlider
    private val randomCodeLengthSlider: JSlider
    private val userParityCheckMatrixWidthSlider: JSlider
    private val userParityCheckMatrixHeightSlider: JSlider

    private val hammingParameterSpinner: JSpinner
    private val hadamardParameterSpinner: JSpinner
    private val randomCodeLengthSpinner: JSpinner
    private val userParityCheckMatrixWidthSpinner: JSpinner
    private val userParityCheckMatrixHeightSpinner: JSpinner

    init {
        this.layout = BoxLayout(this, BoxLayout.Y_AXIS)
        val hammingCodeLabel = JLabel(
            StringResource.loadString(
                "options_label_hamming_code_parameter",
                context.properties.locale
            )
        )
//        layout = GridBagLayout()
//        val gbc = GridBagConstraints()
//
//        gbc.fill = GridBagConstraints.HORIZONTAL
//        gbc.insets = Insets(2, 2, 2, 2)
        val hammingCodeMinParameter = 2
        val hammingCodeMaxParameter = 50
        hammingParameterSlider = createSlider(hammingCodeMinParameter, hammingCodeMaxParameter, 3, 1)
        hammingParameterSpinner =
            createSpinner(SpinnerNumberModel(3, hammingCodeMinParameter, hammingCodeMaxParameter, 1))
        hammingParameterSpinner.setToolTipText("[$hammingCodeMinParameter-$hammingCodeMaxParameter]")
        hammingParameterSlider.setToolTipText("[$hammingCodeMinParameter-$hammingCodeMaxParameter]")
        this.add(
            createRowComponent(
                "options_label_hamming_code_parameter",
                hammingCodeLabel,
                hammingParameterSlider,
                hammingParameterSpinner
            )
        )

        val hadamardCodeLabel = JLabel(
            StringResource.loadString(
                "options_label_hadamard_code_parameter",
                context.properties.locale
            )
        )
        hadamardParameterSlider = createSlider(hammingCodeMinParameter, hammingCodeMaxParameter, 3, 1)
        hadamardParameterSpinner =
            createSpinner(SpinnerNumberModel(3, hammingCodeMinParameter, hammingCodeMaxParameter, 1))
        hadamardParameterSlider.setToolTipText("[$hammingCodeMinParameter-$hammingCodeMaxParameter]")
        hadamardParameterSpinner.setToolTipText("[$hammingCodeMinParameter-$hammingCodeMaxParameter]")
        this.add(
            createRowComponent(
                "options_label_hadamard_code_parameter",
                hadamardCodeLabel,
                hadamardParameterSlider,
                hadamardParameterSpinner
            )
        )

        val randomCodeLabel = JLabel(
            StringResource.loadString(
                "options_label_random_code_parameter",
                context.properties.locale
            )
        )
        val randomCodeMinLength = 60
        val randomCodeMaxLength = 1000
        randomCodeLengthSlider = createSlider(randomCodeMinLength, randomCodeMaxLength, 60, 1)
        randomCodeLengthSpinner =
            createSpinner(SpinnerNumberModel(60, randomCodeMinLength, randomCodeMaxLength, 1))
        randomCodeLengthSpinner.setToolTipText("[$randomCodeMinLength-$randomCodeMaxLength]")
        randomCodeLengthSlider.setToolTipText("[$randomCodeMinLength-$randomCodeMaxLength]")
        this.add(
            createRowComponent(
                "options_label_random_code_parameter",
                randomCodeLabel,
                randomCodeLengthSlider,
                randomCodeLengthSpinner
            )
        )

        val userParityCheckMatrixWidthLabel = JLabel(
            StringResource.loadString(
                "options_label_user_code_parity_check_matrix_width",
                context.properties.locale
            )
        )
        val userParityCheckMatrixMinWidth = 1
        val userParityCheckMatrixMaxWidth = 16
        userParityCheckMatrixWidthSlider =
            createSlider(userParityCheckMatrixMinWidth, userParityCheckMatrixMaxWidth, 3, 1)
        userParityCheckMatrixWidthSpinner = createSpinner(
            SpinnerNumberModel(3, userParityCheckMatrixMinWidth, userParityCheckMatrixMaxWidth, 1)
        )
        userParityCheckMatrixWidthSpinner.setToolTipText("[$userParityCheckMatrixMinWidth-$userParityCheckMatrixMaxWidth]")
        userParityCheckMatrixWidthSlider.setToolTipText("[$userParityCheckMatrixMinWidth-$userParityCheckMatrixMaxWidth]")
        this.add(
            createRowComponent(
                "options_label_user_code_parity_check_matrix_width",
                userParityCheckMatrixWidthLabel,
                userParityCheckMatrixWidthSlider,
                userParityCheckMatrixWidthSpinner
            )
        )

        val userParityCheckMatrixHeight = JLabel(
            StringResource.loadString(
                "options_label_user_code_parity_check_matrix_height",
                context.properties.locale
            )
        )
        val userParityCheckMatrixMinHeight = 1
        val userParityCheckMatrixMaxHeight = 16
        userParityCheckMatrixHeightSlider =
            createSlider(userParityCheckMatrixMinHeight, userParityCheckMatrixMaxHeight, 3, 1)
        userParityCheckMatrixHeightSpinner = createSpinner(
            SpinnerNumberModel(3, userParityCheckMatrixMinHeight, userParityCheckMatrixMaxHeight, 1)
        )
        userParityCheckMatrixHeightSpinner.setToolTipText("[$userParityCheckMatrixMinHeight-$userParityCheckMatrixMaxHeight]")
        userParityCheckMatrixHeightSlider.setToolTipText("[$userParityCheckMatrixMinHeight-$userParityCheckMatrixMaxHeight]")
        this.add(
            createRowComponent(
                "options_label_user_code_parity_check_matrix_height",
                userParityCheckMatrixHeight,
                userParityCheckMatrixHeightSlider,
                userParityCheckMatrixHeightSpinner
            )
        )

        setupAllChangeListeners()
    }

    private fun createSlider(min: Int, max: Int, value: Int, majorTickSpacing: Int): JSlider {
        val slider = JSlider(JSlider.HORIZONTAL, min, max, value)
        slider.majorTickSpacing = majorTickSpacing
        slider.paintTicks = true
        return slider
    }

    private fun createRowComponent(rowId: String, vararg components: Component): JPanel {
        val row = JPanel()
        row.layout = BoxLayout(row, BoxLayout.X_AXIS)
        for (component in components) {
            row.add(component)
        }
        row.name = rowId
        return row
    }

    private fun createSpinner(model: SpinnerModel): JSpinner {
        val spinner = JSpinner(model)
        return spinner
    }

    private fun setupChangeListener(slider: JSlider, spinner: JSpinner) {
        slider.addChangeListener {
            spinner.value = slider.value
        }

        spinner.addChangeListener {
            slider.value = spinner.value as Int
        }
    }

    private fun setupAllChangeListeners() {
        setupChangeListener(hammingParameterSlider, hammingParameterSpinner)
        setupChangeListener(hadamardParameterSlider, hadamardParameterSpinner)
        setupChangeListener(randomCodeLengthSlider, randomCodeLengthSpinner)
        setupChangeListener(userParityCheckMatrixWidthSlider, userParityCheckMatrixWidthSpinner)
        setupChangeListener(userParityCheckMatrixHeightSlider, userParityCheckMatrixHeightSpinner)
    }

    fun resetValues(options: OptionsValues) {
        hammingParameterSlider.value = options.thickness
        randomCodeLengthSlider.value = options.figureRotationAngle
        hadamardParameterSlider.value = options.numberOfFigureVertices
        userParityCheckMatrixWidthSlider.value = options.outerRadius
        userParityCheckMatrixHeightSlider.value = options.innerRadius
    }

    fun getHammingParameter(): Int {
        return hammingParameterSlider.value
    }

    fun getHadamardParameter(): Int {
        return hadamardParameterSlider.value
    }

    fun getRandomCodeLength(): Int {
        return randomCodeLengthSlider.value
    }

    fun getUserParityCheckMatrixWidth(): Int {
        return userParityCheckMatrixWidthSlider.value
    }

    fun getUserParityCheckMatrixHeight(): Int {
        return userParityCheckMatrixHeightSlider.value
    }

}