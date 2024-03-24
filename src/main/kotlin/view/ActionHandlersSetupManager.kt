package view

import java.awt.Component
import java.awt.event.ActionEvent

class ActionHandlersSetupManager(private val context: ApplicationContext) {
    fun setupActionHandlers(application: SyndromeMethodPlaygroundApplication) {
        fun updateSelected(tool: Component) {
        }

        fun codeChooseActionListener(event: ActionEvent) {
//            val actionButton = event.source as JComponent
//            context.components.field.setPenStyle(
//                when (actionButton.name) {
//                    "toolbar_button_pen", "menu_tools_button_pen" -> DrawField.PenStyle.PEN
//                    "toolbar_button_star", "menu_tools_button_star" -> DrawField.PenStyle.STAR
//                    "toolbar_button_regular", "menu_tools_button_regular" -> DrawField.PenStyle.REGULAR
//                    "toolbar_button_line", "menu_tools_button_line" -> DrawField.PenStyle.LINE
//                    "toolbar_button_eraser", "menu_tools_button_eraser" -> DrawField.PenStyle.ERASER
//                    "toolbar_button_fill", "menu_tools_button_fill" -> DrawField.PenStyle.FILL
//                    else -> throw IllegalStateException("действие для выбранного инструмента не определено")
//                }
//            )
//            updateSelected(actionButton)
        }
        val optionsPanel = CodeOptionsPanel(context)
        context.components.playground.add(optionsPanel)
//
//        val penTool = ComponentManager.findById<JButton>("toolbar_button_pen")
//        penTool.addActionListener(::codeChooseActionListener)
//
//        val starTool = ComponentRegistry.findById<JButton>("toolbar_button_star")
//        starTool.addActionListener(::baseToolActionListener)
//
//        val regularTool = ComponentRegistry.findById<JButton>("toolbar_button_regular")
//        regularTool.addActionListener(::baseToolActionListener)
//
//        val lineTool = ComponentRegistry.findById<JButton>("toolbar_button_line")
//        lineTool.addActionListener(::baseToolActionListener)
//
//        val fillTool = ComponentRegistry.findById<JButton>("toolbar_button_fill")
//        fillTool.addActionListener(::baseToolActionListener)
//
//        val clearAllTool = ComponentRegistry.findById<JButton>("toolbar_button_clear_all")
//        clearAllTool.addActionListener {
//            context.components.field.setWhite()
//        }
//
//        val eraser = ComponentRegistry.findById<JButton>("toolbar_button_eraser")
//        eraser.addActionListener(::baseToolActionListener)
//
//        val options = ComponentRegistry.findById<JButton>("toolbar_button_options")
//        val optionsPanel = OptionsPanel(context)
//        options.addActionListener {
//            val confirm = JOptionPane.showConfirmDialog(
//                application,
//                optionsPanel,
//                StringResource.loadString("dialogue_options_label", context.properties.locale),
//                JOptionPane.OK_CANCEL_OPTION
//            )
//            if (JOptionPane.OK_OPTION == confirm) {
//                val size = optionsPanel.penSize
//                context.components.field.setThickness(size)
//                context.components.field.setRegularParameters(
//                    optionsPanel.angle,
//                    optionsPanel.numOfVertices,
//                    optionsPanel.bigRadius,
//                    optionsPanel.smallRadius
//                )
//            }
//        }
//        val menuOptions = ComponentRegistry.findById<JMenuItem>("menu_tools_button_tune")
//        menuOptions.addActionListener(options.actionListeners[0])
//
//        val palletButton = ComponentRegistry.findById<JButton>("toolbar_button_palette")
//        palletButton.addActionListener {
//            val colorNew = JColorChooser.showDialog(
//                null,
//                StringResource.loadString("dialogue_pallet_label", context.properties.locale),
//                Color.BLACK
//            )
//            colorNew?.let {
//                context.components.field.setColor(it)
//                palletButton.background = it
//            }
//        }
//
//        val redColor = ComponentRegistry.findById<JButton>("toolbar_button_red")
//        redColor.addActionListener {
//            context.components.field.setColor(Color.RED)
//            palletButton.background = Color.RED
//        }
//
//        val greenColor = ComponentRegistry.findById<JButton>("toolbar_button_green")
//        greenColor.addActionListener {
//            context.components.field.setColor(Color.GREEN)
//            palletButton.background = Color.GREEN
//        }
//
//        val blueColor = ComponentRegistry.findById<JButton>("toolbar_button_blue")
//        blueColor.addActionListener {
//            context.components.field.setColor(Color.BLUE)
//            palletButton.background = Color.BLUE
//        }
//
//        val blackColor = ComponentRegistry.findById<JButton>("toolbar_button_black")
//        blackColor.addActionListener {
//            context.components.field.setColor(Color.BLACK)
//            palletButton.background = Color.BLACK
//        }
//
//        val undoButton = ComponentRegistry.findById<JButton>("toolbar_button_undo")
//        undoButton.addActionListener {
//            context.components.field.undo()
//        }
//
//        /*View Menu action listeners*/
//        val eraserItem = ComponentRegistry.findById<JMenuItem>("menu_tools_button_eraser")
//        eraserItem.addActionListener(::baseToolActionListener)
//
//        val clearAllItem = ComponentRegistry.findById<JMenuItem>("menu_tools_button_clear")
//        clearAllItem.addActionListener {
//            context.components.field.setWhite()
//        }
//
//        val penItem = ComponentRegistry.findById<JMenuItem>("menu_tools_button_pen")
//        penItem.addActionListener(::baseToolActionListener)
//
//        val lineItem = ComponentRegistry.findById<JMenuItem>("menu_tools_button_line")
//        lineItem.addActionListener(::baseToolActionListener)
//
//        val regularItem = ComponentRegistry.findById<JMenuItem>("menu_tools_button_regular")
//        regularItem.addActionListener(::baseToolActionListener)
//
//        val starItem = ComponentRegistry.findById<JMenuItem>("menu_tools_button_star")
//        starItem.addActionListener(::baseToolActionListener)
//
//        val fillItem = ComponentRegistry.findById<JMenuItem>("menu_tools_button_fill")
//        fillItem.addActionListener(::baseToolActionListener)
//
//        val fieldSize = ComponentRegistry.findById<JMenuItem>("menu_tools_button_resize")
//        fieldSize.addActionListener {
//            val resizePanel = ComponentRegistry.findById<JPanel>("dialogue_resize")
//            val widthSpinner = (resizePanel.getComponent(1) as JSpinner)
//            val heightSpinner = (resizePanel.getComponent(3) as JSpinner)
//
//            val confirm = JOptionPane.showConfirmDialog(
//                null,
//                resizePanel,
//                StringResource.loadString("dialogue_resize_label", context.properties.locale),
//                JOptionPane.OK_CANCEL_OPTION
//            )
//
//            val newWidth = widthSpinner.value as Int
//            val newHeight = heightSpinner.value as Int
//
//            if (JOptionPane.OK_OPTION == confirm) {
//                context.components.field.resizeImage(newWidth, newHeight)
//                context.components.scrollPane.updateUI()
//            }
//        }
//
//        val aboutItem = ComponentRegistry.findById<JMenuItem>("menu_about_button_about")
//        aboutItem.addActionListener {
//            val instructionDialog = InstructionDialog(application, context)
//            instructionDialog.isVisible = true
//        }
//
//        val authorItem = ComponentRegistry.findById<JMenuItem>("menu_about_button_author")
//        authorItem.addActionListener {
//            JOptionPane.showMessageDialog(
//                context.components.field,
//                StringResource.loadString("dialogue_author_content", context.properties.locale),
//                StringResource.loadString("dialogue_author_title", context.properties.locale),
//                JOptionPane.INFORMATION_MESSAGE
//            )
//        }
    }
}