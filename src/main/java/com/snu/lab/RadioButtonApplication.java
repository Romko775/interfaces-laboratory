package com.snu.lab;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class RadioButtonApplication extends Application {
    private final String fontStyle = "-fx-font: bold italic 12pt Georgia;";

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 400, 400, Color.LIGHTGREEN);
        stage.setScene(scene);
        stage.setTitle("Тестування GUI-компонентів: RadioButton");

        ToggleGroup tgroup = new ToggleGroup();
        RadioButton btnOn = createBtnOn(tgroup, scene);
        RadioButton btnOff = createBtnOff(tgroup, scene);

        root.getChildren().add(btnOn);
        root.getChildren().add(btnOff);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private RadioButton createBtnOn(ToggleGroup tgroup, Scene scene) {
        RadioButton _btnOn = new RadioButton("Mozilla Firefox");

        _btnOn.setLayoutX(20);
        _btnOn.setLayoutY(20);
        _btnOn.setBlendMode(BlendMode.MULTIPLY);
        _btnOn.setCursor(Cursor.CLOSED_HAND);
        _btnOn.setPrefSize(200, 80);
        _btnOn.setTooltip(new Tooltip("Це кнопка вибору Mozilla Firefox"));

        Image imOn = new Image("happysmile.png");
        ImageView imvOn = new ImageView(imOn);
        imvOn.setFitHeight(50);
        imvOn.setFitWidth(50);

        _btnOn.setGraphic(imvOn);
        _btnOn.setStyle(fontStyle);
        _btnOn.setAlignment(Pos.CENTER);
        _btnOn.setContentDisplay(ContentDisplay.RIGHT);
        _btnOn.setTextAlignment(TextAlignment.CENTER);
        _btnOn.setGraphicTextGap(10);
        _btnOn.setWrapText(true);
        _btnOn.setToggleGroup(tgroup);
        _btnOn.requestFocus();
        _btnOn
                .selectedProperty()
                .addListener((javafx.beans.value.ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) ->
                {
                    if (new_val.equals(Boolean.TRUE)) scene.setFill(Color.web("#fff8dc"));
                });
        return _btnOn;
    }

    private RadioButton createBtnOff(ToggleGroup tgroup, Scene scene) {
        RadioButton _btnOff = new RadioButton("Internet Explorer");
        _btnOff.setLayoutX(20);
        _btnOff.setLayoutY(100);
        _btnOff.setBlendMode(BlendMode.MULTIPLY);
        _btnOff.setCursor(Cursor.CLOSED_HAND);

        _btnOff.setPrefSize(200, 80);
        _btnOff.setTooltip(new Tooltip("Це кнопка вибору Internet Explorer"));

        Image imOf = new Image("sadsmile.jpg");
        ImageView imvOf = new ImageView(imOf);
        imvOf.setFitHeight(50);
        imvOf.setFitWidth(50);

        _btnOff.setGraphic(imvOf);
        _btnOff.setStyle(fontStyle);
        _btnOff.setAlignment(Pos.CENTER);
        _btnOff.setContentDisplay(ContentDisplay.RIGHT);
        _btnOff.setTextAlignment(TextAlignment.CENTER);
        _btnOff.setGraphicTextGap(10);
        _btnOff.setWrapText(true);
        _btnOff.setToggleGroup(tgroup);
        _btnOff
                .selectedProperty()
                .addListener((javafx.beans.value.ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) ->
                {
                    if (new_val.equals(Boolean.TRUE)) scene.setFill(Color.web("#99ffff"));
                });
        return _btnOff;
    }
}
