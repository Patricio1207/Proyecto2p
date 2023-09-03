module ec.edu.espol.avance {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.logging;

    opens ec.edu.espol.avance to javafx.fxml;
    exports ec.edu.espol.avance;
    opens ec.edu.espol.avance.controller to javafx.fxml;
    exports ec.edu.espol.avance.controller;
    opens ec.edu.espol.avance.model to javafx.fxml;
    exports ec.edu.espol.avance.model;
}
