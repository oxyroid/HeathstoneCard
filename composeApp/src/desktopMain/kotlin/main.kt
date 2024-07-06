import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.oxyroid.hscard.App

fun main() {
    System.setProperty(
        "apple.awt.application.name",
        "HeathstoneCard",
    )
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "HeathstoneCard",
        ) {
            App()
        }
    }
}
