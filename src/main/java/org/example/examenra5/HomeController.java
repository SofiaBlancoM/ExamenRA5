package org.example.examenra5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;

public class HomeController {

    @FXML
    public VBox root;

    @FXML
    public void onOpenButtonAction(ActionEvent event) {

        try(InputStream inputStream = MainApplication.class.getResourceAsStream("/playlist-report.jrxml")){

            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JREmptyDataSource());
            JasperViewer.viewReport(jasperPrint, false);

        }
        catch (JRException | IOException e){
            System.out.println("Error al abrir el informe");
            e.printStackTrace();
        }

    }

    @FXML
    public void onCloseButtonAction(ActionEvent event) {
        System.exit(0);
    }

}
