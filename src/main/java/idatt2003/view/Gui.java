package idatt2003.view;

import idatt2003.controller.CenterController;
import idatt2003.data.PlayingCard;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import java.util.List;

public class Gui {
  CenterController centerController;

  public Gui() {
    this.centerController = new CenterController();
  }
  public void generatePage(Stage stage) {
    stage.setTitle("Card Game");

    //Visuals for a card
    StackPane card = new StackPane();
    Rectangle rectangle = new Rectangle(100, 150);
    rectangle.fillProperty().set(Color.WHITE);
    rectangle.setArcHeight(30);
    rectangle.setArcWidth(30);
    rectangle.setStroke(Color.BLACK);
    rectangle.setStrokeWidth(2);
    Text textCard = new Text("test");
    textCard.setFont(Font.font("Arial", FontWeight.BOLD, 20));
    textCard.setFill(Color.BLACK);
    textCard.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
    card.getChildren().addAll(rectangle, textCard);

    //center of the screen
    BorderPane center = new BorderPane();
    GridPane board = new GridPane();
    board.setMaxWidth(600);
    board.setMaxHeight(300);
    board.setHgap(15);
    board.addColumn(5);
    center.setCenter(board);

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

    Button button = new Button("Deal hand");
    button.setAlignment(Pos.CENTER);
    button.setPadding(new Insets(10, 10, 30, 10));
    bottom.setCenter(button);

    //Button show

    // Register the controller with the button
    if (button != null) {
      button.setOnAction(e -> {
        List <PlayingCard> hand = centerController.handleDealButtonPressed();
        updatePage(board, hand);
      });
    }


    BorderPane root = new BorderPane();
    root.setCenter(center);
    root.setBottom(bottom);
    root.setTop(top);


    stage.setScene(new Scene(root, 800, 600));
    stage.show();
  }

  public static void updatePage(GridPane gridPane, List<PlayingCard> cards) {
    gridPane.getChildren().clear();
    int row = 0;
    for (PlayingCard card : cards) {
      gridPane.add(generateCard(card.getAsString()), row, 0);
      row++;
    }

  }

  public static StackPane generateCard( String text) {
    StackPane card1 = new StackPane();
    Rectangle rectangle = new Rectangle(100, 150);
    rectangle.fillProperty().set(Color.WHITE);
    rectangle.setArcHeight(30);
    rectangle.setArcWidth(30);
    rectangle.setStroke(Color.BLACK);
    rectangle.setStrokeWidth(2);
    Text textCard = new Text(text);
    textCard.setFont(Font.font("Arial", FontWeight.BOLD, 20));
    textCard.setFill(Color.BLACK);
    textCard.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
    card1.getChildren().addAll(rectangle, textCard);

    return card1;
  }
}
