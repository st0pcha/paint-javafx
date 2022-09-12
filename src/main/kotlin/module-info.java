module tk.st0pcha.paintjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.swing;
    requires kotlin.stdlib;


    opens tk.st0pcha.paintjavafx to javafx.fxml;
    exports tk.st0pcha.paintjavafx;
}