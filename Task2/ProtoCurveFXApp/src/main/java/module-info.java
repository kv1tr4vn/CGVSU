module com.cgvsu.rasterizationfxapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.cgvsu.protocurvefxapp to javafx.fxml;
    exports com.cgvsu.protocurvefxapp;
}