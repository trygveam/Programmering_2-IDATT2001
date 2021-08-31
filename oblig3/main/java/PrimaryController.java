package edu.ntnu.idatt2001.trygveam.oblig3;

import java.io.IOException;
import javafx.fxml.FXML;

/**
 * The type Primary controller.
 * @author trygveam
 */
public class PrimaryController {
    /**
     * Method for changing to secondary.fxml after clicking start program
     * @throws IOException
     */
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

}
