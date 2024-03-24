package view

@JvmRecord
data class ApplicationContext(
    val properties: ApplicationProperties,
    val components: ApplicationComponents,
)
