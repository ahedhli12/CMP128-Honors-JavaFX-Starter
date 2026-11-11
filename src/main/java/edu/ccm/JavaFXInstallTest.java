package edu.ccm;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/** A small setup check, not the student's honors project solution. */
public class JavaFXInstallTest extends Application {
    private int clickCount = 0;

    @Override
    public void start(Stage stage) {
        Label status = new Label("JavaFX started successfully.");
        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name");
        Button testButton = new Button("Test JavaFX");

        // A button click runs this event handler.
        testButton.setOnAction(event -> {
            String name = nameField.getText().trim();
            if (name.isEmpty()) {
                status.setText("Enter a name, then try again.");
            } else {
                clickCount++;
                status.setText("Hello, " + name + "! Button clicks: " + clickCount);
            }
        });

        VBox root = new VBox(12, status, nameField, testButton);
        root.setPadding(new Insets(20));
        stage.setTitle("CMP 128 JavaFX Installation Test");
        stage.setScene(new Scene(root, 440, 180));
        stage.show();
    }
}
