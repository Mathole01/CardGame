package idatt2003.view;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class Gui {
  public static void generatePage(Stage stage) {
    stage.setTitle("Card Game");

    //Visuals for a card
    StackPane Card = new StackPane();
    Rectangle rectangle = new Rectangle(100, 150);
    rectangle.fillProperty().set(Color.BLACK);
    Card.getChildren().add(rectangle);

    //center of the screen
    BorderPane center = new BorderPane();
    GridPane board = new GridPane();
    board.setMaxWidth(600);
    board.setMaxHeight(400);
    board.addColumn(5);
    board.add(Card, 0, 0);
    center.setCenter(board);
    center.setPadding(new Insets(10, 10, 10, 10));
    board.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
            new javafx.scene.layout.CornerRadii(10), BorderWidths.DEFAULT)));


    //top of the screen
    VBox top = new VBox();
    top.setMinHeight(100);
    top.setAlignment(javafx.geometry.Pos.CENTER);
    Text text = new Text("Card Game");
    text.setFill(Color.BLACK);
    text.setFont(Font.font("Arial", FontWeight.BOLD, 30));
    top.getChildren().add(text);



    //bottom of the screen
    BorderPane bottom = new BorderPane();
    bottom.setPadding(new Insets(10, 10, 10, 10));
    bottom.setMinHeight(150);
    Text bottomText = new Text("Actions");



    BorderPane root = new BorderPane();
    root.setCenter(center);
    root.setBottom(bottom);
    root.setTop(top);


    stage.setScene(new Scene(root, 800, 600));
    stage.show();
  }
}
