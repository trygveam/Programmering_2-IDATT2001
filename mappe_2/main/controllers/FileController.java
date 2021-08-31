package edu.ntnu.idatt2001.trygveam.mappe_2.controllers;

import edu.ntnu.idatt2001.trygveam.mappe_2.App;
import edu.ntnu.idatt2001.trygveam.mappe_2.Filehandler;
import edu.ntnu.idatt2001.trygveam.mappe_2.factory.NodeFactory;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.Optional;

/**
 * @author trygveam
 * The type File controller.
 */
public class FileController {

    private App app;

    /**
     * Instantiates a new File controller.
     *
     * @param app the app
     */
    public FileController(App app){
        this.app = app;
    }

    /**
     * Import from csv method, launching fileChooser and taking user input on location.
     *
     * @param stage the stage
     */
    public void importFromCSV(Stage stage){
        // Creating fileChooser object for accessing files
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                // File extensions for import, user should be able to choose every file, but only csv files are accepted
                new FileChooser.ExtensionFilter("All Files", "*.*"),
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                new FileChooser.ExtensionFilter("CSV","*.csv"));
        fileChooser.setTitle("Import");
        File selectedFile = fileChooser.showOpenDialog(stage);
        // To check if file extensions is csv, true if match
        boolean match = selectedFile.getAbsolutePath().substring(selectedFile.getAbsolutePath().length()-3).equals("csv");
        while(!match) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Not Valid File");
                alert.setHeaderText("The file type is not supported");
                alert.setContentText("Press show files to open file chooser, or cancel to abort");
                ButtonType buttonTypeShowFiles = new ButtonType("Show Files");
                ButtonType buttonTypeCancel = new ButtonType("Cancel");
                alert.getButtonTypes().setAll(buttonTypeShowFiles, buttonTypeCancel);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get().equals(buttonTypeShowFiles)) {
                    selectedFile = fileChooser.showOpenDialog(stage);
                    match = selectedFile.getAbsolutePath().substring(selectedFile.getAbsolutePath().length()-3).equals("csv");
                } else {
                    break;
                }
            }
        if(match){
            try {
                app.getPatientRegister().setPatients(Filehandler.readFromFile(selectedFile));
                app.updateInformation();
                app.updateStatusBar("Information imported");
            } catch (IOException ioe) {
                // Creating error message via factory for user to see
                NodeFactory.createAlert("ERROR ON IMPORT","Could not load from file, errormessage: ", ioe.getMessage());
                ioe.printStackTrace();
            }
        }
        }

    /**
     * Export to file method, launching filechooser and taking file name and location. Windows will automatically check if
     * file exist already, no need to implement this. Overwrite message will come automatically.
     *
     * @param stage the stage
     */
    public void exportToFile(Stage stage){
        // Creating fileChooser object for accessing files
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Export");
        fileChooser.getExtensionFilters().addAll(
                // Adding only file extension for csv, only extensions allowed for export of patients.
                new FileChooser.ExtensionFilter("CSV","*.csv"));
        File selectedFile = fileChooser.showSaveDialog(stage);
        if(selectedFile != null){
            try{
                Filehandler.loadToFile(selectedFile, app.getPatientRegister());
                app.updateStatusBar("Information Exported");
            }catch (IOException ioe){
                // Creating error message via factory for user to see
                NodeFactory.createAlert("ERROR ON EXPORT","Could not export the file, errormessage: ", ioe.getMessage());
            }
        }
    }
}
