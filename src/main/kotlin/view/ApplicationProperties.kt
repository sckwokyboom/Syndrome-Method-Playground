package view

import java.awt.Dimension
import java.util.*

data class ApplicationProperties(
    val windowTitle: String,
    val windowSize: Dimension,
    val minimumWindowSize: Dimension,
    val defaultCloseOperation: Int,
    val locale: Locale,
)