module org.example.examenra5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires jasperreports;
    requires java.sql;
    requires org.xerial.sqlitejdbc;
    requires org.slf4j;


    opens org.example.examenra5;
    exports org.example.examenra5;
}