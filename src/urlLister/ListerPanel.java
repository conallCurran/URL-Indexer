package urlLister;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.sun.prism.Image;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;



public class ListerPanel extends Application {
	
	
	
	
	public static void main(String[] args) {
        launch(args);
    }
	
	
	final Button button = new Button ("Go");
	final Button button2 = new Button ("png files");
	final Button button3 = new Button ("Documents");
    final Label notification = new Label ();
    final TextField subject = new TextField("");
    final TextArea text =  new TextArea ("Text 1");
    final TextArea text2 = new TextArea ("Text 2");
    final TextArea text3 = new TextArea ("Text 3");
	
    @Override public void start(Stage stage) {
        stage.setTitle("URL Lister");
        Scene scene = new Scene(new Group(), 1250, 700);
        
        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(new Label("Server: "), 0, 0);
        grid.add(new Label("URL: "), 0, 1);       
        grid.add(subject, 1, 1, 3, 1);            
        grid.add(text,   1, 60, 2, 10);
        grid.add(text2, 10, 60, 2, 10);
        grid.add(text3, 10, 20, 2, 5);
        grid.add(button, 0, 3);
        grid.add(button2, 5, 60);
        grid.add(button3, 5, 65);
        grid.add (notification, 1, 3, 3, 1);
        
        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
    

   }
}
