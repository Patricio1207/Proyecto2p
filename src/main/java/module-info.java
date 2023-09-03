module ec.edu.espol.avance {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.logging;

    opens ec.edu.espol.avance to javafx.fxml;
    exports ec.edu.espol.avance;
    opens ec.edu.espol.controllers to javafx.fxml;
    exports ec.edu.espol.controllers;
    opens ec.edu.espol.model to javafx.fxml;
    exports ec.edu.espol.model;
}
