package com.snu.lab;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class ToggleButtonApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 430, 400, Color.LIGHTGREEN);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Тестування GUI-компонентів: ToggleButton");

        DropShadow effect = new DropShadow();
        effect.setOffsetX(5);
        effect.setOffsetY(5);

        ToggleGroup tgroup = new ToggleGroup();
        ToggleButton btnOn = createBtnOn(tgroup, effect, scene);
        ToggleButton btnOff = createBtnOff(tgroup, effect, scene);


        btnOn.setOnAction((ActionEvent e) -> log(btnOn, btnOff));
        btnOff.setOnAction((ActionEvent e) -> log(btnOn, btnOff));


        root.getChildren().add(btnOn);
        root.getChildren().add(btnOff);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void log(ToggleButton _btnOn, ToggleButton _btnOff) {
        System.out.println("JavaFX:" + _btnOn.selectedProperty().getValue());
        System.out.println("Silverlight:" + _btnOff.selectedProperty().getValue());
    }

    private ToggleButton createBtnOn(ToggleGroup _tgroup, DropShadow effect, Scene scene) {
        Image imgOn = new Image("image.jpeg");
        ImageView imvON = new ImageView(imgOn);
        imvON.setFitHeight(50);
        imvON.setFitWidth(50);

        ToggleButton _btnOn = new ToggleButton("JavaFX");
        _btnOn.setLayoutX(10);
        _btnOn.setLayoutY(10);
        _btnOn.setCursor(Cursor.CLOSED_HAND);
        _btnOn.setEffect(effect);

        _btnOn.setPrefSize(200, 80);
        _btnOn.setTooltip(new Tooltip("Це кнопка вибору платформи JavaFX"));
        _btnOn.setGraphic(imvON);

        _btnOn.setStyle("-fx-base:#9900ff; -fx-font: bold italic 16pt Georgia; -fx-textfill:white;");

        _btnOn
                .selectedProperty()
                .addListener((javafx.beans.value.ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                    if (new_val.equals(Boolean.TRUE)) {
                        _btnOn.setStyle("-fx-base:#9900ff; -fx-font: bold italic 16pt Georgia; -fx-text-fill:white;");
                        imvON.setFitHeight(40);
                        imvON.setFitWidth(40);
                        scene.setFill(Color.web("#ffff00"));
                        System.out.println("Використовую JavaFX");
                    }
                    if (new_val.equals(Boolean.FALSE)) {
                        _btnOn.setStyle("-fx-base:#9900ff; -fx-font: bold italic 18pt Georgia; -fx-text-fill:white;");
                        imvON.setFitHeight(50);
                        imvON.setFitWidth(50);
                        scene.setFill(Color.LIGHTGREEN);
                    }
                });

        _btnOn.setAlignment(Pos.CENTER);
        _btnOn.setContentDisplay(ContentDisplay.LEFT);
        _btnOn.setTextAlignment(TextAlignment.CENTER);
        _btnOn.setGraphicTextGap(20);
        _btnOn.setWrapText(true);
        _btnOn.setToggleGroup(_tgroup);
        return _btnOn;
    }

    private ToggleButton createBtnOff(ToggleGroup _tgroup, DropShadow effect, Scene scene) {
        ToggleButton _btnOff = new ToggleButton("Silverlight");
        Image imgOff = new Image("image.jpeg");
        ImageView imvOff = new ImageView(imgOff);
        imvOff.setFitHeight(50);
        imvOff.setFitWidth(50);

        _btnOff.setLayoutX(220);
        _btnOff.setLayoutY(10);
        _btnOff.setCursor(Cursor.CLOSED_HAND);
        _btnOff.setEffect(effect);

        _btnOff.setPrefSize(200, 80);
        _btnOff.setTooltip(new Tooltip("Це кнопка вибору платформи Silverlight"));
        _btnOff.setGraphic(imvOff);

        _btnOff.setStyle("-fx-base:#ff0000; -fx-font: bold italic 14pt Georgia; -fx-text-fill:white;");

        _btnOff
                .selectedProperty()
                .addListener((javafx.beans.value.ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                    if (new_val.equals(Boolean.TRUE)) {
                        _btnOff.setStyle("-fx-base:#ff0000; -fx-font: bold italic 12pt Georgia;-fxtext-fill:white;");
                        imvOff.setFitHeight(40);
                        imvOff.setFitWidth(40);
                        scene.setFill(Color.web("#660000"));
                        System.out.println("Використовую Silverlight");
                    }
                    if (new_val.equals(Boolean.FALSE)) {
                        _btnOff.setStyle("-fx-base:#ff0000; -fx-font: bold italic 14pt Georgia; -fxtext-fill:white;");
                        imvOff.setFitHeight(50);
                        imvOff.setFitWidth(50);
                        scene.setFill(Color.LIGHTGREEN);
                    }
                });

        _btnOff.setAlignment(Pos.CENTER);
        _btnOff.setContentDisplay(ContentDisplay.LEFT);
        _btnOff.setTextAlignment(TextAlignment.CENTER);
        _btnOff.setGraphicTextGap(20);
        _btnOff.setWrapText(true);
        _btnOff.setToggleGroup(_tgroup);
        return _btnOff;
    }
}
