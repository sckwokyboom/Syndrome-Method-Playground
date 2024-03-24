package view

import java.awt.BorderLayout
import javax.swing.JFrame
import javax.swing.JScrollPane

class SyndromeMethodPlaygroundApplication(properties: ApplicationProperties) : JFrame(properties.windowTitle) {
    private val components: ApplicationComponents

    init {
        locale = properties.locale
        this.size = properties.windowSize
        this.minimumSize = properties.minimumWindowSize
        this.defaultCloseOperation = properties.defaultCloseOperation
        val playground = Playground()
        playground.preferredSize = this.size

        val scrollPane = JScrollPane(playground)

        components = ApplicationComponents(
            scrollPane,
            playground
        )

        layoutComponents()

        val context = ApplicationContext(properties, components)
        ActionHandlersSetupManager(context).setupActionHandlers(this)
    }

    private fun layoutComponents() {
        this.layout = BorderLayout()
        this.add(components.scrollPane, BorderLayout.CENTER)
        this.pack()
        this.isVisible = true
    }
}