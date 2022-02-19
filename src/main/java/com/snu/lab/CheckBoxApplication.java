package com.snu.lab;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class CheckBoxApplication extends Application {
    Button btn1;
    CheckBox ckb1;

    @Override
    public void start(Stage stage) throws IOException {

        Group root = new Group();
        Scene scene = new Scene(root, 300, 300, Color.LIGHTBLUE);

        ckb1 = createCheckBox();
        btn1 = createButton();

        btn1.setOnAction(action -> {
            if (Boolean.TRUE.equals(ckb1.selectedProperty().getValue())) {
                DropShadow effect = new DropShadow();
                effect.setOffsetX(5);
                effect.setOffsetY(10);

                ckb1.setBlendMode(BlendMode.HARD_LIGHT);
                ckb1.setCursor(Cursor.CROSSHAIR);
                ckb1.setEffect(effect);
                ckb1.setLayoutX(50);
                ckb1.setTranslateZ(-50);
                ckb1.setScaleX(1.8);
                ckb1.setPrefSize(150, 50);
                ckb1.setTooltip(new Tooltip("Test checkbox"));
                ckb1.setStyle("-fx-font: bold italic 10pt Helvetica;");
                ckb1.setAlignment(Pos.CENTER);
                ckb1.setContentDisplay(ContentDisplay.RIGHT);
                ckb1.setUnderline(true);
                ckb1.setWrapText(true);
                ckb1.setAllowIndeterminate(true);

                try {
                    Image img = new Image("image.jpeg");
                    ImageView imv = new ImageView(img);
                    imv.setFitHeight(50);
                    imv.setFitWidth(50);
                    ckb1.setGraphic(imv);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        root.getChildren().add(ckb1);
        root.getChildren().add(btn1);

        stage.setTitle("Laboratory 1: Checkbox");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private CheckBox createCheckBox() {
        CheckBox ckb = new CheckBox("Test properties");
        ckb.setLayoutX(20);
        ckb.setLayoutY(20);
        ckb.setOnMousePressed(action -> System.out.println(
                "Blend Mode: " + ckb.blendModeProperty().getValue() + "\n" +
                        "Bounds in local: " + ckb.boundsInLocalProperty().getValue() + "\n"
        ));
        return ckb;
    }

    private Button createButton() {
        Button btn = new Button();
        btn.setLayoutX(20);
        btn.setLayoutY(100);
        btn.setText("Установить свойства");
        btn.setStyle(
                "-fx-font: bold italic 12pt Arial;" +
                        "-fx-text-fill: white;" +
                        "-fxbackground-color: #0000cc;" +
                        "-fx-border-width: 3px; " +
                        "-fx-border-color:#6699ff #000066 #000066 #6699ff;"
        );
        btn.setPrefSize(200, 30);
        return btn;
    }
}
