package edu.ntnu.idatt2001.trygveam.oblig3;

import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * The type Secondary controller.
 *
 * @author trygveam
 */
public class SecondaryController {


    /**
     * The Deal button.
     */
    @FXML Button dealButton;
    /**
     * The Check button.
     */
    @FXML Button checkButton;
    /**
     * The Exit button.
     */
    @FXML Button exitButton;
    /**
     * The Card display.
     */
    @FXML Label cardDisplay;
    /**
     * The Result display.
     */
    @FXML Label resultDisplay;


    private DeckOfCards deckOfCards;
    private Hand hand;

    /**
     * Initialize.
     */
    @FXML
    public void initialize(){
        checkButton.setDisable(true);
        deckOfCards = new DeckOfCards();
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setWidth(50);
        a.setHeight(50);
        a.setHeaderText("User Guide");
        a.setContentText("Please read the information given: \n Click 'Deal hand' to receive 5 cards \n Click check hand to check cards properties");
        a.show();
    }

    @FXML
    private void dealHand() throws IOException {
        this.hand = new Hand((ArrayList<PlayingCard>) deckOfCards.dealHand(5));
        cardDisplay.setText(hand.toString());
        checkButton.setDisable(false);
        dealButton.setDisable(true);
        resultDisplay.setText("");

    }

    @FXML
    private void checkHand() throws IOException {
        checkButton.setDisable(true);
        dealButton.setDisable(false);
        StringBuilder sb = new StringBuilder();
        sb.append("sum of cards: ");
        sb.append(hand.sumCards()).append("\n");
        sb.append("Hearts: ");
        sb.append(hand.checkIfContainsHearts()).append("\n");
        sb.append("queen of spades? ");
        sb.append(hand.checkIfQueenSpadesPresent()).append("\n");
        sb.append("flush? ");
        sb.append(hand.checkForFlush()).append("\n");
        resultDisplay.setText(sb.toString());
    }
    @FXML
    private void exit() throws IOException {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}