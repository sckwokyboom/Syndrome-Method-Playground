package view

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import model.Experimenter
import model.code.Code
import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartPanel
import org.jfree.chart.plot.PlotOrientation
import org.jfree.data.xy.XYSeries
import org.jfree.data.xy.XYSeriesCollection
import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.SwingUtilities


class Chart : JPanel() {
    private var chartPanel: ChartPanel = ChartPanel(null)
    fun update(code: Code, numOfIterations: Int, step: Double) {
//        val exServ = Executors.newSingleThreadExecutor()
//        exServ.submit(() -> this::updateChart)
        CoroutineScope(Dispatchers.IO).launch {
            val label = JLabel("This is a centered label")
            // Создание JPanel
            val panel = JPanel()
            panel.layout = BorderLayout()
            // Добавление JLabel в JPanel
            panel.add(label, BorderLayout.CENTER)
            this@Chart.add(panel)
            this@Chart.setSize(400, 300);
            updateChart(code, numOfIterations, step)
            repaintChart()
            SwingUtilities.invokeLater {
                parent.revalidate()
                parent.repaint()
            }
            println("REPAINT!")
        }
    }

    private fun updateChart(code: Code, numOfIterations: Int, step: Double) {
        // TODO: invariants???
        val experimenter = Experimenter()
        val chartPoints = experimenter.getData(code, numOfIterations, step)
        // Создание графика
        val series = XYSeries("Data")
        for (point in chartPoints) {
            series.add(point.channelErrorProbability, point.proportionOfIncorrectlyDecodedFragments)
        }
        val dataset = XYSeriesCollection(series)
        val chart = ChartFactory.createXYLineChart(
            "Зависимость доли неправильно декодированных сообщений от вероятности ошибки в канале",
            "Вероятность ошибки в канале",
            "Доля неправильно декодированных сообщений",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        )
        chartPanel = ChartPanel(chart)
        chartPanel.preferredSize = Dimension(500, 500)
        this.setSize(300, 300)

    }

    fun repaintChart() {
        this.removeAll()
        this.add(chartPanel)
        this.repaint()
    }
}