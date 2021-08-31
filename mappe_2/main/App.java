package edu.ntnu.idatt2001.trygveam.mappe_2;

import edu.ntnu.idatt2001.trygveam.mappe_2.controllers.FileController;
import edu.ntnu.idatt2001.trygveam.mappe_2.controllers.PrimaryController;
import edu.ntnu.idatt2001.trygveam.mappe_2.core.Patient;
import edu.ntnu.idatt2001.trygveam.mappe_2.core.PatientRegister;
import edu.ntnu.idatt2001.trygveam.mappe_2.factory.NodeFactory;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Properties;

/**
 * JavaFX App
 */
public class App extends Application {

    /**
     * The Table view.
     */
    @FXML
    TableView<Patient> tableView;
    /**
     * The Status label.
     */
    @FXML
    Label statusLabel;

    @FXML
    private TableColumn<Patient, String> firstNameColumn;
    @FXML
    private TableColumn<Patient, String> lastNameColumn;
    @FXML
    private TableColumn<Patient, String> socialSecurityNumberColumn;

    private PrimaryController primaryController;
    private FileController fileController;
    private static Scene scene;
    private Stage stage;
    private PatientRegister patientRegister;
    private ObservableList<Patient> patientRegisterTableView;
    private TableView<Patient> patientTableView;
    private Filehandler filehandler;

    /**
     * Sets root.
     *
     * @param fxml the fxml
     * @throws IOException the io exception
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch();
    }

    /**
     * Gets table view.
     *
     * @return the table view
     */
    public TableView<Patient> getTableView() {
        return tableView;
    }

    /**
     * Gets stage.
     *
     * @return the stage
     */
    public Stage getStage() {
        return stage;
    }

    /**
     * Gets patient table view.
     *
     * @return the patient table view
     */
    public TableView<Patient> getPatientTableView() {
        return patientTableView;
    }

    /**
     * Gets patient register.
     *
     * @return the patient register
     */
    public PatientRegister getPatientRegister() {
        return patientRegister;
    }

    /**
     * Initialize, method that launches when application starts
     */
    public void initialize() {
        // Initializing different controllers and important classes
        primaryController = new PrimaryController(this);
        fileController = new FileController(this);

        patientRegister = new PatientRegister();
        filehandler = new Filehandler();

        // Setting column table view and updating tableview with elements
        setColumnTableView();
        addFillInfoPatients();
        updateInformation();
        // Setting up and updating status bar
        updateStatusBar("OK");

    }

    /**
     * Update information method for calling updateObservableList and updateTableView.
     */
    public void updateInformation(){
        updateObservableList();
        updateTableView();
    }

    // privat method for updating tableview and setting elements for patientRegisterTableView
    private void updateTableView() {
        this.tableView.setItems(getPatientRegisterTableView());
    }

    // privat help  method for setting patientRegisterTableView with elements for patientsRegister
    private void updateObservableList() {
        this.patientRegisterTableView = this.patientRegister.getPatients();
    }

    // Setting up column table with firstName, lastName and social security number (ssn)
    private void setColumnTableView() {
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        socialSecurityNumberColumn.setCellValueFactory(new PropertyValueFactory<>("socialSecurityNumber"));
    }

    /**
     * Gets patient register table view.
     *
     * @return the patient register table view
     */
    public ObservableList<Patient> getPatientRegisterTableView() {
        return patientRegisterTableView;
    }


    private void addFillInfoPatients() {
        Patient p1 = new Patient("12345678910", "Tobias", "Oldervik", "Retard", "Dr.Felde");
        Patient p2 = new Patient("22345678910", "Lars", "Bindingen", "Inhabil", "Dr.Felde");
        patientRegister.addPatient(p1);
        patientRegister.addPatient(p2);
    }

    /**
     * Menu item import called from edit, and load in menuItem, calling method in fileController.
     */
    @FXML
    public void menuItemImport() {
        fileController.importFromCSV(getStage());
    }

    /**
     * Menu item export called from edit and export in menuItem, calling method in fileController.
     */
    @FXML
    public void menuItemExport() {
        fileController.exportToFile(this.getStage());
    }

    /**
     * Exit.
     */
    @FXML
    public void exit() {
        System.out.println("exit");
    }

    // APPLICATION

    /**
     * Menu item add.
     */
    @FXML
    public void menuItemAdd() {
        primaryController.displayDialog(false);
    }

    /**
     * Menu item edit.
     */
    @FXML
    public void menuItemEdit() {
        if (tableView.getSelectionModel().getSelectedItem() == null) {
            NodeFactory.createAlert("SELECT WARNING","SELECT PATIENT","You need to select an patient before choosing to edit it");
        } else {
            primaryController.displayDialog(true);
        }
    }

    /**
     * Menu item remove.
     */
    @FXML
    public void menuItemRemove() {
        if (tableView.getSelectionModel().getSelectedItem() == null) {
          NodeFactory.createAlert("SELECT WARNING","SELECT PATIENT","You need to select an patient before choosing to remove it");
        }else{
            boolean temp = NodeFactory.createConfirmationDialog("DELETE PATIENT", "Are you sure you want to delete the selected Patient?");
            if(temp){
                patientRegister.removePatient(tableView.getSelectionModel().getSelectedItem());
                updateStatusBar("Removed Patient");
            }
        }
    }

    /**
     * Menu item about.
     *
     * @throws IOException the io exception
     */
    @FXML
    public void menuItemAbout() throws IOException {
       primaryController.displayAboutAlert();
    }

    /**
     * Update status bar with string as input
     *
     * @param status the status
     */
    public void updateStatusBar(String status){
        statusLabel.setText("Status: " + status);
    }

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("fxml/primary"));
        stage.setScene(scene);
        stage.show();
    }

}