package com.snu.lab;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class ButtonApplication extends Application {
    private Button btn1;

    @Override
    public void start(Stage stage) throws IOException {

        Group root = new Group();
        Scene scene = new Scene(root, 300, 300, Color.LIGHTBLUE);

        root.getChildren().add(createBtn1());
        root.getChildren().add(createBtn2());

        stage.setTitle("Laboratory 1: Buttons");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private Button createBtn1() {
        btn1 = new Button();
        btn1.setLayoutX(20);
        btn1.setLayoutY(20);
        btn1.setText("Test button 1");
        btn1.setOnAction(action -> System.out.println(
            "Blend Mode: " + btn1.blendModeProperty().getValue() + "\n" +
            "Bounds in local: " + btn1.boundsInLocalProperty().getValue() + "\n"
        ));
        return btn1;
    }

    private Button createBtn2() {
        Button btn = new Button();
        btn.setLayoutX(20);
        btn.setLayoutY(150);
        btn.setText("Set styles");
        btn.setStyle(
                "-fx-font: bold italic 12pt Arial;" +
                        "-fx-text-fill: #660000; " +
                        "-fx-background-color: #ff99ff; " +
                        "-fx-border-width: 3px; " +
                        "-fx-border-radius: 30; " +
                        "-fx-background-radius: 30;" +
                        "-fx-border-color: #660066;"
        );
        btn.setPrefSize(200, 30);
        btn.setOnAction(action -> modifyBtn1());
        return btn;
    }

    private void modifyBtn1() {
        btn1.setBlendMode(BlendMode.DARKEN);
        Circle clip = new Circle(75, 53, 80);
        btn1.setClip(clip);
        btn1.setCursor(Cursor.CLOSED_HAND);

        DropShadow effect = new DropShadow();
        effect.setOffsetX(10);
        effect.setOffsetY(10);
        btn1.setEffect(effect);
        btn1.setOpacity(0.5);
        btn1.setRotate(10);
        btn1.setLayoutX(80);
        btn1.setScaleX(1.8);
        btn1.setLayoutY(170);
        btn1.setTranslateZ(-50);
        btn1.setPrefSize(150, 100);
        btn1.setTooltip(new Tooltip("This is a test btn"));

        Image img;
        ImageView imv;

        try {
            img = new Image("image.jpeg");
            imv = new ImageView(img);
            imv.setFitHeight(50);
            imv.setFitWidth(50);
            btn1.setGraphic(imv);
        } catch (Exception e) {
            e.printStackTrace();
        }

        btn1.setStyle("-fx-font: bold italic 10pt Helvetica;");
        btn1.setAlignment(Pos.CENTER);
        btn1.setContentDisplay(ContentDisplay.RIGHT);
        btn1.setUnderline(true);
        btn1.setWrapText(true);

        return;
    }
}
