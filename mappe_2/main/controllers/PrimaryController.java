package edu.ntnu.idatt2001.trygveam.mappe_2.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

import edu.ntnu.idatt2001.trygveam.mappe_2.App;
import edu.ntnu.idatt2001.trygveam.mappe_2.PatientDialog;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.PathElement;

/**
 * The type Primary controller.
 */
public class PrimaryController {

   private App app;

    /**
     * Instantiates a new Primary controller.
     *
     * @param app the app
     */
    public PrimaryController(App app){
       this.app =  app;
   }

    /**
     * Display dialog.
     *
     * @param edit the edit
     */
    public void displayDialog(boolean edit){
        new PatientDialog(this.app, edit);
    }


    /**
     * Display about alert.
     *
     * @throws IOException the io exception if not able to gather information from project, ie. version
     */
    public void displayAboutAlert() throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");

        // Gathering properties from project.properties file in resources, displaying version on alert
        final Properties properties = new Properties();
        properties.load(app.getClass().getClassLoader().getResourceAsStream("project.properties"));
        alert.setHeaderText("Patient Dialogue \n" + properties.getProperty("version"));
        alert.setContentText("Application made by Trygve Amundsen in the class IDATT2001 at NTNU");
        alert.showAndWait();
        app.updateStatusBar("About Window Displayed");
    }

}
