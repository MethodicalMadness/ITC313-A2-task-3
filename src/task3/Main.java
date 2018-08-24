package task3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

    private double paneWidth = 480;
    private double paneHeight = 150;
    private Label label = new Label("Programming is fun");
    private ComboBox<String> cboFontName = new ComboBox<>();
    private ComboBox<Integer> cboFontSize = new ComboBox<>();
    private CheckBox chkBold = new CheckBox("Bold");
    private CheckBox chkItalic = new CheckBox("Italic");

    /**
     * Sets the stage, gets fonts, displays gui.
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane pane = new BorderPane();
        pane.setCenter(label);

        // Create a scene and place it in the stage
        primaryStage.setTitle("ITC313 Task 3 -Michael Coleman");
        primaryStage.setScene(new Scene(pane, paneWidth, paneHeight));
        primaryStage.show();

        // Populate font name into combo box
        ArrayList<String> fontNames = new ArrayList<>();
        fontNames.add("Arial");
        fontNames.add("Calibri");
        fontNames.add("Comic Sans MS");
        fontNames.add("Consolas");
        fontNames.add("Constantia");
        fontNames.add("Courier New");
        fontNames.add("Rockwell Nova");
        fontNames.add("Times New Roman ");
        fontNames.add("Trebuchet MS");
        fontNames.add("Verdana");
        cboFontName.getItems().addAll(fontNames);
        cboFontName.setValue(fontNames.get(0));

        // Populate font size into combo box
        cboFontSize.getItems().add(8);
        cboFontSize.getItems().add(12);
        cboFontSize.getItems().add(16);
        cboFontSize.getItems().add(24);
        cboFontSize.getItems().add(30);
        cboFontSize.getItems().add(36);
        cboFontSize.getItems().add(42);
        cboFontSize.getItems().add(48);
        cboFontSize.getItems().add(56);
        cboFontSize.setValue(12);

        //setup our horizontal boxes
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(new Label("Font Name"), cboFontName, new Label("Font Size"), cboFontSize);
        hBox.setAlignment(Pos.CENTER);
        pane.setTop(hBox);
        HBox hBox1 = new HBox(10);
        hBox1.getChildren().addAll(chkBold, chkItalic);
        hBox1.setAlignment(Pos.CENTER);
        pane.setBottom(hBox1);

        //when an action occurs, update the font
        cboFontName.setOnAction(e -> {
            setFont();
        });

        cboFontSize.setOnAction(e -> {
            setFont();
        });

        chkBold.setOnAction(e -> {
            setFont();
        });

        chkItalic.setOnAction(e -> {
            setFont();
        });
    }

    /**
     * when called updates the label
     */
    private void setFont() {
        FontWeight weight;
        FontPosture posture;
        if (chkBold.isSelected()) {
            weight = FontWeight.BOLD;
        } else {
            weight = FontWeight.NORMAL;
        }
        if (chkItalic.isSelected()) {
            posture = FontPosture.ITALIC;
        } else {
            posture = FontPosture.REGULAR;
        }
        label.setFont(Font.font(cboFontName.getValue(), weight, posture,
                cboFontSize.getValue()));
    }

    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
