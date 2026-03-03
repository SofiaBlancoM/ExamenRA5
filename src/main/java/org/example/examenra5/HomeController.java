package org.example.examenra5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class HomeController {

    @FXML
    public VBox root;

    @FXML
    public TextField playlistIdTextField;

    private String urlDb = "jdbc:sqlite:db/chinook.db";

    @FXML
    public void onOpenButtonAction(ActionEvent event) {

        String jasperReportFilePath = "/report-playlist.jrxml";

        try(InputStream inputStream = MainApplication.class.getResourceAsStream(jasperReportFilePath)){

            System.out.println("Compilando: " + jasperReportFilePath);
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

            Connection connection = DriverManager.getConnection(urlDb);

            Map<String, Object> parametros = new HashMap<>();
            parametros.put("AUTOR", "Sofía Blanco Méndez");
            parametros.put("P_PLAYLIST_ID", playlistIdTextField.getText());

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, connection);
            JasperViewer.viewReport(jasperPrint, false);

        }
        catch (JRException | SQLException | IOException e){
            System.out.println("Error al abrir el informe");
            throw new RuntimeException(e);
        }

    }

    @FXML
    public void onCloseButtonAction(ActionEvent event) {
        System.exit(0);
    }

}
