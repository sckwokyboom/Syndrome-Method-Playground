package view

import javax.swing.JComponent

object ComponentManager {
    private val components: MutableMap<String, JComponent> = HashMap()

    fun register(component: JComponent) {
        assert(component.name != null)
        val name = component.name
        assert(name.isNotEmpty())
        assert(name.isNotBlank())
        components[component.name] = component
    }

    fun <T : JComponent?> findById(name: String, type: Class<T>): T {
        val component = components[name] ?: throw NoSuchElementException("Component with ID $name not found.")
        if (type.isInstance(component)) {
            return component as T
        } else {
            throw IllegalArgumentException("Component with name $name is either not registered or has an incompatible type.")
        }
    }

    fun all(): Collection<JComponent> {
        return components.values.stream().toList()
    }
}