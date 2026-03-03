module org.example.examenra5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires jasperreports;
    requires java.sql;


    opens org.example.examenra5 to javafx.fxml;
    exports org.example.examenra5;
}