package com.snu.lab;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChoiceBoxApplication extends Application {
    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 400, 300, Color.BEIGE);

        ObservableList<String> country = FXCollections.observableArrayList("Україна", "США", "Великобританія");

        ChoiceBox<String> choice = new ChoiceBox<>(country);
        choice.setLayoutX(10);
        choice.setLayoutY(10);
        choice.setBlendMode(BlendMode.HARD_LIGHT);
        choice.setCursor(Cursor.CLOSED_HAND);

        DropShadow effect = new DropShadow();
        effect.setOffsetX(8);
        effect.setOffsetY(8);

        choice.setEffect(effect);
        choice.setStyle("-fx-text-fill:#000000;-fx-border-width:5pt;-fx-bordercolor:#d2691e;-fx-font:bold italic 12pt Georgia;");
        choice.setPrefSize(200, 50);
        choice.setTooltip(new Tooltip("Виберіть країну"));
        choice.getSelectionModel().selectFirst();

        ImageView imvUSA = createImageView("usa.jpg");
        ImageView imvUA = createImageView("ua.jpg");
        ImageView imvGB = createImageView("gb.jpeg");

        imvUA.setVisible(true);

        choice.getSelectionModel()
                .selectedItemProperty()
                .addListener((ObservableValue<? extends String> ov, String old_val, String new_val) ->
                {
                    if (new_val.equals("Україна")) {
                        imvUSA.setVisible(false);
                        imvUA.setVisible(true);
                        imvGB.setVisible(false);
                    }
                    if (new_val.equals("США")) {
                        imvUSA.setVisible(true);
                        imvUA.setVisible(false);
                        imvGB.setVisible(false);
                    }
                    if (new_val.equals("Великобританія")) {
                        imvUSA.setVisible(false);
                        imvUA.setVisible(false);
                        imvGB.setVisible(true);
                    }
                });

        root.getChildren().add(choice);
        root.getChildren().add(imvUSA);
        root.getChildren().add(imvUA);
        root.getChildren().add(imvGB);

        stage.setScene(scene);
        stage.setTitle("Тестування GUI-компонентів: ChoiceBox");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private ImageView createImageView(String path) {
        System.out.println(path);
        Image _img = new Image(path);
        ImageView _imgView = new ImageView(_img);
        _imgView.setPreserveRatio(true);
        _imgView.setFitHeight(200);
        _imgView.setFitWidth(200);
        _imgView.setLayoutX(10);
        _imgView.setLayoutY(100);
        _imgView.setVisible(false);
        return _imgView;
    }
}
