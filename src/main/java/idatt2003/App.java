package idatt2003;

import idatt2003.view.Gui;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class App extends Application {
  public void start(Stage stage) throws IOException {
    Gui.generatePage(stage);
  }

  public static void main(String[] args) {
    launch(args);
  }
}
