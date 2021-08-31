package edu.ntnu.idatt2001.trygveam.mappe_2.factory;

import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.Optional;

/**
 * @author trygveam
 * The type Node factory.
 */
public class NodeFactory {

    /**
     * Create nodes corresponding to string input, return the node .
     *
     * @param type the type
     * @return the node
     */
    public static Node createNodes(String type) {
        if (type.isEmpty() || type.isBlank()) {
            return null;
        } else if (type.equalsIgnoreCase("gridpane")) {
            return new GridPane();
        } else if (type.equalsIgnoreCase("tableview")) {
            return new TableView();
        } else if (type.equalsIgnoreCase("menubar")) {
            return new MenuBar();
        } else if (type.equalsIgnoreCase("toolbox")) {
            return new ToolBar();
        } else if (type.equalsIgnoreCase("hbox")) {
            return new HBox();
        }else if(type.equalsIgnoreCase("textfield")){
            return new TextField();
        }
        return null;
    }

    /**
     * Create Alert with input with title, header and content.
     *
     * @param title   the title
     * @param header  the header
     * @param content the content
     */
    public static void createAlert(String title, String header, String content){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.show();
    }

    /**
     * Create confirmation dialog with header and content strings for input.
     * Returns true if OK button is clicked, false otherwise
     *
     * @param header  the header
     * @param content the content
     * @return the boolean
     */
    public static boolean createConfirmationDialog(String header, String content){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(header);
        alert.setContentText(content);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            return true;
        }return false;

    }

}