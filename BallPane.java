import javafx.animation.*;
import javafx.beans.property.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.util.*;

public class BallPane extends Pane {
    public final double radius = 10;
    private double x[] = {100,100,150}, y[] = {10,200,10};
    private double dx[] = {1,1,1}, dy[] = {1,1,1};
    private Circle[] circle = {new Circle(x[0], y[0], radius),new Circle(x[1], y[1], radius+10),new Circle(x[2], y[2], radius+20)};
    private Timeline animation;

    public BallPane() {
        circle[0].setFill(Color.GREEN); // Set ball color
        circle[1].setFill(Color.RED);
        circle[2].setFill(Color.YELLOW);
        getChildren().addAll(circle); // Place a ball into this pane

        // Create an animation for moving the ball
        animation = new Timeline(
                new KeyFrame(Duration.millis(50), e -> moveBall()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play(); // Start animation
    }

    public void play() {
        animation.play();
    }

    public void pause() {
        animation.pause();
    }

    public void increaseSpeed() {
        animation.setRate(animation.getRate() + 0.1);
    }

    public void decreaseSpeed() {
        animation.setRate(
                animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
    }

    public DoubleProperty rateProperty() {
        return animation.rateProperty();
    }

    protected void moveBall() {
        // Check boundaries
    	for(int i = 0; i< 3; i++){
        if (x[i] < radius || x[i] > getWidth() - radius) {
            dx[i] *= -1; // Change ball move direction
        }
        if (y[i] < radius || y[i] > getHeight() - radius) {
            dy[i] *= -1; // Change ball move direction
        }
        

        // Adjust ball position
        x[i] += dx[i];
        y[i] += dy[i];      
        circle[i].setCenterX(x[i]);
        circle[i].setCenterY(y[i]);
    	}
    }
}
