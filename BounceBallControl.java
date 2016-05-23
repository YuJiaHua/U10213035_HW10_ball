import java.util.ArrayList;

import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.stage.*;

public class BounceBallControl extends Application {
    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
	ArrayList<BallPane> ball = new ArrayList<>();
	int i;
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        BallPane ballPane = new BallPane(); // Create a ball pane

        // Pause and resume animation       
        ballPane.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                ballPane.pause();
            }
        });
        ballPane.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                ballPane.play();
            }
        });

        // Increase and decrease animation
        ballPane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                ballPane.increaseSpeed();
            } else if (e.getCode() == KeyCode.DOWN) {
                ballPane.decreaseSpeed();
            }	
        });
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(ballPane, 300, 400);
        primaryStage.setTitle("BounceBallControl"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        // Must request focus after the primary stage is displayed
        ballPane.requestFocus();
    }
}
