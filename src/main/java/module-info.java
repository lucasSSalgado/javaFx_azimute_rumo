module com.example.conversor_azimute_rumo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.conversor_azimute_rumo to javafx.fxml;
    exports com.example.conversor_azimute_rumo;
}