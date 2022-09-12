package tk.st0pcha.paintjavafx

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.stage.Stage

class Main : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(Main::class.java.getResource("view.fxml"))
        val scene = Scene(fxmlLoader.load())
        stage.title = "st0pcha's paint"
        stage.isResizable = false
        stage.icons.add(Image("file:assets/icon.png"))
        stage.scene = scene
        stage.show()
    }
}

fun main() {
    Application.launch(Main::class.java)
}