package tk.st0pcha.paintjavafx

import javafx.embed.swing.SwingFXUtils
import javafx.event.EventHandler
import javafx.fxml.FXML
import javafx.scene.canvas.Canvas
import javafx.scene.control.CheckBox
import javafx.scene.control.ColorPicker
import javafx.scene.control.TextField
import javafx.scene.image.Image
import javafx.scene.input.MouseEvent
import java.io.File
import javax.imageio.ImageIO


class Controller {
    @FXML
    private lateinit var colorPicker: ColorPicker

    @FXML
    private lateinit var size: TextField

    @FXML
    private lateinit var eraser: CheckBox

    @FXML
    private lateinit var canvas: Canvas

    fun initialize() {
        val c = canvas.graphicsContext2D
        canvas.onMouseDragged = EventHandler { e: MouseEvent ->
            val size = size.text.toDouble()
            val x = e.x - size / 2
            val y = e.y - size / 2
            if (eraser.isSelected) {
                c.clearRect(x, y, size, size)
            } else {
                c.fill = colorPicker.value
                c.fillRoundRect(x, y, size, size, size, size)
            }
        }
    }

    fun save() {
        try {
            val snapshot: Image = canvas.snapshot(null, null)
            ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", File("image.png"))
        } catch (e: Exception) {
            println("Failed to save image: $e")
        }
    }
}