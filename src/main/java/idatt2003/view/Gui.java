package idatt2003.view;

import idatt2003.controller.CenterController;
import idatt2003.controller.CheckButtonController;
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
  CheckButtonController checkButtonController;

  public Gui() {
    this.centerController = new CenterController();
    this.checkButtonController = new CheckButtonController();
  }

  public void generatePage(Stage stage) {
    stage.setTitle("Card Game");

    //center of the screen
    BorderPane center = new BorderPane();
    center.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY,
            new CornerRadii(10), Insets.EMPTY)));

    GridPane board = new GridPane();
    board.setMaxWidth(600);
    board.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD,
            new CornerRadii(10), Insets.EMPTY)));
    board.setMaxHeight(300);
    board.setHgap(15);
    board.addColumn(5);
    board.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
            new javafx.scene.layout.CornerRadii(10), BorderWidths.DEFAULT)));
    center.setCenter(board);


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

    Button checkHand = new Button("Check hand");
    checkHand.setPadding(new Insets(60, 10, 10, 10));
    bottom.setRight(checkHand);
    checkHand.setPadding(new Insets(110, 120, 50, 100));

    Button button = new Button("Deal hand");
    button.setPadding(new Insets(110, 120, 50, 100));
    bottom.setLeft(button);

    //bottom info
    BorderPane bottomInfo = new BorderPane();
    bottomInfo.setPadding(new Insets(10, 10, 10, 10));
    bottomInfo.setMinHeight(150);
    bottomInfo.setMinWidth(450);

    GridPane infoGrid = new GridPane();
    infoGrid.setMinHeight(150);
    infoGrid.setMinWidth(450);
    infoGrid.setPrefWidth(700);
    infoGrid.setHgap(40);
    infoGrid.setVgap(100);
    infoGrid.addColumn(2);
    infoGrid.addRow(2);

    bottomInfo.setCenter(infoGrid);
    bottom.setCenter(bottomInfo);





    //Button show

    // Register the controller with the button
    if (button != null) {
      button.setOnAction(e -> {
        List <PlayingCard> hand = centerController.handleDealButtonPressedGenerateNewHand();
        updatePage(board, hand);

        infoGrid.getChildren().clear();

      });
    }

    if(checkHand != null){
      checkHand.setOnAction(e -> {
        //store info into borderpanes
        BorderPane isFlush = generateInfoString("Flush:", checkButtonController
                .handleCheckHandButtonPressedFlush(centerController.getHand()) ? "Yes" : "No");
        BorderPane sum = generateInfoString("Sum: ", String.valueOf(checkButtonController
                .handleCheckHandButtonPressedGetSum(centerController.getHand())));
        BorderPane hasQueenOfSpades = generateInfoString("Queen of Spades: ",
                checkButtonController.handleCheckHandButtonPressedQueenOfSpades(centerController.getHand())
                        ? "Yes" : "No");
        BorderPane hearts = generateInfoString("Hearts: ",
                checkButtonController.handleCheckHandButtonGetHearts(centerController.getHand()));

        //add info borderpanes to grid for display
        updateInfo(infoGrid, isFlush, sum, hasQueenOfSpades, hearts);
      });
    }


    BorderPane root = new BorderPane();
    root.setCenter(center);
    root.setBottom(bottom);
    root.setTop(top);


    stage.setScene(new Scene(root, 1000, 800));
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

  public static void updateInfo(GridPane gridPane, BorderPane info1,
                                BorderPane info2, BorderPane info3, BorderPane info4) {
    gridPane.getChildren().clear();
    gridPane.add(info1, 0, 0);
    gridPane.add(info2, 1, 0);
    gridPane.add(info3, 0, 1);
    gridPane.add(info4, 1, 1);

  }

  public static StackPane generateCard(String text) {
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

  public BorderPane generateInfoString(String description, String value) {
    if (value == null) {
      value = "None";
    }
    BorderPane information = new BorderPane();
    Text text = new Text(description);
    text.setFont(Font.font("Arial", FontWeight.BOLD, 20));
    text.setFill(Color.BLACK);
    information.setLeft(text);

    VBox vbox = new VBox();
    vbox.setAlignment(Pos.CENTER);
    Text valueText = new Text(value);
    valueText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
    valueText.setFill(Color.BLACK);
    vbox.getChildren().add(valueText);
    information.setCenter(vbox);

    return information;

  }
}
