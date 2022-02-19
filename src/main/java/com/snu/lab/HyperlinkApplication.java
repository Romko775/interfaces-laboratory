package com.snu.lab;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;

public class HyperlinkApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Group root = new Group();
        Scene scene = new Scene(root, 300, 300, Color.LIGHTCORAL);

        Hyperlink hlink = createHyperLink();

        hlink.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Group root = new Group();
                Scene sceneTwo = new Scene(root, 300, 300, Color.LIGHTGREEN);
                Text text = new Text(
                        "Node:" + "\n" +
                                "BlendMode: " + hlink.blendModeProperty().getValue() + "\n" +
                                "Cursor: " + hlink.cursorProperty().getValue() + "\n" +
                                "Effect: " + hlink.effectProperty().getValue() + "\n"
                );

                ScrollPane scp = createScrollPane(text);

                Button btn = createButton("Back");

                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        hlink.setTextFill(Color.RED);
                        Group root = new Group();
                        root.getChildren().add(hlink);
                        Scene sceneOne = new Scene(root, 300, 300, Color.LIGHTCORAL);
                        stage.setScene(sceneOne);
                    }
                });

                root.getChildren().add(scp);
                root.getChildren().add(btn);

                stage.setScene(sceneTwo);
            }
        });

        hlink.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!hlink.isVisited()) {
                    hlink.setTextFill(Color.BLUE);
                    hlink.setStyle("-fx-font: bold italic 16pt Georgia;");
                }
            }
        });

        hlink.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!hlink.isVisited()) {
                    hlink.setTextFill(Color.RED);
                    hlink.setStyle("-fx-font: bold italic 16pt Georgia;");
                }
            }
        });

        hlink.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!hlink.isVisited()) {
                    hlink.setTextFill(Color.BLACK);
                    hlink.setStyle("-fx-font: bold italic 14pt Georgia;");
                }
            }
        });

        root.getChildren().add(hlink);
        stage.setTitle("Laboratory 3: Hyperlink");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private Hyperlink createHyperLink() {
        Hyperlink hlink = new Hyperlink("Test Link");
        hlink.setLayoutX(20);
        hlink.setLayoutY(20);
        hlink.setBlendMode(BlendMode.HARD_LIGHT);
        hlink.setCursor(Cursor.CLOSED_HAND);

        DropShadow effect = new DropShadow();
        effect.setOffsetX(10);
        effect.setOffsetY(10);

        hlink.setEffect(effect);
        hlink.setPrefSize(200, 50);

        hlink.setTooltip(new Tooltip("Hyperlink Test"));

        try {
            Image img = new Image("image.jpeg");
            ImageView imv = new ImageView(img);
            imv.setFitHeight(50);
            imv.setFitWidth(50);
            hlink.setGraphic(imv);
        } catch (Exception e) {
            e.printStackTrace();
        }

        hlink.setStyle("-fx-font: bold italic 14pt Georgia;");
        hlink.setAlignment(Pos.CENTER);
        hlink.setTextAlignment(TextAlignment.CENTER);
        hlink.setContentDisplay(ContentDisplay.RIGHT);
        hlink.setWrapText(true);

        return hlink;
    }

    private ScrollPane createScrollPane(Node text) {
        ScrollPane scp = new ScrollPane();
        scp.setContent(text);
        scp.setPrefSize(290, 250);
        scp.setLayoutX(5);
        scp.setLayoutY(5);
        return scp;
    }

    private Button createButton(String text) {
        Button btn = new Button();
        btn.setLayoutX(20);
        btn.setLayoutY(270);
        btn.setText(text);
        return btn;
    }
}
