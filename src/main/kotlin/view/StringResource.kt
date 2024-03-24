package view;

import java.util.*

object StringResource {

    fun loadString(key: String, locale: Locale): String {
        val bundle = ResourceBundle.getBundle("strings", locale)
        return bundle.getString(key)
    }
}